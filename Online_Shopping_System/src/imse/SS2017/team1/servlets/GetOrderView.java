package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.model.Product;

/**
 * Servlet implementation class GetOrderView
 */
@WebServlet("/GetOrderView")
public class GetOrderView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Eintritt in getOrderView");
		List<Product> productsInCart=(ArrayList<Product>)request.getSession().getAttribute("productsInCart");
		Map<Product, Integer> quantityByProduct=new HashMap<Product, Integer>(); 
		
		for(int i=0;i<productsInCart.size();i++){
				quantityByProduct.put(productsInCart.get(i), Integer.parseInt(request.getParameter("quantityInputName"+productsInCart.get(i).getProductId())));
			}
		
		request.setAttribute("quantityByProduct", quantityByProduct);
		System.out.println("Austritt aus getOrderView");
		request.getRequestDispatcher("getOrderView.jsp").forward(request, response);
		
		}
		
	}


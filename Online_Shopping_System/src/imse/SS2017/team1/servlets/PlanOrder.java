package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.OrderController;
import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.CustomerOrder;
import imse.SS2017.team1.model.OrderDetail;
import imse.SS2017.team1.model.Product;



/**
 * Servlet implementation class PlanOrder
 */
@WebServlet("/planOrder")
public class PlanOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=new Dao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> sessionAttributes=request.getSession().getAttributeNames();
		
		String attribute = null;
		for (Enumeration<String> sessionAttribute=sessionAttributes ; sessionAttribute.hasMoreElements();){
			attribute = sessionAttribute.nextElement();
			if (attribute.startsWith("productId_")||attribute.equals("productsInCart")) {
				request.getSession().removeAttribute(attribute);
			}
			
		 }
		
		OrderController ordercontroller=new OrderController();
		Map<Product,Integer> quantityByProduct=(HashMap<Product,Integer>)request.getSession().getAttribute("quantityByProduct");
		
		if(quantityByProduct!=null){
		CustomerOrder customerOrder=ordercontroller.createCustomerOrder((String)request.getSession().getAttribute("email"));
		
		
		
		for (Entry<Product, Integer> entry : quantityByProduct.entrySet())
		{
			
			ordercontroller.createOrderDetail(customerOrder, entry.getKey(), entry.getValue());
			
			//quantity bei Product aktualisieren
			entry.getKey().setQuantity(entry.getKey().getQuantity()-entry.getValue());
			dao.updateEntity(entry.getKey());
			
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
		
		//quantityByProduct wird gelöscht
		request.getSession().removeAttribute("quantityByProduct");
		response.sendRedirect("congratulation.jsp");
		}
	
	
	}
	
	

}

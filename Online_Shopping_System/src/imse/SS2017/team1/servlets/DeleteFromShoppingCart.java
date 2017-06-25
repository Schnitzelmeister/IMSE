package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.model.Product;

/**
 * Servlet implementation class DeleteFromShoppingCart
 */
@WebServlet("/DeleteFromShoppingCart")
public class DeleteFromShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Product> productsinCart=(List<Product>)request.getSession().getAttribute("productsInCart");
		String deleteProductId=request.getParameter("productId");
		request.getSession().removeAttribute("productId_"+deleteProductId);
		for(int i=0;i<productsinCart.size();i++){
			if(productsinCart.get(i).getProductId().toString().equals(deleteProductId)){
				productsinCart.remove(i);
				break;
			}
		}
		
		response.sendRedirect("GetShoppingCart");
		
	}



}


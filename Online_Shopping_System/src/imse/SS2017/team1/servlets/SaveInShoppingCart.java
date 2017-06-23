package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveInShoppingCart
 */
@WebServlet("/saveInShoppingCart")
public class SaveInShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productId=request.getParameter("productId");
		System.out.println(productId);
		request.getSession().setAttribute(productId,productId);
		response.sendRedirect("products.jsp");
		System.out.println("SaveINShoppingCart");
	}

}



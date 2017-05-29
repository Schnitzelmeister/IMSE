package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.model.Product;

/**
 * Servlet implementation class BuyProduct
 */
@WebServlet("/BuyProduct")
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Integer productId=Integer.parseInt(request.getParameter("auswahl"));
		Product auswahl=(Product) new ProductController().getProductById(productId);
		System.out.println("Produktpreis: "+auswahl.getPrice());
		System.out.println("Das Produkt heisst"+auswahl.getProductName()+"...");
		
	}

}

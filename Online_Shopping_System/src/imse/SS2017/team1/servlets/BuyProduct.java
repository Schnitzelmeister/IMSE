package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.model.Customer;
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
		
		Integer productId=Integer.parseInt(request.getParameter("product"));
		Product auswahl=(Product) new ProductController().getProductById(productId);
		try {
			request.getSession().setAttribute("product", auswahl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("customer");
		
		
		try {
			if((customer.getCreditCardInfo()==null)){
				
				request.getRequestDispatcher("newCreditCard.jsp").forward(request, response);
				
			}
			
			else{
				request.setAttribute("CreditCard", customer.getCreditCardInfo());
				request.getRequestDispatcher("updateCreditCard.jsp").forward(request, response);
			}
			
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Produktpreis: "+auswahl.getPrice());
		System.out.println("Das Produkt heisst"+auswahl.getProductName()+"...");
		
	}

}

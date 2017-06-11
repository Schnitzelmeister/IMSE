
package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.Admin;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.Product;
import imse.SS2017.team1.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("passwort");

		UserController usercontroller = new UserController();

		Customer currentUser = usercontroller.searchCustomer(email);
		Admin admin = null;

		if (currentUser == null) {
			admin = usercontroller.searchAdmin(email);
			try {
				if (admin == null)
					throw new IllegalArgumentException("Email Adresse existiert nicht");
				if (!admin.getPassword().equals(password))
					throw new IllegalArgumentException("Das Passwort ist nicht korrekt");
			} catch (IllegalArgumentException e) {
				System.out.println("IllegalArgumentException: " + e.getMessage());
				response.sendRedirect(
						"/Online_Shopping_System/customer/customerlogin.jsp?errorMessage=" + e.getMessage());
				return;
			} catch (Exception e) {
				System.out.println("Exception: " + e.getClass() + " Message: " + e.getMessage());
				return;
			}

			if (admin != null) {
				HttpSession session = request.getSession();
				if (admin.getManagerEmailAddress().equals(admin.getEmailAddress())) {
					session.setAttribute("adminType", "chiefadmin");
				} else {
					if (admin.isVerified()) {
						session.setAttribute("adminType", "admin");
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("adminIndex");
				rd.forward(request, response);
			}
		}
		if (admin == null) {
			try {
				if (!currentUser.getPassword().equals(password))
					throw new IllegalArgumentException("Das Passwort ist nicht korrekt");
			} catch (IllegalArgumentException e) {
				System.out.println("IllegalArgumentException: " + e.getMessage());
				response.sendRedirect(
						"/Online_Shopping_System/customer/customerlogin.jsp?errorMessage=" + e.getMessage());
				return;
			} catch (Exception e) {
				System.out.println("Exception: " + e.getClass() + " Message: " + e.getMessage());
				return;
			}

			if (currentUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("usertype", "customer");
				System.out.println("currentUser ist nicht null "+" name: "+currentUser.getEmailAddress());
				//NICHT AUSKOMMENTIEREN !!!
				session.setAttribute("email", currentUser.getEmailAddress());
				//NICHT AUSKOMMENTIEREN !!!
				System.out.println("attribut wurde gesetzt ");
				
				//session.setAttribute("customerName",currentUser.getFirstName()+"
				// "+ currentUser.getLastName());
				session.setAttribute("customer", currentUser);

				ProductController productController = new ProductController();
				List<Product> products = productController.GetAllProducts();

				//am 09-06 // session.setAttribute("products", products);

				// request.setAttribute("products", products);
				// RequestDispatcher
				// dispatcher=request.getRequestDispatcher("allProducts.jsp");

				// dispatcher.forward(request, response);
				response.sendRedirect("products.jsp");
				return;
			}
		}

	}

}
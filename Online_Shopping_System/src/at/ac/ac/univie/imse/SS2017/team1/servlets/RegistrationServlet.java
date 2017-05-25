package at.ac.ac.univie.imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.ac.ac.univie.imse.SS2017.team1.controller.UserController;
import at.ac.ac.univie.imse.SS2017.team1.dao.DaoInterface;
import at.ac.ac.univie.imse.SS2017.team1.model.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserController controls;

	/**
	 * Default constructor.
	 */
	public RegistrationServlet() {
		controls = new UserController();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String firstname = request.getParameter("");
			String lastname = request.getParameter("");
			String email = request.getParameter("");
			String password = request.getParameter("");
			String telephonenr = request.getParameter("");

			//controls.verifyUserInput(firstname, lastname, email, password, telephonenr);

			Customer newCustomer = new Customer(email, password, true, firstname, lastname, "", "", telephonenr, "");
			controls.registerCustomer(newCustomer);
			
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", e.getMessage());
		} catch (Exception e) {
			
		}

	}

}

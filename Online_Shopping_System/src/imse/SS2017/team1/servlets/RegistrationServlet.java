package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegistrationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserController controls = new UserController();

			String firstname = request.getParameter("vorname");
			String lastname = request.getParameter("nachname");
			String email = request.getParameter("email");
			String password = request.getParameter("passwort");
			String telephonenr = request.getParameter("telefonnummer");

			controls.verifyUserInput(firstname, lastname, email, password, telephonenr);

			Customer newCustomer = new Customer(email, password, firstname, lastname, true, null, null, telephonenr);
			controls.registerCustomer(newCustomer);
			response.sendRedirect(
					"/Online_Shopping_System/index.jsp?infoMessage=Das Konto wurde erfolgreich erstellt, melden Sie sich bitte an");
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", e.getMessage());
			response.sendRedirect("/Online_Shopping_System/newaccount.jsp?errorMessage=" + e.getMessage());
		}

	}

}

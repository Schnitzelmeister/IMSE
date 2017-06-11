package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.Customer;


@WebServlet("/editinfo")
public class EditCustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCustomerInfoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String email = (String) request.getSession().getAttribute("email");
			DaoInterface dao = new Dao();
			Customer user = dao.getobject(Customer.class, email);
			
			String vorname = request.getParameter("vorname");
			String nachname = request.getParameter("nachname");
			String telefonr = request.getParameter("telefonnummer");
			String passwort = request.getParameter("passwort");

			user.setFirstName(vorname);
			user.setLastName(nachname);
			user.setPhoneNumber(telefonr);


			if (passwort.length() != 0) { //Wenn der Benutzer das Passwortfeld leer lässt wird nichts am Passwort geändert
				if (passwort.length() < 8)
					throw new IllegalArgumentException("Das Passwort muss mindestens 8 Zeichen lang sein");
				else
					user.setPassword(passwort);
			}
			
			dao.updateEntity(user);
			response.sendRedirect("/Online_Shopping_System/customer/private/editcustomerinfo.jsp?infoMessage=Die Kontodaten wurden gespeichert");
		} catch (IllegalArgumentException e) {
			response.sendRedirect(
					"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?errorMessage=" + e.getMessage());
		} catch (Exception e) { //DB Exception werden abgefangen
			response.sendRedirect(
					"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?errorMessage=" + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}

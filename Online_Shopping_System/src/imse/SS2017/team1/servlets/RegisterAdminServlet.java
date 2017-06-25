package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.Admin;

/**
 * Servlet implementation class RegisterAdminServlet
 */
@WebServlet("/registeradmin")
public class RegisterAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterAdminServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DaoInterface dao = new Dao();

			String adminMail = request.getParameter("email");
			String managerMail = request.getParameter("manageremail");
			String vorname = request.getParameter("vorname");
			String nachname = request.getParameter("nachname");
			String passwort = request.getParameter("passwort");

			Admin admin = new Admin(adminMail, passwort, vorname, nachname, managerMail, false);
			dao.save(admin);
			response.sendRedirect(
					"/Online_Shopping_System/newadmin.jsp?infoMessage=Das Adminkonto wurde erfolgreich erstellt, warten Sie auf die Bestätigung");
		} catch (IllegalArgumentException e) {
			response.sendRedirect(
					"/Online_Shopping_System/newadmin.jsp?errorMessage=FEHLER: "+e.getMessage());
		} catch (Exception e) {
			response.sendRedirect(
					"/Online_Shopping_System/newadmin.jsp?errorMessage=FEHLER: "+e.getMessage());
			System.out.println("Unspecified Exception occured: "+e.getClass()+" with Message: "+e.getMessage());
		}
	}
}

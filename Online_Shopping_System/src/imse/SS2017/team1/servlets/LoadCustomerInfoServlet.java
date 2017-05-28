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

/**
 * Servlet implementation class LoadCustomerInfoServlet
 */

public class LoadCustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoadCustomerInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoadInfoServlet für Kundendetails wurde aufgerufen");
		String email = (String) request.getSession().getAttribute("email");
		System.out.println("Name in session: "+email);
		DaoInterface dao = new Dao();
		Customer user=dao.getUser(Customer.class, email);
		System.out.println("Kundenobjekt wurde geladen: "+user.getEmailAddress());
		
		String emailAdress=user.getEmailAddress();
		String firstName=user.getFirstName();
		String lastName=user.getLastName();
		String phoneNumber=user.getPhoneNumber();
		//String creditCardInfo=user.getCreditCardInfo();
		
		request.setAttribute("email", emailAdress);
		request.setAttribute("vorname", firstName);
		request.setAttribute("nachname", lastName);
		request.setAttribute("telefonnummer", phoneNumber);
		//request.setAttribute("kreditkartennummer", creditCardInfo);   
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

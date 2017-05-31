package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;

/**
 * Servlet implementation class CheckAddress
 */
@WebServlet("/CheckAddress")
public class CheckAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer customer=new Customer();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		customer=(Customer)request.getSession().getAttribute("customer");
		if(customer.getShippingAddress()==null){
			response.sendRedirect("newShippingAdress.jsp");
		}
		else 
			response.sendRedirect("updateShippingAdress.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserController usercontroller=new UserController();
		String strassenname=request.getParameter("strassenname");
		String strassennummer=request.getParameter("strassennummer");
		String zusatzadresse=request.getParameter("zusatzadresse");
		String stadt=request.getParameter("stadt");
		String plz=request.getParameter("plz");
		String land=request.getParameter("land");
		Address adr=new Address(strassenname,strassennummer,zusatzadresse,stadt,plz,land);
		
		
		Customer customer=(Customer)request.getSession().getAttribute("customer");
		usercontroller.saveAddress(adr, customer);
		
		response.sendRedirect("NewBillingAdress.jsp");
		
	}

}

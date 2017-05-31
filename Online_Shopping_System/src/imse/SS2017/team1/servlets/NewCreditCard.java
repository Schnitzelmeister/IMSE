package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;

/**
 * Servlet implementation class NewCreditCard
 */
@WebServlet("/NewCreditCard")
public class NewCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserController usercontroller=new UserController();
		String kartennummer=request.getParameter("cardNumber");
		String vorname=request.getParameter("vorname");
		String nachname=request.getParameter("nachname");
		String kartentyp=request.getParameter("type");
		String cvv=request.getParameter("cvv");
		Integer monat=Integer.parseInt(request.getParameter("monat"));
		Integer jahr=Integer.parseInt(request.getParameter("jahr"));
		CreditCard cc=new CreditCard(kartennummer,vorname,nachname,kartentyp,cvv,monat,jahr);
		
		
		Customer customer=(Customer)request.getSession().getAttribute("customer");
		usercontroller.saveCreditCard(cc, customer);
	
		
		Enumeration<String> attributes=request.getSession().getAttributeNames();
		while(attributes.hasMoreElements()){
			System.out.println(attributes.nextElement());
		}
	}

}

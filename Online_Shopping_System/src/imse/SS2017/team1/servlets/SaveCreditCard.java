package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.filter.CreditCardValidator;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;

/**
 * Servlet implementation class SaveCreditCard
 */
@WebServlet("/saveCreditCard")
public class SaveCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCreditCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreditCardValidator validator=new CreditCardValidator();
		Map<String, Boolean> creditcard=new LinkedHashMap<String, Boolean>();
		
		String cardNumber=request.getParameter("cardNumber");
		if(validator.isCreditCardNumber(cardNumber))creditcard.put(cardNumber, true);
		else creditcard.put(cardNumber, false);
		
		String vorname=request.getParameter("vorname");
		if(validator.isName(vorname))creditcard.put(vorname, true);
		else creditcard.put(vorname, false);
		
		String nachname=request.getParameter("nachname");
		if(validator.isName(nachname))creditcard.put(nachname, true);
		else creditcard.put(nachname, false);
		
		//Type wird direkt gespeichert in Map, da es nur eine selection ist
		String type=request.getParameter("type");
		creditcard.put(type, true);
		
		String cvv=request.getParameter("cvv");
		if(validator.isCvv(cvv))creditcard.put(cvv, true);
		else creditcard.put(cvv, false);
		
		String monat=request.getParameter("monat");
		if(validator.isMonth(monat))creditcard.put(monat, true);
		else creditcard.put(monat, false);
		
		String jahr=request.getParameter("jahr");
		if(validator.isYear(jahr))creditcard.put(jahr, true);
		else creditcard.put(jahr, false);
		
		
		if(validator.isValidCreditCard(monat, jahr)){
			creditcard.put("AblaufDatum", true);
		}
		else creditcard.put("AblaufDatum", false);
		
		boolean invalid=true;
		
		for (Entry<String, Boolean> entry : creditcard.entrySet())
		{
			System.out.println(entry.getKey());
		    if(entry.getValue()==false){
		    	
		        invalid=false;
		    }
		}
		if(invalid==false){
			request.setAttribute("creditCard",creditcard);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("errorBySaveCreditCard.jsp");
	    	dispatcher.forward(request, response);
		}
		CreditCard card=new CreditCard(cardNumber, vorname,  nachname, type, cvv,
				Integer.parseInt(monat), Integer.parseInt(jahr));
		//UserController controller=new UserController();
		Dao dao=new Dao();
		Customer customer=(Customer)request.getSession().getAttribute("customer");
		if(customer.getCreditCard()==null){
			customer.setCreditCard(card);
			dao.updateEntity(customer);//neu
			//controller.saveCreditCard(card,customer );
		}
		else if(customer.getCreditCard()!=null){
			//CreditCard alt=dao.getobject(CreditCard.class, customer.getCreditCardInfo());
			customer.setCreditCard(card);
			dao.updateEntity(customer);
			//controller.saveCreditCard(card, customer);
			
		}
		else
			System.out.println("Fehler in SaveCreditCard.java");;
			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("checkCreditCard.jsp");
		dispatcher.forward(request, response);
	}

}


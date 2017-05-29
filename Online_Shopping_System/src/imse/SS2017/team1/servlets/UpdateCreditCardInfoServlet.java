
package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.exceptions.DatabaseException;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;


@WebServlet("/updatecreditcard")
public class UpdateCreditCardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCreditCardInfoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DaoInterface dao = new Dao();
			String email = (String) request.getSession().getAttribute("email");
			Customer customer = dao.getUser(Customer.class, email);
			String creditCardNumber = customer.getCreditCardInfo();

			String cardNumber = request.getParameter("kreditkartennr");
			String cvv = request.getParameter("cvv");
			Integer expiryMonth = Integer.parseInt(request.getParameter("gueltigbismonat"));
			Integer expiryYear = Integer.parseInt(request.getParameter("gueltigbisjahr"));
			String firstNameOncard = request.getParameter("vornamekreditkarte");
			String lastNameOncard = request.getParameter("nachnamekreditkarte");
			String type = request.getParameter("typ");

			if (creditCardNumber == null) {
				CreditCard newCard = new CreditCard(cardNumber, firstNameOncard, lastNameOncard, type, cvv, expiryMonth,
						expiryYear);
				dao.save(newCard);
				customer.setCreditCardInfo(cardNumber);
				dao.updateEntity(customer);
				response.sendRedirect(
						"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?infoMessage=Die Kreditkartendaten wurden gespeichert");
			}else{
				//Poor method naming, intended purpose was different although also suitable for retrieving other objects than User
				CreditCard currentCard = dao.getUser(CreditCard.class, creditCardNumber);
				CreditCard currentCardforDeletion = dao.getUser(CreditCard.class, creditCardNumber);
				System.out.println("Kreditkarte mit nummer: "+currentCard.getCardNumber());
				if(dao.getUser(CreditCard.class, cardNumber) != null) throw new IllegalArgumentException("Die Kreditkarte mit dieser Nummer wird schon benutzt");
				
				customer.setCreditCardInfo(cardNumber);
				currentCard.setCardNumber(cardNumber);
				currentCard.setCvv(cvv);
				currentCard.setExpiryMonth(expiryMonth);
				currentCard.setExpiryYear(expiryYear);
				currentCard.setFirstName(firstNameOncard);
				currentCard.setLastName(lastNameOncard);
				currentCard.setType(type);
				dao.updateEntity(currentCard);
				System.out.println("Karte wird upgedated");
				dao.delete(currentCardforDeletion);
				dao.updateEntity(customer);
				response.sendRedirect(
						"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?infoMessage=Die Kreditkartendaten wurden aktualisiert");
			}
			
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
			response.sendRedirect(
					"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?errorMessage=" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Generic Exception: " + e.getMessage());
		}
	}
}

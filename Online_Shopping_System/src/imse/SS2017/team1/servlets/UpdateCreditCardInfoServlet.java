
package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			Customer customer = dao.getobject(Customer.class, email);
			CreditCard creditCard = customer.getCreditCard();

			String cardNumber = request.getParameter("kreditkartennr");
			String cvv = request.getParameter("cvv");
			Integer expiryMonth = Integer.parseInt(request.getParameter("gueltigbismonat"));
			Integer expiryYear = Integer.parseInt(request.getParameter("gueltigbisjahr"));
			String firstNameOncard = request.getParameter("vornamekreditkarte");
			String lastNameOncard = request.getParameter("nachnamekreditkarte");
			String type = request.getParameter("typ");

			if (creditCard == null) {
				CreditCard newCard = new CreditCard(null, cardNumber, firstNameOncard, lastNameOncard, type, cvv, expiryMonth,expiryYear);
				customer.setCreditCard(newCard);
				dao.updateEntity(customer);
				response.sendRedirect(
						"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?infoMessage=Die Kontodaten wurden aktualisiert");
			} else {
				CreditCard currentCard = customer.getCreditCard();
		
				currentCard.setCardNumber(cardNumber);
				currentCard.setCvv(cvv);
				currentCard.setExpiryMonth(expiryMonth);
				currentCard.setExpiryYear(expiryYear);
				currentCard.setFirstName(firstNameOncard);
				currentCard.setLastName(lastNameOncard);
				currentCard.setType(type);
				customer.setCreditCard(currentCard);
				dao.updateEntity(customer);
				response.sendRedirect(
						"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?infoMessage=Die Kontodaten wurden aktualisiert");
			}

		} catch (IllegalArgumentException e) {
			response.sendRedirect(
					"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?errorMessage=" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Generic Exception: " + e.getMessage());
		}
	}
}

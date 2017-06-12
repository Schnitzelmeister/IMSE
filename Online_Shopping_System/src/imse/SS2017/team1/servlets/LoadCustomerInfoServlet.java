
package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.CreditCard;

public class LoadCustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoadCustomerInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		DaoInterface dao = new Dao();
		Customer user = dao.getobject(Customer.class, email);

		String emailAdress = user.getEmailAddress();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String phoneNumber = user.getPhoneNumber();
		CreditCard creditCard = user.getCreditCard();
		Address shippingAddress = user.getShippingAdr();
		Address billingAddress = user.getBillingAdr();

		request.setAttribute("email", emailAdress);
		request.setAttribute("vorname", firstName);
		request.setAttribute("nachname", lastName);
		request.setAttribute("telefonnummer", phoneNumber);

		if (creditCard != null) {
			Integer expiryMonth = creditCard.getExpiryMonth();
			Integer expiryYear = creditCard.getExpiryYear();
			String cardNumber = creditCard.getCardNumber();
			String cvv = creditCard.getCvv();
			String firstNameOncard = creditCard.getFirstName();
			String lastNameOncard = creditCard.getLastName();
			String type = creditCard.getType();

			request.setAttribute("kreditkartennr", cardNumber);
			request.setAttribute("vornamekreditkarte", firstNameOncard);
			request.setAttribute("nachnamekreditkarte", lastNameOncard);
			request.setAttribute("typ", type);
			request.setAttribute("cvv", cvv);
			request.setAttribute("gueltigbismonat", Integer.toString(expiryMonth));
			request.setAttribute("gueltigbisjahr", Integer.toString(expiryYear));
		}

		if (billingAddress != null) {
			String city = billingAddress.getCity();
			String country = billingAddress.getCountry();
			String postCode = billingAddress.getPostCode();
			String streetName = billingAddress.getStreetName();
			String additionalInfo = billingAddress.getAdditionalInfo();
			String streetNumber = billingAddress.getStreetNumber();

			request.setAttribute("stadtr", city);
			request.setAttribute("strassennamer", streetName);
			request.setAttribute("hausnummerr", streetNumber);
			request.setAttribute("plzr", postCode);
			request.setAttribute("landr", country);
			request.setAttribute("infor", additionalInfo);
		}

		if (shippingAddress != null) {
			String city = shippingAddress.getCity();
			String country = shippingAddress.getCountry();
			String postCode = shippingAddress.getPostCode();
			String streetName = shippingAddress.getStreetName();
			String additionalInfo = shippingAddress.getAdditionalInfo();
			String streetNumber = shippingAddress.getStreetNumber();

			request.setAttribute("stadts", city);
			request.setAttribute("strassennames", streetName);
			request.setAttribute("hausnummers", streetNumber);
			request.setAttribute("plzs", postCode);
			request.setAttribute("lands", country);
			request.setAttribute("infos", additionalInfo);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

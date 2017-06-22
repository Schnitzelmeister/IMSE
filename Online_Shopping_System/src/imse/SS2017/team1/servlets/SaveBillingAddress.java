package imse.SS2017.team1.servlets;

import java.io.IOException;
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
import imse.SS2017.team1.filter.AddressValidator;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Customer;

/**
 * Servlet implementation class SaveBillingAddress
 */
@WebServlet("/saveBillingAddress")
public class SaveBillingAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveBillingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddressValidator validator = new AddressValidator();
		Map<String, Boolean> addressMap = new LinkedHashMap<String, Boolean>();

		String streetName = request.getParameter("streetName");
		if (validator.isStreetName(streetName))
			addressMap.put(streetName, true);
		else
			addressMap.put(streetName, false);

		String streetNumber = request.getParameter("streetNumber");
		if (validator.isStreetNumber(streetNumber))
			addressMap.put(streetNumber, true);
		else
			addressMap.put(streetNumber, false);

		String additionalInfo = request.getParameter("additionalInfo");
		if (additionalInfo == null)
			additionalInfo = "";
		if (validator.isAdditionalInfo(additionalInfo))
			addressMap.put(additionalInfo, true);
		else
			addressMap.put(additionalInfo, false);

		String city = request.getParameter("city");
		if (validator.isCity(city))
			addressMap.put(city, true);
		else
			addressMap.put(city, false);

		String postCode = request.getParameter("postCode");
		if (validator.isPostCode(postCode))
			addressMap.put(postCode, true);
		else
			addressMap.put(postCode, false);

		String country = request.getParameter("country");
		if (validator.isCountry(country))
			addressMap.put(country, true);
		else
			addressMap.put(country, false);

		boolean invalid = true;

		for (Entry<String, Boolean> entry : addressMap.entrySet()) {
			System.out.println(entry.getKey());
			if (entry.getValue() == false) {

				invalid = false;
			}
		}
		if (invalid == false) {
			request.setAttribute("addressMap", addressMap);
			RequestDispatcher dispatcher = request.getRequestDispatcher("errorBySaveBillingAddress.jsp");
			dispatcher.forward(request, response);
		}
		Address address = new Address(streetName, streetNumber, additionalInfo, city, postCode, country);
		UserController controller = new UserController();
		Dao dao = new Dao();
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if (customer.getBillingAddress() == null) {
			controller.saveBillingAddress(address, customer);
		} else if (customer.getBillingAddress() != null && !(address.getAdressId() == customer.getBillingAddress())) {
			Address alt = dao.getobject(Address.class, customer.getBillingAddress());
			dao.delete(alt);
			controller.saveBillingAddress(address, customer);

		} else
			dao.updateEntity(address);

		RequestDispatcher dispatcher = request.getRequestDispatcher("checkBillingAddress.jsp");
		dispatcher.forward(request, response);
	}
}

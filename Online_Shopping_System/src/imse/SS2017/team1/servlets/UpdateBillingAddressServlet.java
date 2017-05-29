
package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Customer;


@WebServlet("/updatebilling")
public class UpdateBillingAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateBillingAddressServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String email = (String) request.getSession().getAttribute("email");
			DaoInterface dao = new Dao();
			Customer user = dao.getobject(Customer.class, email);
			Integer billingAddressId = user.getBillingAddress();
			
			String stadt = request.getParameter("stadtr");
			String strassenname = request.getParameter("strassennamer");
			String hausnummer = request.getParameter("hausnummerr");
			String land = request.getParameter("landr");
			String plz = request.getParameter("plzr");
			String infos = request.getParameter("infor");
			
			if(billingAddressId == null){
				Address newAdresse = new Address(null, strassenname, hausnummer, infos, stadt, plz, land);
				Integer addressId=dao.saveAddress(newAdresse);
				user.setBillingAddress(addressId);
				dao.updateEntity(user);
				response.sendRedirect("/Online_Shopping_System/customer/private/editcustomerinfo.jsp?infoMessage=Die Rechnungsdaten wurden gespeichert");
			}else{
				Address currentAddress = dao.getobject(Address.class, billingAddressId);
				currentAddress.setAdditionaolInfo(infos);
				currentAddress.setCity(stadt);
				currentAddress.setCountry(land);
				currentAddress.setPostCode(plz);
				currentAddress.setStreetName(strassenname);
				currentAddress.setStreetNumber(hausnummer);
				dao.updateEntity(currentAddress);
				response.sendRedirect(
						"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?infoMessage=Die Rechnungsdaten wurden aktualisiert");
			} 
		} catch (IllegalArgumentException e) {
			response.sendRedirect(
					"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?errorMessage=" + e.getMessage());
		} catch (Exception e) { //DB Exception werden abgefangen
			System.out.println("Exceptiontype: " + e.getClass() + " Message: " + e.getMessage());
			response.sendRedirect(
					"/Online_Shopping_System/customer/private/editcustomerinfo.jsp?errorMessage=" + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.model.Customer;


@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		UserController userController = new UserController();
		List<Customer> customers = userController.searchAllCustomer();
		List<String> emails = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
		List<String> surNames = new ArrayList<String>();
		Integer anzahl = customers.size();
		for(Customer c:customers){
			emails.add(c.getEmailAddress());
			names.add(c.getLastName());
			surNames.add(c.getFirstName());
		}
		
		anzahl--;
		
		request.setAttribute("emails1", emails);
		request.setAttribute("names1", names);
		request.setAttribute("surNames1", surNames);
		request.setAttribute("anzahl1", anzahl);
		request.getRequestDispatcher("/deleteUser.jsp").forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		UserController userController = new UserController();
		String email = request.getParameter("deletedCustomerEmail").replaceAll("Lösche Kunden: ", "");
		userController.deleteAccount(email);
		
		doGet(request,response);
	}

}

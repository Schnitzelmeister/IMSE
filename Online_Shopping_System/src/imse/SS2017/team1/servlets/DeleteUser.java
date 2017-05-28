package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;

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

		UserController userController = new UserController();
		ArrayList<Customer> customers = (ArrayList<Customer>) userController.searchAllCustomer();
		request.setAttribute("customers", customers);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserController userController = new UserController();
		String email = request.getParameter("deletedCustomerEmail");
		userController.deleteAccount(email);
		
	}

}

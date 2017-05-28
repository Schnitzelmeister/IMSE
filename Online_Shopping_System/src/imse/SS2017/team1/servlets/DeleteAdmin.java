package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.UserController;
import imse.SS2017.team1.model.Admin;

@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserController userController = new UserController();
		ArrayList<Admin> admins = (ArrayList<Admin>) userController.searchAllAdmins();
		request.setAttribute("admins", admins);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserController userController = new UserController();
		String email = request.getParameter("deletedAdminEmail");
		userController.deleteAdminAccount(email);
		
	}

}

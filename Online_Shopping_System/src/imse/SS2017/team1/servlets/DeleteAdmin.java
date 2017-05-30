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
import imse.SS2017.team1.model.Admin;

@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserController userController = new UserController();
		List<Admin> admins = userController.searchAllAdmins();
		List<String> emails = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
		Integer anzahl = admins.size();
		for(Admin a:admins){
			emails.add(a.getEmailAddress());
			names.add(a.getLastName());
		}
		
		anzahl--;
		
		request.setAttribute("emails", emails);
		request.setAttribute("names", names);
		request.setAttribute("anzahl", anzahl);
		request.getRequestDispatcher("/deleteAdmin.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserController userController = new UserController();
		String email = request.getParameter("deletedAdminEmail");
		userController.deleteAdminAccount(email);
		
		doGet(request,response);
		
	}

}

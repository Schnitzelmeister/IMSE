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
	
		String adminTyp = null;
		Boolean isAdminAvailable = false;
		
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		UserController userController = new UserController();
		List<Admin> admins = userController.searchAllAdmins();
		List<String> emails = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
		List<String> surNames = new ArrayList<String>();
		Integer countMainAdmins=0;
		for(Admin a:admins){
			if(!a.getEmailAddress().equals(a.getManagerEmailAddress())){
				emails.add(a.getEmailAddress());
				names.add(a.getLastName());
				surNames.add(a.getFirstName());
			} else {
				++countMainAdmins;
			}
		}
		Integer anzahl1 = admins.size()-countMainAdmins;
		
		if(anzahl1>0){
			isAdminAvailable=true;
		}
		anzahl1--;
		
		request.setAttribute("surNames", surNames);
		request.setAttribute("emails", emails);
		request.setAttribute("names", names);
		request.setAttribute("anzahl1", anzahl1);
		request.setAttribute("isAdminAvailable", isAdminAvailable);
		request.getRequestDispatcher("/deleteAdmin.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		UserController userController = new UserController();
		String email = request.getParameter("deletedAdminEmail").replaceAll("Lösche Admin: ", "");
		userController.deleteAdminAccount(email);
		
		doGet(request,response);
		
	}

}

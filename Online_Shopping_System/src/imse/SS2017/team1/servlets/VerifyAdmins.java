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


@WebServlet("/VerifyAdmins")
public class VerifyAdmins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String adminTyp = null;
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
		Integer countMainVerifiedAdmins=0;
		for(Admin a:admins){
			if(!a.getEmailAddress().equals(a.getManagerEmailAddress()) && !a.isVerified()){
				emails.add(a.getEmailAddress());
				names.add(a.getLastName());
				surNames.add(a.getFirstName());
			} else {
				++countMainVerifiedAdmins;
			}
		}
		Integer anzahl = admins.size()-countMainVerifiedAdmins;
		
		anzahl--;
		
		request.setAttribute("surNames2", surNames);
		request.setAttribute("emails2", emails);
		request.setAttribute("names2", names);
		request.setAttribute("anzahl2", anzahl);
		request.getRequestDispatcher("/verifyAdmin.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		UserController userController = new UserController();		
		String email = request.getParameter("verifiedAdminEmail").replaceAll("Verifiziere Admin: ", "");
		userController.verifyAdmin(email);
		
		doGet(request,response);
		
	}
}

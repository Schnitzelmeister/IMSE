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
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
		 String password = request.getParameter("passwort");
		 
		 Customer currentUser;
		 DaoInterface dao = new Dao();
		
		 try{
			 currentUser = dao.getUser(Customer.class, email);
			 if(currentUser == null) throw new IllegalArgumentException("Die Anmeldedaten sind nicht korrekt");
			 if(!currentUser.getPassword().equals(password)) throw new IllegalArgumentException("Das Passwort ist nicht korrekt");
		 } catch(IllegalArgumentException e){
			 System.out.println("IllegalArgumentException: "+e.getMessage());
			 response.sendRedirect("/Online_Shopping_System/customer/customerlogin.jsp?errorMessage="+e.getMessage());
			 return;
		 } catch(Exception e){
			 System.out.println("Exception: "+e.getClass()+" Message: "+e.getMessage());
			 return;
		 }
		 
		 HttpSession session = request.getSession();
	     session.setAttribute("usertype", "customer");
	     session.setAttribute("email", currentUser.getEmailAddress());
	    	
	     response.sendRedirect("/Online_Shopping_System/index.jsp?infoMessage=Die Anmeldung war erfolgreich");
	     return;
	}

}

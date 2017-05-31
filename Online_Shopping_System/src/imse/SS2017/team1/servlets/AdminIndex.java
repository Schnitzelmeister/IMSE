package imse.SS2017.team1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminIndex")
public class AdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
	}

}

package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.model.Category;

@WebServlet(name="CreateNewProductCategory")
public class CreateNewProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryController categoryController = new CategoryController();
		ArrayList<Category> categories = (ArrayList<Category>) categoryController.getAllCategories();
		request.setAttribute("categories", categories);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryController categoryController = new CategoryController();
		
		String categoryName = request.getParameter("categoryName");
		
		categoryController.createCategory(categoryName);
		
		
	}

}

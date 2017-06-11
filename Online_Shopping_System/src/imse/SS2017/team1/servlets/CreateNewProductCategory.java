package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.filter.Validator;
import imse.SS2017.team1.model.Category;

@WebServlet("/CreateNewProductCategory")
public class CreateNewProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminTyp = null;
		Boolean isProductCategoryAvailable = false;
		
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		CategoryController categoryController = new CategoryController();
		List<Category> categories = categoryController.getAllCategories();
		Integer productCatCount = categories.size();
		
		if(productCatCount>0){
			isProductCategoryAvailable=true;
		}
		productCatCount--;
		
		request.setAttribute("productCatCount1", productCatCount);
		request.setAttribute("categories1", categories);
		request.setAttribute("isProductCategoryAvailable", isProductCategoryAvailable);
		request.getRequestDispatcher("/createNewProductCategory.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryController categoryController = new CategoryController();
		Validator validator = new Validator();
		
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		String categoryName = request.getParameter("productCategoryName");
		
		if(validator.isCategoryNameOk(categoryName)){
			categoryController.createCategory(categoryName);			
		} else {
			System.out.println("Bitte geben Sie einen aussagekräftigen Kategorienamen ein!");
		}
		
		doGet(request,response);
		
		
	}

}

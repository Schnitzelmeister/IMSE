package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.model.Category;

@WebServlet("/DeleteProductCategory")
public class DeleteProductCategory extends HttpServlet {
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
		
		request.setAttribute("categories", categories);
		request.setAttribute("productCatCount", productCatCount);
		request.setAttribute("isProductCategoryAvailable", isProductCategoryAvailable);
		request.getRequestDispatcher("/deleteProductCategory.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		CategoryController categoryController = new CategoryController();
		Integer categoryId = Integer.valueOf(request.getParameter("deletedCategoryId").replaceAll("\\D+", ""));
		categoryController.deleteCategory(categoryId);
		
		doGet(request,response);
	}

}

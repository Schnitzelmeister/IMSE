package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Product;

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		CategoryController categoryController = new CategoryController();
		ProductController productController = new ProductController();
		
		List<Category> categories = categoryController.getAllCategories();
		List<Product> products = productController.getAllProducts();
		
		Integer anzahl4 = categories.size();
		anzahl4--;
		Integer anzahl5 = products.size();
		anzahl5--;
		
		request.setAttribute("anzahl5", anzahl5);
		request.setAttribute("anzahl4", anzahl4);
		request.setAttribute("categories3", categories);
		request.setAttribute("products3", products);
		request.getRequestDispatcher("/editProduct.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		ProductController productController = new ProductController();
		Integer quantity = null;
		Float price = null;
		String description = null;
		String productName = null;
		
		if(!request.getParameter("productName").equals("Produktname")){
			productName = request.getParameter("productName");
		}
		if(!request.getParameter("productPrice").equals("Preis")){
			price = Float.valueOf(request.getParameter("productPrice"));
		}
		if(!request.getParameter("productDescription").equals("Beschreibung....")){
			description = request.getParameter("description");
		}
		if(!request.getParameter("productQuantity").equals("Anzahl")){
			quantity = Integer.valueOf(request.getParameter("productQuantity"));
		}
		Integer productId = Integer.valueOf(request.getParameter("productId").replaceAll("\\D+", ""));
	
		List<String> images = new ArrayList<String>();
		
		images.add(request.getParameter("image"));
		images.add(request.getParameter("image2"));
		images.add(request.getParameter("image3"));
		images.add(request.getParameter("image4"));
		images.add(request.getParameter("image5"));
		
		productController.updateProduct(productId, productName, price, description, quantity, images);
		
		doGet(request,response);
		
	}

}

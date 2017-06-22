package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.filter.Validator;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Product;

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminTyp = null;
		Boolean isProductAvailable = false;
		
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		CategoryController categoryController = new CategoryController();
		ProductController productController = new ProductController();
		
		List<Category> categories = categoryController.getAllCategories();
		List<Product> products = productController.GetAllProducts();
		
		Integer anzahl4 = categories.size();
		anzahl4--;
		Integer anzahl5 = products.size();

		if(anzahl5>0){
			isProductAvailable=true;
		}
		anzahl5--;
		
		request.setAttribute("anzahl5", anzahl5);
		request.setAttribute("anzahl4", anzahl4);
		request.setAttribute("categories3", categories);
		request.setAttribute("products3", products);
		request.setAttribute("isProductAvailable", isProductAvailable);
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
		Validator validator = new Validator();
		
		String productName = request.getParameter("productName");
		String quantity = request.getParameter("productQuantity");
		String price = request.getParameter("productPrice");
		String description = request.getParameter("productDescription");
		String[] selectedCat = request.getParameterValues("selectedCat");
		Integer productId = Integer.valueOf(request.getParameter("productId").replaceAll("\\D+", ""));
	
		List<String> images = new ArrayList<String>();
		List<String> categories = null;
		
		if(selectedCat!=null){
			categories = Arrays.asList(selectedCat);
		} 
		
		if(!validator.isProductNameOk(productName)){
			productName = null;
		}
		if(!validator.isPriceOk(price)){
			price = null;
		}
		if(!validator.isQuantityOk(quantity)){
			quantity = null;
		}
		if(!validator.isDescriptionOk(description)){
			description=null;
		}
		
		images.add(request.getParameter("image"));
		images.add(request.getParameter("image2"));
		images.add(request.getParameter("image3"));
		images.add(request.getParameter("image4"));
		images.add(request.getParameter("image5"));
		
		productController.updateProduct(Integer.valueOf(productId), productName, price, description, quantity);
		
		
		if(categories!=null){
			productController.deleteProductBelongsCategory(productId);
			for(int i=0;i<categories.size();++i){
				productController.createProductBelongsCategory(productId, Integer.valueOf(categories.get(i)));
			}
		}
		
		for(int i=0;i<images.size();++i){
			if(images.get(i)!=""){
				productController.addProductImage(images.get(i), productId);
			}
		}
		
		doGet(request,response);
		
	}

}

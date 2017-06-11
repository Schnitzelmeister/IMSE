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
		List<Product> products = productController.getAllProducts();
		
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
		String description = request.getParameter("description");		
		Integer productId = Integer.valueOf(request.getParameter("productId").replaceAll("\\D+", ""));
	
		List<String> images = new ArrayList<String>();
		
		images.add(request.getParameter("image"));
		images.add(request.getParameter("image2"));
		images.add(request.getParameter("image3"));
		images.add(request.getParameter("image4"));
		images.add(request.getParameter("image5"));
		
		if(validator.isProductNameOk(productName)){
			if(validator.isQuantityOk(quantity)){
				if(validator.isPriceOk(price)){
					if(validator.isDescriptionOk(description)){
						productController.updateProduct(productId, productName, Float.valueOf(price), description, Integer.valueOf(quantity), images);					
					} else {
						System.out.println("Fehler in der Beschreibung!");
					}
				} else {
					System.out.println("Fehler beim Preis!");
				}
			} else {
				System.out.println("Fehler bei Anzahl!");
			}
		} else {
			System.out.println("Bitte geben Sie einen aussagekräftigen Produktnamen ein!");
		}
		
		doGet(request,response);
		
	}

}

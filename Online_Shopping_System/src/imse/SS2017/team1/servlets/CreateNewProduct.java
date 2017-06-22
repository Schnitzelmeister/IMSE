package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.filter.Validator;
import imse.SS2017.team1.model.Category;

@WebServlet("/CreateNewProduct")
@MultipartConfig(maxFileSize = 16177215) 
public class CreateNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminTyp = null;
		Boolean isCategoryAvailable = false;
		
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		CategoryController categoryController = new CategoryController();
		List<Category> categories = categoryController.getAllCategories();
		Integer anzahl3 = categories.size();
		
		if(anzahl3>0){
			isCategoryAvailable=true;
		}
		anzahl3--;
		
		
		request.setAttribute("categories2", categories);
		request.setAttribute("anzahl3", anzahl3);
		request.setAttribute("isCategoryAvailable", isCategoryAvailable);
		request.getRequestDispatcher("/createProduct.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductController productController = new ProductController();
		Validator validator = new Validator();
		
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		String productName = request.getParameter("productName");
		String price = request.getParameter("productPrice");
		String description = request.getParameter("productDescription");
		String quantity = request.getParameter("productQuantity");
		String[] selectedCat = request.getParameterValues("selectedCat");
		List<String> images = new ArrayList<String>();
		
		try{
			if(selectedCat!=null){
				List<String> categories = Arrays.asList(selectedCat);
			
				images.add(request.getParameter("image"));
				images.add(request.getParameter("image2"));
				images.add(request.getParameter("image3"));
				images.add(request.getParameter("image4"));
				images.add(request.getParameter("image5"));
				
				if(validator.isProductNameOk(productName)){
					if(validator.isQuantityOk(quantity)){
						if(validator.isPriceOk(price)){
							if(validator.isDescriptionOk(description)){
									productController.createProduct(productName, Float.valueOf(price.replaceAll(",", ".")), description, Integer.valueOf(quantity), images, categories);	
							} else {
								throw new IllegalArgumentException("Fehler in der Beschreibung!");
							}
						} else {
							throw new IllegalArgumentException("Fehler beim Preis!");
						}
					} else {
						throw new IllegalArgumentException("Fehler bei der Anzahl!");
					}
				} else {
					throw new IllegalArgumentException("Bitte geben Sie einen aussagekraeftigen Produktnamen ein!");
				}
			} else {
				throw new IllegalArgumentException("Bitte waehlen Sie zumindest eine Produktkategorie aus!");
			}
		} catch(IllegalArgumentException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/createProduct.jsp").forward(request,response);
			return;
		}
		
		doGet(request,response);
		
	}

}

package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.model.Category;

@WebServlet("/CreateNewProduct")
public class CreateNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		CategoryController categoryController = new CategoryController();
		List<Category> categories = categoryController.getAllCategories();
		Integer anzahl3 = categories.size();
		anzahl3--;
		request.setAttribute("categories2", categories);
		request.setAttribute("anzahl3", anzahl3);
		request.getRequestDispatcher("/createProduct.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductController productController = new ProductController();
		
		String adminTyp = null;
		if(request.getSession().getAttribute("adminType")!=null){
			adminTyp = request.getSession().getAttribute("adminType").toString();
		}
		request.setAttribute("IsAdminTyp", adminTyp!=null);
		request.setAttribute("IsAdminChief", adminTyp.equals("chiefadmin"));
		
		String productName = request.getParameter("productName");
		Float price = Float.valueOf(request.getParameter("productPrice"));
		String description = request.getParameter("productDescription");
		Integer quantity = Integer.valueOf(request.getParameter("productQuantity"));
		
		String image1 = request.getParameter("image6");
		String image2 = request.getParameter("image7");
		String image3 = request.getParameter("image8");
		String image4 = request.getParameter("image9");
		String image5 = request.getParameter("image10");
		
		productController.createProduct(productName, price, description, quantity);
		
		Integer productId=0;
		if(productController.getProductByParams(productName, price, description, quantity)!=null){
			productId = productController.getProductByParams(productName, price, description, quantity).getProductId();
		}
		
		if(image1!=null && !image1.equals("") && productId!=0){
			productController.addProductImage(image1, productId);
		}
		if(image2!=null && !image2.equals("") && productId!=0){
			productController.addProductImage(image2, productId);
		}
		if(image3!=null && !image3.equals("") && productId!=0){
			productController.addProductImage(image3, productId);
		}
		if(image4!=null && !image4.equals("") && productId!=0){
			productController.addProductImage(image4, productId);
		}
		if(image5!=null && !image5.equals("") && productId!=0){
			productController.addProductImage(image5, productId);
		}	
		
		doGet(request,response);
		
	}

}

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
import imse.SS2017.team1.model.Product;

@WebServlet("/EditProductCategory")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryController categoryController = new CategoryController();
		ProductController productController = new ProductController();
		
		List<Category> categories = categoryController.getAllCategories();
		List<Product> products = productController.GetAllProducts();
		
		request.setAttribute("categories", categories);
		request.setAttribute("products", products);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductController productController = new ProductController();
		
		String productName = request.getParameter("productName");
		Float price = Float.valueOf(request.getParameter("productPrice"));
		String description = request.getParameter("description");
		Integer quantity = Integer.valueOf(request.getParameter("productQuantity"));
		Integer productId = Integer.valueOf(request.getParameter("productId"));
		
		productController.updateProduct(productId, productName, price, description, quantity);
		
	}

}

package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.model.Product;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductController productController = new ProductController();
		ArrayList<Product> products = (ArrayList<Product>) productController.GetAllProducts();
		request.setAttribute("products", products);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductController productController = new ProductController();
		
		String productId = request.getParameter("deletedProductId");
		productController.deleteProductById(Integer.valueOf(productId));
		
	}

}

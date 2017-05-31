package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.List;

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
		List<Product> products = productController.GetAllProducts();
		Integer anzahl = products.size();
		anzahl--;
		
		request.setAttribute("products", products);
		request.setAttribute("anzahl", anzahl);
		request.getRequestDispatcher("/deleteProduct.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductController productController = new ProductController();
		Integer productId = Integer.valueOf(request.getParameter("deletedProductId").replaceAll("\\D+", ""));
		productController.deleteProductById(productId);
		
		doGet(request,response);
		
	}

}

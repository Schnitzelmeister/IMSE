package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.ProductController;
import imse.SS2017.team1.model.Product;

/**
 * Servlet implementation class GetShoppingCart
 */
@WebServlet("/GetShoppingCart")
public class GetShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> allProducts = new ProductController().GetAllProducts();
		Enumeration<String> allSessionAttributes = request.getSession().getAttributeNames();
		List<String> ProductIdsInCart = new ArrayList<String>();
		List<Product> productsInCart = new ArrayList<Product>();
		String productnr = null;
		while (allSessionAttributes.hasMoreElements()) {
			productnr = allSessionAttributes.nextElement();
			if (productnr.startsWith("productId_")) {

				ProductIdsInCart.add(productnr.substring(10));
				System.out.println(productnr.substring(10));
			}
		}
		System.out.println("Anzahl Ids im Warenkorb:"+ProductIdsInCart.size());
	/*	for(int i=0;i<ProductIdsInCart.size();i++){
			System.out.println("Produkt Id in der Liste productsInCart: "+productsInCart.get(i));
		}*/
		
		for (int i = 0; i < ProductIdsInCart.size(); i++) {
			for (int j = 0; j < allProducts.size(); j++) {
				System.out.println("ProductId:"+allProducts.get(j).getProductId().toString());
				if ((allProducts.get(j).getProductId().toString()).equals((ProductIdsInCart.get(i)))) {
					//System.out.println("Ich bin in if Bedingung");
					productsInCart.add(allProducts.get(j));
				}
			}
		}
		System.out.println("Anzahl Produkte im Warenkorb: "+productsInCart.size());
		
		request.getSession().setAttribute("productsInCart", productsInCart);
		
		response.sendRedirect("getShoppingCart.jsp");
		
	}

}

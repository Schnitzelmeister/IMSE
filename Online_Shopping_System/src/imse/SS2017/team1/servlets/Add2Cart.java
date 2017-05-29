package imse.SS2017.team1.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.model.Cart;

public class Add2Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
		
		int productId;
		try {
			productId = Integer.parseInt(request.getParameter("prod"));
		}
		catch(NumberFormatException e) {
			productId = 0;
		}

		int quantity;
		try {
			quantity = Integer.parseInt(request.getParameter("qnty"));
		}
		catch(NumberFormatException e) {
			quantity = 0;
		}

		
		if (request.getSession().getAttribute("cart") == null)
			request.getSession().setAttribute("cart", new Cart());
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (productId != 0)
			cart.addToCart(productId, quantity);

		//System.out.println("Add2Cart return " + cart.items.size());

		response.setContentType("text/plain");
		response.getWriter().write(String.valueOf(cart.items.size()));
		response.getWriter().close();
	}
}

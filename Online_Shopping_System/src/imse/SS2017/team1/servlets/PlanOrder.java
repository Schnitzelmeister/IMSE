package imse.SS2017.team1.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.controller.OrderController;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.CustomerOrder;
import imse.SS2017.team1.model.Product;



/**
 * Servlet implementation class PlanOrder
 */
@WebServlet("/planOrder")
public class PlanOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=new Dao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//alle Session Attribute
		Enumeration<String> sessionAttributes=request.getSession().getAttributeNames();
		
		String attribute = null;
		//alle Sessionattribute mit productId (das ist die productid) und productsinCart löschen, 
		//da sie ja schon in einem anderen Sessionattribute(quantityBYProduct) gespeichert sind.
		for (Enumeration<String> sessionAttribute=sessionAttributes ; sessionAttribute.hasMoreElements();){
			attribute = sessionAttribute.nextElement();
			if (attribute.startsWith("productId_")||attribute.equals("productsInCart")) {
				request.getSession().removeAttribute(attribute);
			}
			
		 }
		
		OrderController ordercontroller=new OrderController();
		CustomerOrder customerOrder=ordercontroller.createCustomerOrder((String)request.getSession().getAttribute("email"));
		
		//List<OrderDetail> orderdetails=new ArrayList<OrderDetail>();
		
		@SuppressWarnings("unchecked")
		Map<Product,Integer> quantityByProduct=(HashMap<Product,Integer>)request.getSession().getAttribute("quantityByProduct");
		for (Entry<Product, Integer> entry : quantityByProduct.entrySet())
		{
			
			ordercontroller.saveOrderDetail((ordercontroller.createOrderDetail(entry.getKey(), entry.getValue())),customerOrder);
			
			//quantity bei Product aktualisieren
			entry.getKey().setQuantity(entry.getKey().getQuantity()-entry.getValue());
			dao.updateEntity(entry.getKey());
			
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		//quantityByProduct wird gelöscht
		request.getSession().removeAttribute("quantityByProduct");
		response.sendRedirect("congratulation.jsp");
		
	
	
	}
	
	

}


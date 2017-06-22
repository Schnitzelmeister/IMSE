package imse.SS2017.team1.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.sun.xml.internal.bind.v2.TODO;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.CustomerOrder;
import imse.SS2017.team1.model.OrderDetail;
import imse.SS2017.team1.model.Product;

public class OrderController {
	
	Dao dao = new Dao();

	public void placeOrder(Integer productId, Integer quantity){

	}
	
	public void deleteOrder(Integer orderId){
		dao.delete(orderId);
	}
	
	public Integer getOrderPrice(Integer orderId){
		return orderId;

	}
	
	public CustomerOrder getOrder(Integer orderId){
		dao.getobjects(CustomerOrder.class);
		return null;
	}
	
	public List<CustomerOrder> getAllOrder(){
		return dao.getobjects(CustomerOrder.class);
	}
	
	private Integer newOrderId=0;
	public Integer getNewOrderId(){
		List<CustomerOrder> allOrders=getAllOrder();
		for (CustomerOrder customerOrder : allOrders) {
			if(customerOrder.getOrderId()>newOrderId)
				newOrderId=customerOrder.getOrderId();
		}
		return newOrderId+1;
	}
	
	public CustomerOrder createCustomerOrder(String customerEmail){
		
		
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setCustomerEmail(customerEmail);
		customerOrder.setOrderId(this.getNewOrderId());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println("Auftragserstellungsdatum: "+dtf.format(localDate));
		customerOrder.setDateCreated(dtf.format(localDate));
		customerOrder.setOrdered(true);
		dao.save(customerOrder);
	
		return customerOrder;
		
		
	}
	private static Integer orderDetailId=0;
	public void createOrderDetail(CustomerOrder customerOrder, Product product, Integer quantity){
		OrderDetail orderDetail=new OrderDetail();
		if(customerOrder.getOrderId()!=null)
		orderDetail.setOrderId(customerOrder.getOrderId());
		else {System.out.println("CustomerOrder hat keine OrderID");return;}
		
		List<OrderDetail> listOrderDetail=dao.getobjects(OrderDetail.class);
		for (OrderDetail orderDetail2 : listOrderDetail) {
			if(orderDetail2.getProductId().equals(product.getProductId())){
				if(orderDetail2.getOrderDetailId()>orderDetailId)orderDetailId=orderDetail2.getOrderDetailId();
			}
		}
		orderDetail.setOrderDetailId(++orderDetailId);
		orderDetail.setQuantity(quantity);
		orderDetail.setSubTotal(quantity*product.getPrice());
		orderDetail.setProductId(product.getProductId());
		dao.save(orderDetail);
	}
	
	

	
}

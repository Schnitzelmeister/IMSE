package imse.SS2017.team1.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



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
	
	public OrderDetail createOrderDetail(Product product, Integer quantity){
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setQuantity(quantity);
		orderDetail.setSubTotal(quantity*product.getPrice());
		orderDetail.setProductId(product.getProductId());
		return orderDetail;
	}
	
	public void saveOrderDetail(OrderDetail orderDetail, CustomerOrder customerOrder){
		orderDetail.setOrderId(customerOrder.getOrderId());
		CustomerOrder customerOrderAktuell=dao.getobject(CustomerOrder.class,customerOrder.getOrderId());
		Integer anzahlOrderDetails=(customerOrderAktuell.getOrderDetails()).size();
		orderDetail.setOrderId(anzahlOrderDetails+1);
		customerOrder.setOrderDetail(orderDetail);
		dao.updateEntity(customerOrder);
	}

	
	public void close() {
		dao.close();
	}
}

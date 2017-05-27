package imse.SS2017.team1.controller;

import java.util.List;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.CustomerOrder;

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
	
}

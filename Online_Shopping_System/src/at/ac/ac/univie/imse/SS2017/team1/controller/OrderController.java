package at.ac.ac.univie.imse.SS2017.team1.controller;

import at.ac.ac.univie.imse.SS2017.team1.dao.Dao;

public class OrderController {
	
	Dao dao = new Dao();

	public void placeOrder(Integer productId, Integer quantity){

	}
	
	public void deleteOrder(Integer orderId){
		dao.delete(orderId);
	}
	
	public Integer getOrderPrice(Integer orderId){

	}
	
	public Order getOrder(Integer orderId){
		dao.getobjects(Order.class);
	}
	
	public List<Order> getAllOrder(){
		return dao.getobjects(Order.class);
	}
	
}

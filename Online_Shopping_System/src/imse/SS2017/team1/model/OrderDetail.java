package imse.SS2017.team1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "orderdetail")
public class OrderDetail {
	
	@Id
	private CustomerOrder orderId;
	private Integer quantity;
	private Float unitCost;
	private Float subTotal;
	private static Integer orderCounter=0;
	/**
	 * @return the orderId
	 */
	public CustomerOrder getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(CustomerOrder orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the unitCost
	 */
	public Float getUnitCost() {
		return unitCost;
	}
	/**
	 * @param unitCost the unitCost to set
	 */
	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}
	/**
	 * @return the subTotal
	 */
	public Float getSubTotal() {
		return subTotal;
	}
	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}
	/**
	 * @return the orderCounter
	 */
	public static Integer getOrderCounter() {
		return orderCounter;
	}
	/**
	 * @param orderCounter the orderCounter to set
	 */
	public static void setOrderCounter(Integer orderCounter) {
		OrderDetail.orderCounter = orderCounter;
	}
	
	public Float calculatePrice(Integer quantity, Float unitCost ){
		return unitCost*quantity;
		
	}
}

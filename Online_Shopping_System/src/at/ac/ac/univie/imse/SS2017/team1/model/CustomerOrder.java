package at.ac.ac.univie.imse.SS2017.team1.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;


public class CustomerOrder {
	
	
	
	
	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the dateShipped
	 */
	public String getDateShipped() {
		return dateShipped;
	}
	/**
	 * @param dateShipped the dateShipped to set
	 */
	public void setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
	}

	/**
	 * @return the ordered
	 */
	public Boolean getOrdered() {
		return ordered;
	}
	/**
	 * @param ordered the ordered to set
	 */
	public void setOrdered(Boolean ordered) {
		this.ordered = ordered;
	}
	ArrayList<OrderDetail> orderdetails=new ArrayList<OrderDetail>();

	private Integer orderId;
	private String customerEmail;
	private String dateCreated;
	private String dateShipped;
	private Boolean ordered;
	
}

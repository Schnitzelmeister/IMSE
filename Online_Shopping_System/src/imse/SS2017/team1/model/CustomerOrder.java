package imse.SS2017.team1.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Table(name = "CustomerOrder")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class CustomerOrder implements Serializable{
	
	@Id
	@GeneratedValue
	@Field(name="_id")
	private Integer orderId;
	private String customerEmail;
	private String dateCreated;
	private String dateShipped;
	private Boolean ordered;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	@ElementCollection
	private List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
	
	public OrderDetail getOrderDetails() {
		return null;
	}
	
}

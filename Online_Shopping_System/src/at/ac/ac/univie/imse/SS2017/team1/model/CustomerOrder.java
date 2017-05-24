package at.ac.ac.univie.imse.SS2017.team1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerOrder {
	
	@Id
	private Integer orderId;
	private String customerEmail;
	private String customerFirstName;
	private String customerLastName;
	private String dateCreated;
	private String dateShipped;
	

}

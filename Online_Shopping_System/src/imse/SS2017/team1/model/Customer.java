package imse.SS2017.team1.model;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer extends User{
	
	private Integer shippingAddressId;
	private Integer billingAddressId;
	private String phoneNumber;
	private String creditCardNumber;

	public Customer(){
		
	}
	
	public Customer(String emailAddress, String password, String firstName, String lastName, boolean loginStatus,
			String phoneNumber ) {		
		super(emailAddress, password, firstName, lastName, loginStatus);
		this.phoneNumber = phoneNumber;
	
	}

	
	public Integer getShippingAddress() {
		return shippingAddressId;
	}

	public void setShippingAddress(Integer shippingAddress) {
		this.shippingAddressId = shippingAddress;
	}

	public Integer getBillingAddress() {
		return billingAddressId;
	}

	public void setBillingAddress(Integer billingAddress) {
		this.billingAddressId = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardInfo() {
		return creditCardNumber;
	}

	public void setCreditCardInfo(String creditCard) {
		this.creditCardNumber = creditCard;
	}
}

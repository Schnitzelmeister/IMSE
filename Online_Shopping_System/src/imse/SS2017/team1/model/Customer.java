package imse.SS2017.team1.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends User{
	
	private String firstName;
	private String lastName;
	@Transient private String shippingAdress;
	@Transient private String billingAdress;
	private String phoneNumber;
	private String creditCardInfo;

	public Customer(){
		
	}
	
	public Customer(String emailAddress, String password, boolean loginStatus, String firstName, String lastName,
			String shippingAddress, String billingAddress, String phoneNumber, String creditCardInfo) {
		
		super(emailAddress, password, loginStatus);
		this.firstName=firstName;
		this.lastName=lastName;
		this.shippingAdress = shippingAddress;
		this.billingAdress = billingAddress;
		this.phoneNumber = phoneNumber;
		this.creditCardInfo = creditCardInfo;
	}

	public String getFirstName() {
		return firstName;
	}
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}
	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getShippingAddress() {
		return shippingAdress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAdress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAdress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAdress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
}

package at.ac.ac.univie.imse.SS2017.team1.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends User{
	
	private String firstName;
	private String lastName;
	private Adress shippingAddress;
	private Adress billingAddress;
	private String phoneNumber;
	private CreditCard creditCard;

	public Customer(){
		
	}
	
	public Customer(String emailAddress, String password, boolean loginStatus, String firstName, String lastName,
			String phoneNumber) {
		
		super(emailAddress, password, loginStatus);
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber = phoneNumber;
	
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
	
	public Adress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Adress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Adress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Adress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CreditCard getCreditCardInfo() {
		return creditCard;
	}

	public void setCreditCardInfo(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
}

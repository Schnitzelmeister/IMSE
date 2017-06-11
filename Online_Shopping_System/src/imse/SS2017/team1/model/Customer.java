package imse.SS2017.team1.model;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Table(name = "Customer")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Customer extends User {
	
	// @Embedded 
	private Address shippingAddress;
	// @Embedded
	private Address billingAddress;
	@Embedded private CreditCard creditCard;
			  private String phoneNumber;

	public Customer() {

	}

	public Customer(String emailAddress, String password, String firstName, String lastName,
			Address shippingAddress, Address billingAddress, String phoneNumber) {
		super(emailAddress, password, firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.creditCard = null;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
}

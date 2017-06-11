package imse.SS2017.team1.model;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Table(name = "Customer")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Customer extends User {
	
	private static final long serialVersionUID = 1L;
	@Embedded 
	private Address shippingAddress;
	@Embedded 
	private Address billingAddress;
	@Embedded 
	private CreditCard creditCard;
	private String phoneNumber;
	
	@Transient
	private String creditCardNumber;
	@Transient
	private Integer billingAddressId;
	@Transient
	private Integer shippingAddressId;

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

	public Address getShippingAdr() {
		return shippingAddress;
	}

	public void setShippingAdr(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAdr() {
		return billingAddress;
	}

	public void setBillingAdr(Address billingAddress) {
		this.billingAddress = billingAddress;
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

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard card) {
		this.creditCard = card;
	}
}

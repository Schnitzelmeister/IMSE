package imse.SS2017.team1.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Table(name = "Customer")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Customer extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer shippingAddressId;
	private Integer billingAddressId;
	private String phoneNumber;
	@Transient
	private String creditCardNumber;

	public Customer() {

	}

	public Customer(String emailAddress, String password, String firstName, String lastName, boolean loginStatus,
			Integer shippingAddressId, Integer billingAddressId, String phoneNumber) {
		super(emailAddress, password, firstName, lastName, loginStatus);
		this.phoneNumber = phoneNumber;
		this.shippingAddressId = shippingAddressId;
		this.billingAddressId = billingAddressId;
		this.creditCardNumber = null;
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
	
	@Embedded
	private CreditCard creditcard;
	
	public CreditCard getCreditCard() {
		return creditcard;
	}
	
	public void setCreditCard(CreditCard card){
		creditcard = card;
	}
}

package at.ac.ac.univie.imse.SS2017.team1.model;

public class Customer extends User{
	private String customerName;
	private String shippingAddress;
	private String billingAddress;
	private String phoneNumber;
	private String creditCardInfo;

	public Customer(String emailAddress, String password, boolean loginStatus, String customerName,
			String shippingAddress, String billingAddress, String phoneNumber, String creditCardInfo) {
		
		super(emailAddress, password, loginStatus);
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.phoneNumber = phoneNumber;
		this.creditCardInfo = creditCardInfo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
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
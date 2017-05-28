package at.ac.ac.univie.imse.SS2017.team1.model;

import javax.persistence.Entity;

@Entity
public class CreditCard {
	private Integer cardNumber;
	private String firstName;
	private String lastName;
	private String type; //MasterCard, Visa 
	private String cvv;
	private Integer expiryMonth;
	private Integer expiryYear;
	/**
	 * @return the cardNumber
	 */
	public Integer getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the cvv
	 */
	public String getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	/**
	 * @return the expiryMonth
	 */
	public Integer getExpiryMonth() {
		return expiryMonth;
	}
	/**
	 * @param expiryMonth the expiryMonth to set
	 */
	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	/**
	 * @return the expiryYear
	 */
	public Integer getExpiryYear() {
		return expiryYear;
	}
	/**
	 * @param expiryYear the expiryYear to set
	 */
	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}
	
	
	

}

package imse.SS2017.team1.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class CreditCard implements Serializable {

	private static final long serialVersionUID = -5145899657319507604L;
	private String cardNumber;
	private String firstName;
	private String lastName;
	private String type; // MasterCard, Visa
	private String cvv;
	private Integer expiryMonth;
	private Integer expiryYear;

	public CreditCard() {

	}

	public CreditCard(String id, String cardNumber, String firstName, String lastName, String type, String cvv,
			Integer expiryMonth, Integer expiryYear) {
		//this.id = id;
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
	}

	
	public CreditCard(String cardNumber, String firstName, String lastName, String type, String cvv,
			Integer expiryMonth, Integer expiryYear) {
		//this.id = id;
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
	}
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
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
	 * @param type
	 *            the type to set
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
	 * @param cvv
	 *            the cvv to set
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
	 * @param expiryMonth
	 *            the expiryMonth to set
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
	 * @param expiryYear
	 *            the expiryYear to set
	 */
	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

}

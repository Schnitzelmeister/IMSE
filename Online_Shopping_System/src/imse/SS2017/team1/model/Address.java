package imse.SS2017.team1.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;


@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class Address implements Serializable {

/*
	@EmbeddedId
	@GeneratedValue
	@Field(name = "_id")
	private String addressId;
	*/
	
	private String streetName;
	private String streetNumber;
	private String additionalInfo;
	private String city;
	private String postCode;
	private String country;
	private static int idcounter = 0;

	public Address() {

	}

	public Address(String addressId, String streetName, String streetNumber, String additionalInfo, String city,
			String postCode, String country) {
		//this.addressId = addressId;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.additionalInfo = additionalInfo;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
		idcounter++;
	}
/*
	public Address(String streetName, String streetNumber, String additionalInfo, String city, String postCode,
			String country) {
		this.addressId = idcounter++;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.additionalInfo = additionalInfo;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}
*/
	/*
	public String getAdressId() {
		return addressId;
	}

	public void setAdressId(String adressId) {
		this.addressId = adressId;
	}
*/
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionaolInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

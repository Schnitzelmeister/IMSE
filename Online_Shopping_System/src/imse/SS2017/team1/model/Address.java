package imse.SS2017.team1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	private String streetName;
	private String streetNumber;
	private String additionalInfo;
	private String city;
	private String postCode;
	private String country;
	
	public Address(){
		
	}
	
	public Address(Integer addressId, String streetName, String streetNumber, String additionalInfo, String city,
			String postCode, String country) {
		this.addressId = addressId;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.additionalInfo = additionalInfo;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}

	public Integer getAdressId() {
		return addressId;
	}
	
	public void setAdressId(Integer adressId) {
		this.addressId = adressId;
	}
	
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

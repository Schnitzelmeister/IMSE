package at.ac.ac.univie.imse.SS2017.team1.model;

import javax.persistence.Entity;

@Entity
public class Adress {

	private Integer adressId;
	private String streetName;
	private String streetNumber;
	private String additionaolInfo;
	private String city;
	private Integer postCode;
	private String country;
	
	public Integer getAdressId() {
		return adressId;
	}
	
	public void setAdressId(Integer adressId) {
		this.adressId = adressId;
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
	
	public String getAdditionaolInfo() {
		return additionaolInfo;
	}
	
	public void setAdditionaolInfo(String additionaolInfo) {
		this.additionaolInfo = additionaolInfo;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getPostCode() {
		return postCode;
	}
	
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
}

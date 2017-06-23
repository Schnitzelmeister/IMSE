package imse.SS2017.team1.filter;

import java.util.regex.Pattern;

public class AddressValidator {
	
	public boolean isStreetName(String streetName){
		return Pattern.matches("[a-zA-Z]{3,45}", streetName);
	}
	
	public boolean isStreetNumber(String streetNumber){
		return Pattern.matches("[0-9]{1,45}", streetNumber);
	}
	
	public boolean isAdditionalInfo(String additionalInfo){
		return Pattern.matches("[a-zA-Z0-9 ]{1,45}", additionalInfo);
	}
	
	public boolean isCity(String city){
		return Pattern.matches("[a-zA-Z]{2,45}", city);
	}
	
	public boolean isPostCode(String postCode){
		return Pattern.matches("[1-9][0-9]{3}", postCode);
	}
	
	public boolean isCountry(String country){
		return Pattern.matches("[a-zA-Z]{2,45}", country);
	}

}

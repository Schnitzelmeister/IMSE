package imse.SS2017.team1.model;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Table(name = "Admin")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Admin extends User {
	
	//muss noch im Create Table auf Boolean geändert werden
	private Boolean verified;
	private String managerEmailAddress;

	public Admin(){
		
	}
	
	public Admin(String emailAddress, String password, String firstName, String lastName, String adminName, Boolean isVerified) {
		super(emailAddress, password, firstName, lastName);
		this.verified = isVerified;
	}

	public Boolean isVerified() {
		return verified;
	}

	public void setVerified(Boolean isVerified) {
		this.verified = isVerified;
	}

	public String getManagerEmailAddress() {
		return managerEmailAddress;
	}

	public void setManagerEmailAddress(String managerEmailAddress) {
		this.managerEmailAddress = managerEmailAddress;
	}


}

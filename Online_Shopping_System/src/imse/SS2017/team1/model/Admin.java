package imse.SS2017.team1.model;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin extends User {
	
	//muss noch im Create Table auf Boolean geändert werden
	private String verified;
	private String managerEmailAddress;

	public Admin(){
		
	}
	
	public Admin(String emailAddress, String password, String firstName, String lastName, boolean loginStatus, String adminName, String isVerified) {
		super(emailAddress, password, firstName, lastName, loginStatus);
		this.verified = isVerified;
	}

	public String isVerified() {
		return verified;
	}

	public void setVerified(String isVerified) {
		this.verified = isVerified;
	}

	public String getManagerEmailAddress() {
		return managerEmailAddress;
	}

	public void setManagerEmailAddress(String managerEmailAddress) {
		this.managerEmailAddress = managerEmailAddress;
	}

	public String getVerified() {
		return verified;
	}

}

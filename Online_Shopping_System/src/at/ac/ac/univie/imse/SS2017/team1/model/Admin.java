package at.ac.ac.univie.imse.SS2017.team1.model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User {
	
	private String adminName;
	private boolean isVerified;

	
	public Admin(){
		
	}
	
	public Admin(String emailAddress, String password, boolean loginStatus, String adminName, boolean isVerified) {
		super(emailAddress, password, loginStatus);
		this.adminName = adminName;
		this.isVerified = isVerified;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

}

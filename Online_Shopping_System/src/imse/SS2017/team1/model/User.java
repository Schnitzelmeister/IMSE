package imse.SS2017.team1.model;

import javax.persistence.*;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
	
	@Id
	private String emailAdress;
	
	private String password;
	//private boolean loginStatus;

	public User(){
		
	}
	
	public User(String emailAddress, String password, boolean loginStatus) {
		this.emailAdress = emailAddress;
		this.password = password;
		//this.loginStatus = loginStatus;
	}

	
	public String getEmailAddress() {
		return emailAdress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAdress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/*
	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
*/
}

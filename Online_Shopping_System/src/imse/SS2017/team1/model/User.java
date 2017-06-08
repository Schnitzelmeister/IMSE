package imse.SS2017.team1.model;

import javax.persistence.*;

import org.eclipse.persistence.nosql.annotations.Field;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
	
	@Id
	@GeneratedValue
	@Field(name="_id")
	private String emailAddress;
	
	private String password;
	//private boolean loginStatus;
	
	private String firstName;
	private String lastName;

	public User(){
		
	}
	
	public User(String emailAddress, String password, String firstName, String lastName, boolean loginStatus) {
		this.emailAddress = emailAddress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.loginStatus = loginStatus;
	}

	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

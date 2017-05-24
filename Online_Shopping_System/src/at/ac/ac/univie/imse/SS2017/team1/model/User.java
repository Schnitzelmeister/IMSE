package at.ac.ac.univie.imse.SS2017.team1.model;

public abstract class User {
	private String emailAddress;
	private String password;
	private boolean loginStatus;

	public User(String emailAddress, String password, boolean loginStatus) {
		this.emailAddress = emailAddress;
		this.password = password;
		this.loginStatus = loginStatus;
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

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

}

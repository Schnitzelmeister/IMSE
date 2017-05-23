package at.ac.ac.univie.imse.SS2017.team1.controller;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import at.ac.ac.univie.imse.SS2017.team1.dao.DatabaseAccess;

public class UserController {
	DatabaseAccess dao;

	public UserController() {
		dao = new DatabaseAccess();
	}

	public void verifyLogin(String emailAdress, String password) {

	}

	public void registerCustomer(String customerFirstName, String customerLastName, String customerEmail,
			String password, String phoneNumber) {

	}

	public void verifyUserInput(String firstname, String surname, String email, String password, String telephonenr) {
		boolean emailTaken;
		
		try {
			emailTaken = dao.isEmailInUse(email);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Ein Datenbankfehler ist aufgetreten");
		}

		if (emailTaken) {
			throw new IllegalArgumentException("Der Benutzername ist schon vergeben");
		}

		if (!validEmail(email)) {
			throw new IllegalArgumentException("Die angegebene Email Adresse ist keine gltige Email");
		}

		if (firstname.equals("") || surname.equals("") || telephonenr.equals(""))
			throw new IllegalArgumentException("Kein Feld darf leer bleiben");

		if (password.length() < 8) {
			throw new IllegalArgumentException("Das Passwort muss mindestens 8 Stellen haben");
		}
	}

	/*
	 * Checks whether the string is a valid email
	 */
	private boolean validEmail(String email) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(email);

		return mat.matches();
	}
}

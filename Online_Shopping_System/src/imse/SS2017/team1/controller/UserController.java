package imse.SS2017.team1.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.dao.DaoInterface;
import imse.SS2017.team1.model.Admin;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.User;

public class UserController {
	DaoInterface dao;

	public UserController() {
		System.out.println("UserController constructor wurde aufgerufen");
		dao = new Dao();
		
	}

	public void verifyLogin(String emailAdress, String password) {

	}

	public void registerCustomer(Customer customer) {
		try {
			dao.save(customer);
			System.out.println("Benutzer wurde mit save gespeichert");
		} catch (Exception e) {
			throw new IllegalArgumentException("Die Datenspeicherung war nicht erfolgreich");
		}
	}

	public void verifyUserInput(String firstname, String surname, String email, String password, String telephonenr) {
		
		if (firstname.equals("") || surname.equals("") || telephonenr.equals(""))
			throw new IllegalArgumentException("Kein Feld darf leer bleiben");
		
		if (!validEmail(email)) 
			throw new IllegalArgumentException("Die angegebene Email Adresse ist keine g�ltige Email");
		
		if (password.length() < 8) 
			throw new IllegalArgumentException("Das Passwort muss mindestens 8 Stellen haben");
		
		boolean emailTaken = isCustomerEmailTaken(email);

		if(emailTaken)
			throw new IllegalArgumentException("Die Email Adresse ist schon in Benutzung");
	}

	/*
	 * Checks whether the string is a valid email
	 */
	private boolean validEmail(String email) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(email);

		return mat.matches();
	}
	
	private boolean isCustomerEmailTaken(String email){
		User user=dao.getobject(Customer.class, email);
		
		if(user == null)
			return false;
		else
			return true;
	}
	
	public List<Customer> searchAllCustomer() {
		return dao.getobjects(Customer.class);
	}
	
	public Customer searchCustomer(String email){
		return dao.getobject(Customer.class, email);
	}
	
	public void deleteAccount(String email){
		dao.delete(dao.getobject(Customer.class, email));
	}
	
	public List<Admin> searchAllAdmins(){
		return dao.getobjects(Admin.class);
	}
	
	public void deleteAdminAccount(String email){
		dao.delete(dao.getobject(Admin.class, email));
	}
	
	public void verifyAdmin(String email){
		Admin admin = dao.getobject(Admin.class, email);
		admin.setVerified("true");
	}
	
	public void saveCreditCard(CreditCard creditcard,Customer customer){
		dao.save(creditcard);
		customer.setCreditCardInfo(creditcard.getCardNumber());
		dao.updateEntity(customer);
	}
	
}

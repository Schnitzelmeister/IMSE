package imse.SS2017.team1.database;

import java.util.ArrayList;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.database.DataGenerator.entityTyp;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Admin;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.Product;

public class MySQLDataFilling {
	
	public static void main(String args[]){ 
           start();                
    }
	
	private static void start() {
		Dao dao = new Dao();
		
		System.out.println("Chef-Admin wird generiert!");
		Admin admin = new Admin();
		admin.setEmailAddress("admin@hotmail.com");
		admin.setFirstName("main");
		admin.setLastName("admin");
		admin.setManagerEmailAddress("admin@hotmail.com");
		admin.setPassword("admin");
		admin.setVerified("true");
		dao.save(admin);
		
		Category category = new Category();
		
		System.out.println("Produktkategorien werden generiert!");
		ArrayList<String> categoryNames = DataGenerator.generateRandomData(entityTyp.productCategories, 20);
		for(int i=0;i<20;++i){
			try {
				category.setCategoryName(categoryNames.get(i));
			} catch (Exception e){
				System.out.println("Fehler bei Variablensetzung!");
			}
			try {
				dao.save(category);
			} catch(Exception e) {
				System.out.println("Ein Duplikat wurde gefunden!");
			}
		}
		
		System.out.println("Produkte werden gerneriert!");

		System.out.println("Addressen werden generiert!");
		Address customerAddress = new Address();
		ArrayList<String> streetName = DataGenerator.generateRandomStreetNames(2000);
		ArrayList<Integer> streetNumber = DataGenerator.generateRandomInteger(2000, 1, 200);
		ArrayList<String> cities = DataGenerator.generateRandomData(entityTyp.cities, 2000);
		ArrayList<Integer> postCode = DataGenerator.generateRandomInteger(2000, 1010, 9993);
		for(int i=0;i<2000;++i){
			try{
				customerAddress.setCity(cities.get(i));
				customerAddress.setCountry("Austria");
				customerAddress.setPostCode(String.valueOf(postCode.get(i)));
				customerAddress.setStreetName(streetName.get(i));
				customerAddress.setStreetNumber(String.valueOf(streetNumber.get(i)));
			} catch (Exception e){
				System.out.println("Fehler bei Variablensetzung!");
			}
			try {
				dao.save(customerAddress);				
			} catch(Exception e) {
				System.out.println("Ein Duplikat wurde gefunden!");
			}
		}
		
		System.out.println("Kreditkartendaten werden generiert!");
		CreditCard creditcard = new CreditCard();
		ArrayList<String> cardNumber = DataGenerator.generateRandomCreditCards(2000);
		ArrayList<String> surnames = DataGenerator.generateRandomData(entityTyp.surNames, 2000);
		ArrayList<String> lastNames = DataGenerator.generateRandomData(entityTyp.Names, 2000);
		ArrayList<String> cvvs = DataGenerator.generateRandomStrings(2000, 32);
		ArrayList<Integer> expiryMonths = DataGenerator.generateRandomInteger(2000, 1, 12);
		ArrayList<Integer> expiryYears = DataGenerator.generateRandomInteger(2000, 2017, 2025);
		for(int i=0;i<2000;++i){
			try {
				creditcard.setCardNumber(cardNumber.get(i));
				creditcard.setCvv(cvvs.get(i));
				creditcard.setExpiryMonth(expiryMonths.get(i));
				creditcard.setExpiryYear(expiryYears.get(i));
				creditcard.setFirstName(surnames.get(i));
				creditcard.setLastName(lastNames.get(i));
				creditcard.setType("MasterCard");				
			} catch (Exception e){
				System.out.println("Fehler bei Variablensetzung!");
			}
			try {
				dao.save(creditcard);				
			} catch(Exception e) {
				System.out.println("Ein Duplikat wurde gefunden!");
			}
		}
		
		System.out.println("Admindaten werden generiert!");
		admin = new Admin();
		ArrayList<String> adminSurNames = DataGenerator.generateRandomData(entityTyp.surNames, 2000);
		ArrayList<String> adminLastNames = DataGenerator.generateRandomData(entityTyp.Names, 2000);
		ArrayList<String> emailAddresses = DataGenerator.generateRandomEmailAccounts(DataGenerator.
				getFullNames(adminSurNames, adminLastNames));
		ArrayList<String> passwords = DataGenerator.generateRandomStrings(2000, 64);
		for(int i=0;i<2000;++i){
			try {
				admin.setEmailAddress(emailAddresses.get(i));
				admin.setFirstName(adminSurNames.get(i));
				admin.setLastName(adminLastNames.get(i));
				admin.setPassword(passwords.get(i));
				admin.setVerified("false");
				admin.setManagerEmailAddress("admin@hotmail.com");
			} catch (Exception e){
				System.out.println("Fehler bei Variablensetzung!");
			}
			try{
				dao.save(admin);
			} catch(Exception e){
				System.out.println("Ein Duplikat wurde gefunden!");
			}
		}
		
		
		System.out.println("Kundendaten werden gerneriert!");
		Customer customer = new Customer();
		emailAddresses = DataGenerator.generateRandomEmailAccounts(DataGenerator.getFullNames(surnames, lastNames));
		ArrayList<String> phoneNumbers = DataGenerator.generateRandomMobileNumbers(2000);
		passwords = DataGenerator.generateRandomStrings(2000, 64);
		ArrayList<Integer> addressIds = DataGenerator.generateRandomInteger(2000, 1, 2000);
		for(int i=0;i<2000;++i){
			try {
				customer.setBillingAddress(addressIds.get(i));
				customer.setCreditCardInfo(cardNumber.get(i));
				customer.setEmailAddress(emailAddresses.get(i));
				customer.setFirstName(surnames.get(i));
				customer.setLastName(lastNames.get(i));
				customer.setPassword(passwords.get(i));
				customer.setPhoneNumber(phoneNumbers.get(i));
				customer.setShippingAddress(addressIds.get(i));
			} catch (Exception e){
				System.out.println("Fehler bei Variablensetzung!");
			}
			try{
				dao.save(customer);
			} catch(Exception e){
				System.out.println("Ein Duplikat wurde gefunden!");
			}
		}
		
		
		
		
	}

}
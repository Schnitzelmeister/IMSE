package imse.SS2017.team1.junits;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Admin;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.CustomerOrder;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;

import org.junit.Test;

public class DatabaseJunit{
	
	Address address;
	CreditCard creditcard;
	
	@Test
	public void testProduct() {
		Dao dao = new Dao();
		Product product = new Product();
		product.setDescription("Alles klar");
		product.setProductName("Rechner");
		product.setPrice(23.45F);
		dao.save(product);
		
	}
	
	@Test
	public void testAddress() {
		Dao dao = new Dao();
		address = new Address();
		address.setCity("Salzburg");
		address.setCountry("Austria");
		address.setPostCode("5020");
		address.setStreetNumber("14");
		address.setStreetName("Hansigasse");
		address.setAdditionaolInfo("ok");
		dao.save(address);
	}
	
	@Test
	public void testCategory(){
		Dao dao = new Dao();
		Category category = new Category();
		category.setCategoryName("Computer");
		dao.save(category);
	}
	
	@Test
	public void testImage() {
		Dao dao = new Dao();
		Image image = new Image();
		image.setImageString("asdfgasdgasgas");
		image.setProductId(1);
		dao.save(image);
	}
	
	
	@Test
	public void testCustomer() {
		Dao dao = new Dao();
		Customer customer = new Customer();
		customer.setFirstName("Fritz");
		customer.setLastName("Heinzl");
		customer.setPassword("sowieso");
		customer.setPhoneNumber("0676234234");
		customer.setShippingAddress(1);
		customer.setBillingAddress(1);
		// E-Mail-Adresse muss bei mehrmaligem Testen geändert werden
		customer.setEmailAddress("Hansi@hotmail.com");
		customer.setCreditCardInfo(null);
		dao.save(customer);
		
	}
	
	@Test
	public void testAdmin(){
		Dao dao = new Dao();
		Admin admin = new Admin();
		admin.setFirstName("Georg");
		admin.setLastName("Jandel");
		// E-Mail-Adresse muss bei mehrmaligem Testen geändert werden
		admin.setEmailAddress("Hansi@hotmail.com");
		admin.setPassword("super");
		admin.setVerified("true");
		admin.setManagerEmailAddress("Hansi@hotmail.com");
		dao.save(admin);
	}
	
	
	
	@Test
	public void testCustomerOrder(){
		Dao dao = new Dao();
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerEmail("Hansi@hotmail.com");
		customerOrder.setDateCreated("223452345");
		customerOrder.setDateShipped("2342342342");
		customerOrder.setOrdered(true);
		dao.save(customerOrder);
	}
	
	@Test
	public void testCustomerCreditCard(){
		Dao dao = new Dao();
		CreditCard creditcard = new CreditCard();
		creditcard.setCardNumber("1241-1234-1234-1234");
		creditcard.setCvv("123");
		creditcard.setExpiryMonth(2);
		creditcard.setExpiryYear(2019);
		creditcard.setFirstName("Gerhard");
		creditcard.setLastName("Oberdorfler");
		creditcard.setType("MasterCard");
		dao.save(creditcard);
	}


}

package imse.SS2017.team1.junits;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.database.DataGenerator;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Admin;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.CustomerOrder;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.OrderDetail;
import imse.SS2017.team1.model.Product;

import java.util.Random;

import org.junit.Test;

public class DatabaseJunit{
	
	String emailAddress;
	
	@Test
	public void testProduct() {
		Dao dao = new Dao();
		Product product = new Product();
		product.setDescription("Alles klar");
		product.setProductName("Rechner");
		product.setPrice(23.45F);
		product.setQuantity(2);
		product.setProductId(1);
		dao.save(product);
		
	}
	
	@Test
	public void testAddress() {
		Dao dao = new Dao();
		Address address = new Address();
		address = new Address();
		address.setCity("Salzburg");
		address.setCountry("Austria");
		address.setPostCode("5020");
		address.setStreetNumber("14");
		address.setStreetName("Hansigasse");
		address.setAdditionaolInfo("ok");
		address.setAdressId(1);
		dao.save(address);
	}
	
	@Test
	public void testCategory(){
		Dao dao = new Dao();
		Category category = new Category();
		category.setCategoryName("Computer");
		category.setCategoryId(1);
		dao.save(category);
	}
	
	@Test
	public void testImage() {
		Dao dao = new Dao();
		
		Product product = new Product();
		product.setDescription("Alles klar");
		product.setProductName("Rechner");
		product.setPrice(23.45F);
		product.setQuantity(2);
		product.setProductId(1);
		dao.save(product);
		
		Image image = new Image();
		image.setImageString("asdfgasdgasgas");
		image.setProductId(1);
		image.setImageId(1);
		dao.save(image);
	}
	
	
	@Test
	public void testCustomer() {
		Dao dao = new Dao();
		Random random = new Random();
		Customer customer = new Customer();
		customer.setFirstName("Fritz");
		customer.setLastName("Heinzl");
		customer.setPassword("sowieso");
		customer.setPhoneNumber("0676234234");
		customer.setShippingAddress(1);
		customer.setBillingAddress(1);
		customer.setEmailAddress(DataGenerator.generateRandomEmailAccounts(DataGenerator.generateRandomData(DataGenerator.entityTyp.fullNames, 100)).get(random.nextInt(99)));
		customer.setCreditCardInfo(null);
		dao.save(customer);	
	}
	
	@Test
	public void testAdmin(){
		Dao dao = new Dao();
		Random random = new Random();
		Admin admin = new Admin();
		admin.setFirstName("Georg");
		admin.setLastName("Jandel");
		admin.setEmailAddress(DataGenerator.generateRandomEmailAccounts(DataGenerator.generateRandomData(DataGenerator.entityTyp.fullNames, 100)).get(random.nextInt(99)));
		admin.setPassword("super");
		admin.setVerified(true);
		admin.setManagerEmailAddress(admin.getEmailAddress());
		dao.save(admin);
	}
	
	
	
	@Test
	public void testCustomerOrder(){
		Dao dao = new Dao();
		
		Random random = new Random();
		Customer customer = new Customer();
		customer.setFirstName("Fritz");
		customer.setLastName("Heinzl");
		customer.setPassword("sowieso");
		customer.setPhoneNumber("0676234234");
		customer.setShippingAddress(1);
		customer.setBillingAddress(1);
		customer.setEmailAddress(DataGenerator.generateRandomEmailAccounts(DataGenerator.generateRandomData(DataGenerator.entityTyp.fullNames, 100)).get(random.nextInt(99)));
		customer.setCreditCardInfo(null);
		dao.save(customer);	
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerEmail(customer.getEmailAddress());
		customerOrder.setDateCreated("223452345");
		customerOrder.setDateShipped("2342342342");
		customerOrder.setOrdered(true);
		customerOrder.setOrderId(1);
		dao.save(customerOrder);
	}
	
	@Test
	public void testCustomerCreditCard(){
		Dao dao = new Dao();
		CreditCard creditcard = new CreditCard();
		creditcard.setCardNumber(DataGenerator.generateRandomCreditCards(100).get(0));
		creditcard.setCvv("123");
		creditcard.setExpiryMonth(2);
		creditcard.setExpiryYear(2019);
		creditcard.setFirstName("Gerhard");
		creditcard.setLastName("Oberdorfler");
		creditcard.setType("MasterCard");
		dao.save(creditcard);
	}

	@Test
	public void testOrderDetail(){
		Dao dao = new Dao();
		
		Random random = new Random();
		Customer customer = new Customer();
		customer.setFirstName("Fritz");
		customer.setLastName("Heinzl");
		customer.setPassword("sowieso");
		customer.setPhoneNumber("0676234234");
		customer.setShippingAddress(1);
		customer.setBillingAddress(1);
		customer.setEmailAddress(DataGenerator.generateRandomEmailAccounts(DataGenerator.generateRandomData(DataGenerator.entityTyp.fullNames, 100)).get(random.nextInt(99)));
		customer.setCreditCardInfo(null);
		dao.save(customer);	
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerEmail(customer.getEmailAddress());
		customerOrder.setDateCreated("223452345");
		customerOrder.setDateShipped("2342342342");
		customerOrder.setOrdered(true);
		customerOrder.setOrderId(1);
		dao.save(customerOrder);
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setProductId(1);
		orderDetail.setQuantity(12);
		orderDetail.setSubTotal(2.45F);
		//TODO
		//orderDetail.setOrderId(dao.getobjects(CustomerOrder.class).get(0).getOrderId());
		orderDetail.setOrderId(1);//provisorisch
		dao.save(orderDetail);
	}

}

package imse.SS2017.team1.junits;

import java.util.Random;

import org.junit.Test;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.database.DataGenerator;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;

public class NoSqlJunit {

	@Test
	public void testGetMethod() {
		Dao dao = new Dao();
		System.out.println(dao.getobject(Product.class, 1));
	}
	
	@Test
	public void testGetAll() {
		Dao dao = new Dao();
		System.out.println(dao.getobjects(Category.class).get(0).getCategoryName());
	}
	
	@Test
	public void testProduct() {
		Dao dao = new Dao();
		for(int i=0;i<100;++i){
		Category category1 = new Category();
		category1.setCategoryName("Computer");
		category1.setCategoryId(10000);
		dao.save(category1);
		
		Category category2 = new Category();
		category2.setCategoryName("Taschenrechner");
		category2.setCategoryId(100001);
		dao.save(category2);
		
		Product product = new Product();
		product.setProductId(19);
		product.setDescription("Alles klar");
		product.setProductName("Rechner");
		product.setCategories(category1);
		product.setCategories(category2);
		product.setPrice(23.45F);
		product.setQuantity(2);
		
		product.getImages().add(new Image("image1straem"));
		product.getImages().add(new Image("image2straem"));
		
		dao.save(product);
		}
		dao.close();		
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
		
		CreditCard creditcard = new CreditCard();
		creditcard.setCardNumber(DataGenerator.generateRandomCreditCards(100).get(0));
		creditcard.setCvv("123");
		creditcard.setExpiryMonth(2);
		creditcard.setExpiryYear(2019);
		creditcard.setFirstName("Fritz");
		creditcard.setLastName("Heinzl");
		creditcard.setType("MasterCard");
		
		customer.setCreditCardInfo(creditcard.getCardNumber());
		customer.setCreditCard(creditcard);
		dao.save(customer);	
	}

}

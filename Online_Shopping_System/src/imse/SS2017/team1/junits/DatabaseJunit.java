package imse.SS2017.team1.junits;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;

import org.junit.Test;

/**
 * Ids müssen evtl. geändert werden
 *
 */
public class DatabaseJunit{
	
	@Test
	public void testProduct() {
		Dao dao = new Dao();
		Product product = new Product();
		product.setDescription("Alles klar");
		product.setProductId(1233);
		product.setProductName("Rechner");
		product.setPrice(23.45F);
		dao.save(product);
		
	}
	
	@Test
	public void testAddress() {
		Dao dao = new Dao();
		Address address = new Address();
		address.setCity("Salzburg");
		address.setCountry("Austria");
		address.setAdressId(121);
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
		category.setCategoryId(123);
		category.setCategoryName("Computer");
		dao.save(category);
	}
	
	@Test
	public void testImage(){
		Dao dao = new Dao();
		Image image = new Image();
		image.setImageId(123);
		image.setImageString("asdfgasdgasgas");
		image.setProductId(1233);
		dao.save(image);
	}

}

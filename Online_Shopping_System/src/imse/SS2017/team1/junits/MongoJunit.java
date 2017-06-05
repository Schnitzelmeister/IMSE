package imse.SS2017.team1.junits;

import org.junit.Test;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;

public class MongoJunit {

	@Test
	public void testProduct() {
		Dao dao = new Dao();
		
		Category category1 = new Category();
		category1.setCategoryName("Computer");
		dao.save(category1);
		
		Category category2 = new Category();
		category2.setCategoryName("Taschenrechner");
		dao.save(category2);
		
		Product product = new Product();
		product.setDescription("Alles klar");
		product.setProductName("Rechner");
		product.getCategories().add(category1);
		product.getCategories().add(category2);
		product.setPrice(23.45F);
		product.setQuantity(2);
		
		product.getImages().add(new Image("image1straem"));
		product.getImages().add(new Image("image2straem"));
		
		dao.save(product);
		
		dao.close();		
	}
}

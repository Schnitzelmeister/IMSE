package imse.SS2017.team1.junits;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Product;

public class DatabaseJunit{
	
	public void test() {
		Dao dao = new Dao();
		Product product = new Product();
		product.setDescription("Alles klar");
		product.setProductId(1233);
		product.setProductName("Rechner");
		product.setPrice(23.45F);
		dao.save(product);
		
	}

}

package at.ac.ac.univie.imse.SS2017.team1.junits;

import org.junit.Test;

import at.ac.ac.univie.imse.SS2017.team1.dao.Dao;
import at.ac.ac.univie.imse.SS2017.team1.model.Product;

public class ProjectJunit {

	@Test
	public void test() {
		Dao dao = new Dao();
		Product product = new Product();
		product.setDescription("Alles klar");
		//product.setProductId(1233);
		product.setProductName("Rechner");
		product.setPrice(23.45F);
		dao.save(product);
	}

}

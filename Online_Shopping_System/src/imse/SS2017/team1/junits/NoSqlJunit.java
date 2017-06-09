package imse.SS2017.team1.junits;

import static org.junit.Assert.*;

import org.junit.Test;
import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;
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

}

package imse.SS2017.team1.junits;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.database.DataGenerator;
import imse.SS2017.team1.database.PictureUtility;
import imse.SS2017.team1.database.DataGenerator.entityTyp;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;

public class ConvertImageJunit {

	@Test
	public void test() throws IOException {
		Image image = new Image();
		
		Category category = new Category();
		
		Dao dao = new Dao();
		
		/*System.out.println("Produktkategorien werden generiert!");
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
		}*/
		
		
		//Product product = new Product();
		//product.setDescription("Alles klar");
		//product.setProductName("Rechner");
		//product.setPrice(23.45F);
		//product.setQuantity(2);
		//dao.save(product);
		
		//ProductBelongsCategory productBelongsCategory = new ProductBelongsCategory();

		//productBelongsCategory.setCategoryId(ThreadLocalRandom.current().nextInt(1, 19));
		//productBelongsCategory.setProductId(1);
		//dao.save(productBelongsCategory);
		
		//url muss eigens bestimmt werden z.B. "C:/Users/Raf/Desktop/Salzburg.jpeg"
		String url = "file:/C:/Users/Raf/Desktop/Salzburg.jpeg";
		image.setImageString(PictureUtility.convertPicToString(url));
		image.setProductId(1);
		image.setImageId(1);
		dao.save(image);
		
		List<Image> imageList = dao.getobjects(Image.class);
		//for(Image i:imageList){
			//if(i.getProductId()==1){
				//System.out.print(PictureUtility.convertStringToPic(i.getImageString()));
			//}
		//}
	}

}

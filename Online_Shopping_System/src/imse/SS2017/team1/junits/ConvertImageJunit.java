package imse.SS2017.team1.junits;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.database.PictureUtility;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;

public class ConvertImageJunit {

	@Test
	public void test() throws IOException {
		Image image = new Image();
		
		Dao dao = new Dao();
		Product product = new Product();
		product.setDescription("Alles klar");
		product.setProductName("Rechner");
		product.setPrice(23.45F);
		product.setQuantity(2);
		dao.save(product);
		
		//url muss eigens bestimmt werden z.B. "C:/Users/Raf/Desktop/Salzburg.jpeg"
		String url = "";
		image.setImageString(PictureUtility.convertPicToString(url));
		image.setProductId(1);
		dao.save(image);
		
		List<Image> imageList = dao.getobjects(Image.class);
		for(Image i:imageList){
			if(i.getProductId()==1){
				System.out.print(PictureUtility.convertStringToPic(i.getImageString()));
			}
		}
	}

}

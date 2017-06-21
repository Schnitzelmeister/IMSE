package imse.SS2017.team1.controller;

import java.util.ArrayList;
import java.util.List;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;


public class ProductController {
	
	Dao dao = new Dao();
	
	public Product getProductById(Integer productId){
		return dao.getobject(Product.class, productId);
	}
	
	public List<Product> getProductByName(String productName){
		List<Product> productList = dao.getobjects(Product.class);
		List<Product> sameProducts = new ArrayList<Product>();
		for(Product p:productList){
			if(p.getProductName().equals(productName)){
				sameProducts.add(p);
			}
		}
		return sameProducts;
	}
	
	public Product getProductByParams(String productName, Float price, String description, Integer quantity){
		List<Product> productList = dao.getobjects(Product.class);
		for(Product p:productList){
			if(p.getDescription().equals(description) && p.getPrice().equals(price) && p.getProductName().equals(productName) && p.getQuantity().equals(quantity)){
				return p;
			}
		}
		return null;
	}
	
	public List<Product> getProductByPrice(Float price){
		List<Product> productList = dao.getobjects(Product.class);
		List<Product> sameProductPrice = new ArrayList<Product>();
		for(Product p:productList){
			if(p.getPrice()==price){
				sameProductPrice.add(p);
			}
		}
		return sameProductPrice;
	}

	public List<Product> getAllProducts(){
		return dao.getobjects(Product.class);
	}
	
	public void createProduct(String productName, Float price, String description, Integer quantity, List<String> images, List<String> categories){
		Product product = new Product();
		Image image = new Image();
		for(int i=0;i<categories.size();++i){
			product.setCategories(dao.getobject(Category.class, Integer.valueOf(categories.get(i))));
		}
		for(int i=0;i<5;++i){
			if(!images.get(i).isEmpty() && images.get(i).contains("data:image/jpeg;base64,")){
				image = new Image();
				image.setImageString(images.get(i).replaceAll("data:image/jpeg;base64,", ""));
				image.setImageId(i+1);
				image.setProductId(0);
				product.setImages(image);
			}
		}
		product.setDescription(description);
		product.setPrice(price);
		product.setProductName(productName);
		product.setQuantity(quantity);
		product.setProductId(generateId());
		dao.save(product);
	}
	
	public void deleteProductById(Integer productId){
		dao.delete(dao.getobject(Product.class, productId));
	}
	
	public void updateProduct(Integer productId, String productName, Float price, 
			String description, Integer quantity, List<String> images, List<String> categories) {
		Product product = dao.getobject(Product.class, productId);
		if(categories!=null){
			for(int i=0;i<categories.size();++i){
				product.setCategories(dao.getobject(Category.class, Integer.valueOf(categories.get(i))));
			}
		}
		Image image = new Image();
		for(int i=0;i<5;++i){
			if(!images.get(i).isEmpty() && images.get(i).contains("data:image/jpeg;base64,")) {
				image = new Image();
				image.setImageString(images.get(i).replaceAll("data:image/jpeg;base64,", ""));
				image.setImageId(i+1);
				image.setProductId(0);
				product.setImages(image);
			}
		}
		
		if(description!=null && !product.getDescription().equals(description)){
			product.setDescription(description);
		}
		if(!product.getPrice().equals(price) && price!=null){
			product.setPrice(price);
		}
		if(productName!=null && !product.getProductName().equals(productName)){
			product.setProductName(productName);
		}
		if(product.getQuantity()!=quantity && quantity!=null){
			product.setQuantity(quantity);
		}
		dao.updateEntity(product);	
	}
	
	public String getProductpictures(Integer productId){
		try{
			return dao.getobject(Product.class, productId).getImages().get(0).getImageString();	
		} catch (ArrayIndexOutOfBoundsException e){
			return null;
		}
	}
	
	public Image addProductImage(String imageString, Integer productId){
		Image image = new Image();
		image.setImageString(imageString);
		image.setProductId(productId);
		image.setImageId(0);
		return image;
	}
	
	public void deleteImage(String imageId){
		dao.delete(imageId);
	}
	
	//TODO
	public List<Image> getAllProductImages(){
		return null;
	}
	
	//TODO
	public List<Image> getAllImagesOfSpecProduct(){
		return null;
	}
	
	public void close() {
		dao.close();
	}
	
	public Integer generateId(){
		List<Product> products = getAllProducts();
		if(products.isEmpty()){
			return 1;
		}
		return products.get(products.size()-1).getProductId()+1;
	}
	
}

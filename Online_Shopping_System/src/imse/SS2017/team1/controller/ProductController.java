package imse.SS2017.team1.controller;

import java.util.ArrayList;
import java.util.List;

import imse.SS2017.team1.dao.Dao;
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

	public List<Product> GetAllProducts(){
		return dao.getobjects(Product.class);
	}
	
	public void createProduct(String productName, Float price, String description, Integer quantity){
		Product product = new Product();
		product.setDescription(description);
		product.setPrice(price);
		product.setProductName(productName);
		product.setQuantity(quantity);
		dao.save(product);
	}
	
	public void addProductImage(String imageString, Integer productId){
		Image image = new Image();
		image.setImageString(imageString);
		image.setProductId(productId);
		dao.save(image);
		
	}
	
	public void deleteProductById(Integer productId){
		dao.delete(dao.getobject(Product.class, productId));
	}
	
	public void deleteImage(String imageId){
		dao.delete(imageId);
	}
	
	public void updateProduct(Integer productId, String productName, Float price, 
			String description, Integer quantity) {
		Product product = dao.getobject(Product.class, productId);
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
	
}

package imse.SS2017.team1.controller;

import java.util.ArrayList;
import java.util.List;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.Product;
import imse.SS2017.team1.model.ProductBelongsCategory;


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
	
	public void updateProduct(Integer productId, String productName, String price, 
			String description, String quantity) {
		Product product = dao.getobject(Product.class, productId);
		
		if(description!=null && !product.getDescription().equals(description)){
			product.setDescription(description);
		}
		if(price!=null && !product.getPrice().equals(Float.valueOf(price))){
			product.setPrice(Float.valueOf(price));
		}
		if(productName!=null && !product.getProductName().equals(productName)){
			product.setProductName(productName);
		}
		if(quantity!=null && product.getQuantity()!=Integer.valueOf(quantity)){
			product.setQuantity(Integer.valueOf(quantity));
		}
		
		dao.updateEntity(product);	
	}
	
	public void createProductBelongsCategory(Integer productId, Integer categoryId){
		ProductBelongsCategory prodbelongscat = new ProductBelongsCategory();
		prodbelongscat.setCategoryId(categoryId);
		prodbelongscat.setProductId(productId);
		dao.save(prodbelongscat);
	}
	
	public void deleteProductBelongsCategory(Integer productId){
		dao.deleteProductBelongsCategory(productId);
	}
	
}

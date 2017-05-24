package at.ac.ac.univie.imse.SS2017.team1.controller;

import java.util.ArrayList;
import java.util.List;

import at.ac.ac.univie.imse.SS2017.team1.dao.Dao;
import at.ac.ac.univie.imse.SS2017.team1.model.Product;


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

	public List<Product> GetAllProduct(){
		return dao.getobjects(Product.class);
	}
	
	public void createProduct(String productName, Float price, String description){
		Product product = new Product();
		product.setDescription(description);
		product.setPrice(price);
		product.setProductId(generateId());
		product.setProductName(productName);
		dao.save(product);
	}
	
	public void addProductImage(String image){
		
		
	}
	
	public void deleteProductById(Integer productId){
		dao.delete(productId);
	}
	
	public void deleteImage(String image){
		
	}
	
	public void updateProductName(Integer productId, String productName){
		Product product = dao.getobject(Product.class, productId);
		product.setProductName(productName);
	}
	
	public void updateProductPrice(Integer productId, Float price){
		Product product = dao.getobject(Product.class, productId);
		product.setPrice(price);
	}
	
	public void updateProductDescription(Integer productId, String description){
		Product product = dao.getobject(Product.class, productId);
		product.setDescription(description);
	}
	
	private Integer generateId(){
		return 0;
	}
	
}

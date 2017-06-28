package imse.SS2017.team1.controller;

import java.util.List;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Product;

public class CategoryController {
	
	Dao dao = new Dao();

	public void createCategory(String categoryName){
		Category category = new Category();
		category.setCategoryName(categoryName);
		dao.save(category);
	}
	
	public void deleteCategory(Integer categoryId){
		dao.deleteCategoryBelongsProduct(categoryId);
		dao.delete(dao.getobject(Category.class, categoryId));
		
		List<Product> products = dao.getobjects(Product.class);
		for(Product p:products){
			if(!dao.checkProductBelongsCategory(p.getProductId())){
				dao.delete(p);
			}
		}
	}
	
	public Category getCategoryByName(String categoryName){
		List<Category> categoryList = dao.getobjects(Category.class);
		for(Category c:categoryList){
			if(c.getCategoryName().equals(categoryName)){
				return c;
			}
		}
		return null;
	}
	
	public Category getCategoryById(Integer Id){
		return dao.getobject(Category.class, Id);
	}
	
	public List<Category> getAllCategories(){
		return dao.getobjects(Category.class);
	}
	
}

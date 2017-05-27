package imse.SS2017.team1.controller;

import java.util.List;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;

public class CategoryController {
	
	Dao dao = new Dao();

	public void createCategory(String categoryName){
		Category category = new Category();
		category.setCategoryId(generateId());
		category.setCategoryName(categoryName);
		dao.save(category);
	}
	
	public void deleteCategory(String categoryId){
		dao.delete(categoryId);
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
	
	private Integer generateId(){
		return 0;
	}
}

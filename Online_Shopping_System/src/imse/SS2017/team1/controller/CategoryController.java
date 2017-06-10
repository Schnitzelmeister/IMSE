package imse.SS2017.team1.controller;

import java.util.List;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;

public class CategoryController {
	
	Dao dao = new Dao();

	public void createCategory(String categoryName){
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryId(generateId());
		dao.save(category);
	}
	
	public void deleteCategory(Integer categoryId){
		dao.delete(dao.getobject(Category.class, categoryId));
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
	
	public void close(){
		dao.close();
	}
	
	public Integer generateId(){
		List<Category> categories = getAllCategories();
		return categories.get(categories.size()-1).getCategoryId()+1;
	}
	
}

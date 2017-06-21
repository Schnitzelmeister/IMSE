package imse.SS2017.team1.controller;

import java.util.ArrayList;
import java.util.List;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.Product;

public class CategoryController {
	
	Dao dao = new Dao();

	public void createCategory(String categoryName){
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryId(generateId());
		dao.save(category);
	}
	
	public void deleteCategory(Integer categoryId){
		List<Product> products = dao.getobjects(Product.class);
		ProductController productController = new ProductController();
		Category categ = dao.getobject(Category.class, categoryId);
		
		for(Product p:products){
			if(p.getCategories().contains(categ)){
				if(p.getCategories().size()==1){
					dao.delete(p);
				} else {
					List<String> cats = new ArrayList<String>();
					for(int i=0;i<p.getCategories().size();++i){
						if(!p.getCategories().get(i).equals(categ)){
							cats.add(String.valueOf(p.getCategories().get(i).getCategoryId()));
						}
					}
						productController.updateProduct(p.getProductId(), null, null, null, null, null, cats);
				}
			}		
		}
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
	
	public void close() {
		dao.close();
	}
	
	public Integer generateId(){
		List<Category> categories = getAllCategories();
		if(categories.isEmpty()){
			return 1;
		}
		return categories.get(categories.size()-1).getCategoryId()+1;
	}

}

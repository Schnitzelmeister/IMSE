package imse.SS2017.team1.filter;

import java.util.List;
import java.util.regex.Pattern;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.model.Category;

public class Validator {

	public Boolean isCategoryNameOk(String categoryname){
		
		CategoryController categorycontroller = new CategoryController();
		List<Category> categories = categorycontroller.getAllCategories();
		
		if(!categoryname.contains("Kategoriename")){
			for(Category cat:categories){
				if(cat.getCategoryName().equals(categoryname)){
					return false;
				}
			}
			return isNameOk(categoryname);
		} else {
			return false;
		}
			
	}
	
	public Boolean isProductNameOk(String productname){
		
		if(!productname.contains("Produktname")){
			return isNameOk(productname);
		} else {
			return false;
		}
	}
	
	public Boolean isNameOk(String name){
		return Pattern.matches("[a-z,A-Z]{3,45}+", name);
	}
	
	public Boolean isQuantityOk(String quantity){
		return Pattern.matches("[0-9]{1,11}+", quantity);
	}
	
	public Boolean isPriceOk(String price){
		return Pattern.matches("([0-9]{1,5}+[.,]{1}[0-9]{0,2}+)|([0-9]{1,5})", price);
	}
	
	public Boolean isDescriptionOk(String description){
		
		if(!description.contains("Beschreibung....") && description.length()>10 && description.length()<3000){
			return true;
		} else {
			return false;
		}
		
	}
	
}

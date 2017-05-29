package imse.SS2017.team1.searchengine;

import java.util.List;
import java.util.Map;

public class FoundResult {

	FoundResult(Map<Integer, String> categories, List<FoundProduct> foundProducts, Map<Integer, Integer> foundCategoriesStat, String searchText, int categoryId, int sortMode, int pageNumber, int pageSize) {
		this.categories = categories;
		this.foundProducts = foundProducts;
		this.foundCategoriesStat = foundCategoriesStat;
		this.searchText = searchText;
		this.categoryId = categoryId;
		this.sortMode = sortMode;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	private List<FoundProduct> foundProducts;
	public List<FoundProduct> getFoundProducts() {
		return foundProducts;
	}
	private Map<Integer, Integer> foundCategoriesStat;
	public Map<Integer, Integer> getFoundCategoriesStat() {
		return foundCategoriesStat;
	}

	private String searchText;
	public String getSearchText() {
		return searchText;
	}
	private int categoryId;
	public int getCategoryId() {
		return categoryId;
	}
	private int sortMode;
	public int getSortMode() {
		return sortMode;
	}
	private int pageNumber;
	public int getPageNumber() {
		return pageNumber;
	}
	private int pageSize;
	public int getPageSize() {
		return pageSize;
	}
	
	private Map<Integer, String> categories;
	public String getCategoryNameById(int id){
		return categories.get(id);
	}
	
	public Map<Integer, String> getCategories() {
		return categories;
	}
	
}

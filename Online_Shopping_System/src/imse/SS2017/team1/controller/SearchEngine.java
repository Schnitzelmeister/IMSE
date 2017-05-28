package imse.SS2017.team1.controller;

//import java.util.Map;

public interface SearchEngine {
	public FoundResult getResults(String searchText, int categoryId, int sortMode);
	public FoundResult getResults(String searchText, int categoryId, int sortMode, int pageNumber);
	/*public String getCategoryNameById(int id);
	public Map<Integer, String> getCategories();*/
}

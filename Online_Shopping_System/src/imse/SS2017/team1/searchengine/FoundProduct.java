package imse.SS2017.team1.searchengine;

public class FoundProduct {
	
	FoundProduct(int id, String name, double price, String description, int availableQuantity, String categories) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.availableQuantity = availableQuantity;
		this.categories = categories;
	}
	
	private int id;
	public int getId() {
		return id;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	
	private double price;
	public double getPrice() {
		return price;
	}
	
	private String description;
	public String getDescription() {
		return description;
	}
	
	private int availableQuantity;
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	;

	private String categories;
	public String getCategories() {
		return categories;
	}

	public int[] getCategoryIds() {
		String[] strArray = categories.split(",");
		int[] intArray = new int[strArray.length];
		for(int i = 0; i < strArray.length; i++) {
		    intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}
}

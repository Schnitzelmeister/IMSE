package imse.SS2017.team1.model;

import java.util.Map;
import java.util.TreeMap;

//Save only in Session, not in DB
public class Cart {
	public Map<Integer, Integer> items;
	
	public Cart() { items = new TreeMap<Integer, Integer>(); }
	
	public void addToCart(int productId, int quantity) {
		if (quantity == 0 && items.containsKey(productId))
			items.remove(productId);
		else if (quantity != 0)
			items.put(productId, quantity);
	}
}

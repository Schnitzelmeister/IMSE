package imse.SS2017.team1.model;

import java.util.Map;
import java.util.TreeMap;

import imse.SS2017.team1.controller.ProductController;

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
	
	public static boolean isQuantityAvailable(int productId, int quantity) throws IllegalArgumentException  {
		ProductController pc = new ProductController();
		try {
			return (quantity <= pc.getProductById(productId).getQuantity());
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public static boolean isQuantityAvailable(Cart cart) throws IllegalArgumentException {
		ProductController pc = new ProductController();
		try {
			
			for ( Map.Entry<Integer, Integer> me : cart.items.entrySet() ) {
				if (me.getValue() > pc.getProductById(me.getKey()).getQuantity())
					return false;
			}
			
			return true;
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}

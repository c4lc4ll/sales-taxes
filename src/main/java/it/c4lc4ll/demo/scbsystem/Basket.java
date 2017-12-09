package it.c4lc4ll.demo.scbsystem;

import java.util.HashMap;
import java.util.Map;

import it.c4lc4ll.demo.scbsystem.item.ItemInterface;

public class Basket {

	private Map<ItemInterface, Integer> items = new HashMap<ItemInterface, Integer>();

	public void addItem(ItemInterface item, int quantity) {
		int totalOfItem = 0;
		if (items.containsKey(item)) {
			totalOfItem = items.get(item);
		}
		items.put(item, totalOfItem + quantity);
	}

	public Map<ItemInterface, Integer> getItems() {
		return items;
	}
}

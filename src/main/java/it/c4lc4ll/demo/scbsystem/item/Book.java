package it.c4lc4ll.demo.scbsystem.item;

import java.math.BigDecimal;

public class Book extends Item {

	public Book(String productName, boolean imported, BigDecimal price, String itemId) {
		super(productName, imported, price, itemId);
		this.setTaxes(new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}

}

package it.c4lc4ll.demo.scbsystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.c4lc4ll.demo.scbsystem.Basket;
import it.c4lc4ll.demo.scbsystem.item.Book;
import it.c4lc4ll.demo.scbsystem.item.Food;
import it.c4lc4ll.demo.scbsystem.item.ItemInterface;

@DisplayName("Basket test")
public class BasketTest {
	protected Basket basket;

	@BeforeEach
	void initInvoice() {
		basket = new Basket();
	}

	@Test
	@DisplayName("Test 1")
	void firstExample() {
		ItemInterface book = new Book("Book", false, new BigDecimal(12.49), "1-1");
		ItemInterface book2 = new Book("Book", false, new BigDecimal(12.49), "1-1");
		ItemInterface cb = new Food("Chocolate bar", false, new BigDecimal(0.85), "1-3");
		basket.addItem(book, 1);
		basket.addItem(book2, 1);
		basket.addItem(cb, 1);
		assertEquals(Integer.valueOf(2), basket.getItems().get(book));
	}

}

package it.c4lc4ll.demo.scbsystem.test.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.c4lc4ll.demo.scbsystem.item.Book;
import it.c4lc4ll.demo.scbsystem.item.Food;
import it.c4lc4ll.demo.scbsystem.item.Item;
import it.c4lc4ll.demo.scbsystem.item.ItemInterface;

@DisplayName("Item test")
public class ItemTest {

	protected ItemInterface item;

	@Test
	@DisplayName("Item Test 1")
	void firstItemTest() {
		ItemInterface item = new Book("Book", false, new BigDecimal(12.49), "1-1");
		assertEquals(new BigDecimal(12.49).setScale(2, BigDecimal.ROUND_HALF_EVEN), item.getPriceWithTaxes());
	}

	@Test
	@DisplayName("Item Test 2")
	void secondItemTest() {
		ItemInterface item = new Item("Music CD", false, new BigDecimal(14.99), "1-2");
		assertEquals(new BigDecimal(16.49).setScale(2, BigDecimal.ROUND_HALF_EVEN), item.getPriceWithTaxes());
	}

	@Test
	@DisplayName("Item Test 3")
	void thirdItemTest() {
		ItemInterface item = new Food("Imported box of chocolates", true, new BigDecimal(11.25), "3-4");
		assertEquals(new BigDecimal(11.85).setScale(2, BigDecimal.ROUND_HALF_EVEN), item.getPriceWithTaxes());
	}

}

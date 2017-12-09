package it.c4lc4ll.demo.scbsystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.c4lc4ll.demo.scbsystem.Basket;
import it.c4lc4ll.demo.scbsystem.Invoice;
import it.c4lc4ll.demo.scbsystem.item.Book;
import it.c4lc4ll.demo.scbsystem.item.Food;
import it.c4lc4ll.demo.scbsystem.item.Item;
import it.c4lc4ll.demo.scbsystem.item.ItemInterface;
import it.c4lc4ll.demo.scbsystem.item.Medical;

@DisplayName("Invoice test")
class InvoiceTest {

	protected Invoice invoice;
	protected List<ItemInterface> items;
	protected Basket basket;

	@BeforeEach
	void initInvoice() {
		items = new ArrayList<ItemInterface>();
		basket = new Basket();
		invoice = new Invoice(basket);
	}

	@Test
	@DisplayName("Test 1")
	void firstExample() {
		ItemInterface book = new Book("Book", false, new BigDecimal(12.49), "1-1");
		ItemInterface mcd = new Item("Music CD", false, new BigDecimal(14.99), "1-2");
		ItemInterface cb = new Food("Chocolate bar", false, new BigDecimal(0.85), "1-3");
		basket.addItem(book, 1);
		basket.addItem(mcd, 1);
		basket.addItem(cb, 1);
		System.out.println("Items for test 1");
		invoice.printItems();
		System.out.println("Invoice for test 1");
		invoice.printInvoice();
		BigDecimal totalfees = invoice.calculateTotalFees();
		assertEquals(new BigDecimal(1.5).setScale(2, RoundingMode.HALF_EVEN), totalfees);
	}

	@Test
	@DisplayName("Test 2")
	void secondExample() {
		ItemInterface ibc = new Food("Imported Box of chocolates", true, new BigDecimal(10.00), "2-1");
		ItemInterface ibp = new Item("Imported Bottle of perfume", true, new BigDecimal(47.50), "2-2");
		basket.addItem(ibc, 1);
		basket.addItem(ibp, 1);
		System.out.println();
		System.out.println("Items for test 2");
		invoice.printItems();
		System.out.println("Invoice for test 2");
		invoice.printInvoice();
		BigDecimal totalfees = invoice.calculateTotalFees();
		assertEquals(new BigDecimal(7.65).setScale(2, RoundingMode.HALF_EVEN).setScale(2, BigDecimal.ROUND_HALF_EVEN),
				totalfees);
	}

	@Test
	@DisplayName("Test 3")
	void thidExample() {
		ItemInterface ibp = new Item("Imported Bottle of perfume", true, new BigDecimal(27.99), "3-1");
		ItemInterface b = new Item("Bottle of perfume", false, new BigDecimal(18.99), "3-2");
		ItemInterface php = new Medical("Packet of headache pills", false, new BigDecimal(9.75), "3-3");
		ItemInterface ibc = new Food("Imported box of chocolates", true, new BigDecimal(11.25), "3-4");
		basket.addItem(ibp, 1);
		basket.addItem(b, 1);
		basket.addItem(php, 1);
		basket.addItem(ibc, 1);
		System.out.println();
		System.out.println("Items for test 3");
		invoice.printItems();
		System.out.println("Invoice for test 3");
		invoice.printInvoice();
		BigDecimal total = invoice.calculateTotal();
		assertEquals(new BigDecimal(74.68).setScale(2, RoundingMode.HALF_EVEN), total);
	}
}
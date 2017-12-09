package it.c4lc4ll.demo.scbsystem;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import it.c4lc4ll.demo.scbsystem.item.ItemInterface;

public class Invoice {

	private Map<ItemInterface, Integer> items;

	public Invoice(Basket basket) {
		super();
		this.items = basket.getItems();
		// TODO Auto-generated constructor stub
	}

	public BigDecimal calculateTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Entry<ItemInterface, Integer> item : items.entrySet()) {
			total = total.add(item.getKey().getPriceWithTaxes()).multiply(new BigDecimal(item.getValue())).setScale(2,
					BigDecimal.ROUND_HALF_EVEN);
		}
		return total;
	}

	public BigDecimal calculateTotalFees() {
		BigDecimal total = new BigDecimal(0);
		for (Entry<ItemInterface, Integer> item : items.entrySet()) {
			total = total.add(item.getKey().calculateTaxes()).multiply(new BigDecimal(item.getValue())).setScale(2,
					BigDecimal.ROUND_HALF_EVEN);
		}
		return total;
	}

	public void printItems() {
		items.forEach((k, v) -> {
			System.out.printf(v + " " + k.getProductName() + " %.2f  \n",
					k.getPrice().multiply(new BigDecimal(v)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		});
	}

	public void printInvoice() {
		items.forEach((k, v) -> {
			System.out.printf(v + " " + k.getProductName() + " %.2f  \n",
					k.getPriceWithTaxes().multiply(new BigDecimal(v)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		});
		System.out.printf("Sales Taxes: " + " %.2f  \n", calculateTotalFees());
		System.out.printf("Total: " + " %.2f  \n", calculateTotal());
	}

}

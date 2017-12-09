package it.c4lc4ll.demo.scbsystem.item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Item implements ItemInterface {

	private String itemId;
	private String productName;
	private boolean imported;
	private BigDecimal taxesRate;
	private BigDecimal price;

	public Item(String productName, boolean imported, BigDecimal price, String itemId) {
		super();
		this.taxesRate = new BigDecimal(0.1).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		this.productName = productName;
		this.imported = imported;
		this.price = price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		this.itemId = itemId;
	}

	public BigDecimal calculateTaxes() {
		BigDecimal totalTaxesRate = taxesRate;
		if (imported)
			totalTaxesRate = totalTaxesRate.add(new BigDecimal(0.05).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		return round(totalTaxesRate.multiply(price));
	}

	public BigDecimal getPriceWithTaxes() {
		return calculateTaxes().add(price).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	private BigDecimal round(BigDecimal fees) {
		return fees.multiply(new BigDecimal(20.0)).setScale(0, RoundingMode.UP)
				.divide(new BigDecimal(20.0).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public BigDecimal getTaxesRate() {
		return taxesRate;
	}

	protected void setTaxes(BigDecimal taxesRate) {
		this.taxesRate = taxesRate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	protected void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Item) {
			Item c = (Item) o;
			if (this.itemId.equalsIgnoreCase(c.itemId))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, productName, imported, taxesRate, price);
	}

}

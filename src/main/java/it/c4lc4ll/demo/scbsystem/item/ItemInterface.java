package it.c4lc4ll.demo.scbsystem.item;

import java.math.BigDecimal;

public interface ItemInterface {
	public BigDecimal calculateTaxes();

	public String getProductName();

	public BigDecimal getPriceWithTaxes();

	public BigDecimal getPrice();
}

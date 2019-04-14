package com.adneom.test.supermarket.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Apple extends AbstractProduct {

	public Apple(String name, Float price, Integer quantity) {
		super(name, price, quantity);
	}

	@Override
	public BigDecimal calculatePrice() {
		float price = quantity / 2 * unitPrice;
		price += (quantity % 2) * unitPrice;
		BigDecimal decimal = new BigDecimal(price);
		return decimal.setScale(2, RoundingMode.HALF_UP);
	}

}

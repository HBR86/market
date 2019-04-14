package com.adneom.test.supermarket.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Watermelon extends AbstractProduct {

	public Watermelon(String name, Float price, Integer quantity) {
		super(name, price, quantity);
	}

	@Override
	public BigDecimal calculatePrice() {
		float price = (quantity / 3) * unitPrice * 2;
		price += (quantity % 3) * unitPrice;
		BigDecimal decimal = new BigDecimal(price);
		return decimal.setScale(2, RoundingMode.HALF_UP);
	}

}

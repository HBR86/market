package com.adneom.test.supermarket.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Apple extends AbstractProduct {

	public Apple(String name, Float price, Integer quantity) {
		super(name, price, quantity);
	}

	/**
	 * pour les pommes, 2 sont vendus au prix de un
	 */
	@Override
	public BigDecimal calculatePrice() {
		float price = quantity / 2 * unitPrice;
		price += (quantity % 2) * unitPrice;
		BigDecimal decimal = new BigDecimal(price);
		// on n'a besoin que de 2 chiffres après la virgule
		return decimal.setScale(2, RoundingMode.HALF_UP);
	}

}

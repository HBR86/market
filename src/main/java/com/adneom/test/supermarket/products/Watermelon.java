package com.adneom.test.supermarket.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Watermelon extends AbstractProduct {

	public Watermelon(String name, Float price, Integer quantity) {
		super(name, price, quantity);
	}

	/**
	 * pour les pastèques, 3 sont vendus au prix de 2
	 */
	@Override
	public BigDecimal calculatePrice() {
		float price = (quantity / 3) * unitPrice * 2;
		price += (quantity % 3) * unitPrice;
		BigDecimal decimal = new BigDecimal(price);
		// on n'a besoin que de 2 chiffres après la virgule
		return decimal.setScale(2, RoundingMode.HALF_UP);
	}

}

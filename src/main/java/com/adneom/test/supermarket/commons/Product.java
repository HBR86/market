package com.adneom.test.supermarket.commons;

import java.math.BigDecimal;

public interface Product {

	String getName();

	int getQuantity();

	float getUnitPrice();

	BigDecimal calculatePrice();

	default BigDecimal accept(Visitor visitor) {
		return visitor.visit(this);
	}

}

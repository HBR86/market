package com.adneom.test.supermarket;

import java.math.BigDecimal;

public interface Product {
	
	String getName();
	int getQuantity();
	float getUnitPrice();
	BigDecimal calculatePrice();
	BigDecimal accept(Visitor visitor);

}

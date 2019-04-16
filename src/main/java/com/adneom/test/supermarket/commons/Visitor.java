package com.adneom.test.supermarket.commons;

import java.math.BigDecimal;

public interface Visitor {
	
	BigDecimal visit(Product product);

}

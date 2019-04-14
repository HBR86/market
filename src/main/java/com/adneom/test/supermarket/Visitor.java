package com.adneom.test.supermarket;

import java.math.BigDecimal;

public interface Visitor {
	
	BigDecimal visit(Product product);

}

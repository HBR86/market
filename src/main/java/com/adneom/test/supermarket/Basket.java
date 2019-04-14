package com.adneom.test.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Basket implements Visitor {

	private Set<Product> products = new HashSet<>();
	
	boolean addProduct(Product product){
		return products.add(product);
	}
	
	public BigDecimal calculateTotalPrice(){
		BigDecimal totalPrice = new BigDecimal("0.00");
		for(Product product : products){
			totalPrice = totalPrice.add(product.accept(this));
		}
		return totalPrice.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal visit(Product product) {
		return product.calculatePrice();
	}

}

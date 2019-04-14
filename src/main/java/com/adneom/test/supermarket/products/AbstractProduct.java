package com.adneom.test.supermarket.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.adneom.test.supermarket.Product;
import com.adneom.test.supermarket.Visitor;

public abstract class AbstractProduct implements Product {

	protected String name;
	protected float unitPrice;
	protected int quantity;

	AbstractProduct(String name, float price, int quantity) {
		if(name == null){
			throw new IllegalArgumentException("The product name should be given");
		}
		this.name = name;
		this.unitPrice = price;
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public float getUnitPrice() {
		return unitPrice;
	}

	@Override
	public BigDecimal accept(Visitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public BigDecimal calculatePrice() {
		BigDecimal decimal = new BigDecimal(unitPrice * quantity);
		return decimal.setScale(2, RoundingMode.HALF_UP);
	}
}

package com.adneom.test.supermarket.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.adneom.test.supermarket.Product;

/**
 * Cette classe pr�sente une abstraction des diff�rents types de produits. Elle
 * rassemble les propri�t�s en commun de tous les produits
 * 
 * @author hbenrejeb
 *
 */
public abstract class AbstractProduct implements Product {

	protected String name;
	protected float unitPrice;
	protected int quantity;

	/**
	 * 
	 * 
	 * @param name
	 * @param price
	 * @param quantity
	 * 
	 * @throws @IllegalArgumentException
	 *             if the name is not defined
	 */
	AbstractProduct(String name, float price, int quantity) {
		if (name == null) {
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

	/**
	 * le definition par defaut de la m�thode calculatePrice. Elle est utilis�e
	 * si aucune promotion n'est d�finie sur le produit
	 */
	@Override
	public BigDecimal calculatePrice() {
		BigDecimal decimal = new BigDecimal(unitPrice * quantity);
		return decimal.setScale(2, RoundingMode.HALF_UP);
	}
}

package com.adneom.test.supermarket.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Basket implements Visitor {

	/**
	 * repr�sente la liste des produits ajout�s au panier
	 */
	private Set<Product> products = new HashSet<>();

	/**
	 * ajoute un produit au panier
	 * 
	 * @param product
	 * @return <b>true</b> si le produit n'existait pas avant dans le panier
	 *         sinon <b>false</b>
	 */
	public boolean addProduct(Product product) {
		return products.add(product);
	}

	/**
	 * 
	 * @return un decimal repr�sentant le prix total du panier
	 */
	public BigDecimal calculateTotalPrice() {
		BigDecimal totalPrice = new BigDecimal("0.00");
		for (Product product : products) {
			totalPrice = totalPrice.add(product.accept(this));
		}
		// on n'a besoin que de 2 chiffres apr�s la virgule
		return totalPrice.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal visit(Product product) {
		return product.calculatePrice();
	}

}

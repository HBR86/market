package com.adneom.test.supermarket;

import com.adneom.test.supermarket.products.Apple;
import com.adneom.test.supermarket.products.Orange;
import com.adneom.test.supermarket.products.Watermelon;

public class Main {

	public static void main(String[] args) {
		Basket basket = new Basket();
		basket.addProduct(new Apple("apple", 0.2f,4));
		basket.addProduct(new Orange("orange", 0.5f,3));
		basket.addProduct(new Watermelon("watermelon", 0.8f,5));
		System.out.println(basket.calculateTotalPrice());
	}

}

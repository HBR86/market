package com.adneom.test.supermarket;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.adneom.test.supermarket.products.Apple;
import com.adneom.test.supermarket.products.Orange;
import com.adneom.test.supermarket.products.Watermelon;

public class BasketTest {

	@Test
	public void testEmptyBasket() {
		Basket basket = new Basket();
		Assert.assertEquals(new BigDecimal(0.0).doubleValue(), basket.calculateTotalPrice().doubleValue(), 0);
	}

	@Test
	public void testZeroQuantity() {
		Basket basket = new Basket();
		basket.addProduct(new Apple("apple", 0.2f, 0));
		basket.addProduct(new Orange("orange", 0.5f, 0));
		basket.addProduct(new Watermelon("watermelon", 0.8f, 0));
		Assert.assertEquals(new BigDecimal(0.0).doubleValue(), basket.calculateTotalPrice().doubleValue(), 0);
	}

	@Test
	public void testZeroApple() {
		Basket basket = new Basket();
		basket.addProduct(new Apple("apple", 0.2f, 0));
		basket.addProduct(new Orange("orange", 0.5f, 3));
		basket.addProduct(new Watermelon("watermelon", 0.8f, 5));
		Assert.assertEquals(new BigDecimal(4.7).doubleValue(), basket.calculateTotalPrice().doubleValue(), 0);
	}

	@Test
	public void testZeroOrange() {
		Basket basket = new Basket();
		basket.addProduct(new Apple("apple", 0.2f, 4));
		basket.addProduct(new Orange("orange", 0.5f, 0));
		basket.addProduct(new Watermelon("watermelon", 0.8f, 5));
		Assert.assertEquals(new BigDecimal(3.6).doubleValue(), basket.calculateTotalPrice().doubleValue(), 0);
	}

	@Test
	public void testZeroWatermelon() {
		Basket basket = new Basket();
		basket.addProduct(new Apple("apple", 0.2f, 4));
		basket.addProduct(new Orange("orange", 0.5f, 3));
		basket.addProduct(new Watermelon("watermelon", 0.8f, 0));
		Assert.assertEquals(new BigDecimal(1.9).doubleValue(), basket.calculateTotalPrice().doubleValue(), 0);
	}

	@Test
	public void testMixedQuantity() {
		Basket basket = new Basket();
		basket.addProduct(new Apple("apple", 0.2f, 4));
		basket.addProduct(new Orange("orange", 0.5f, 3));
		basket.addProduct(new Watermelon("watermelon", 0.8f, 5));
		Assert.assertEquals(new BigDecimal(5.1).doubleValue(), basket.calculateTotalPrice().doubleValue(), 0);
	}

}

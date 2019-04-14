package com.adneom.test.supermarket;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.adneom.test.supermarket.products.Apple;

public class AppleTest {

	@Test
	public void testCalculatePrice() {
		Product apple = new Apple("apple", 0.2f, 0);
		Assert.assertEquals(new BigDecimal(0.00).doubleValue(), apple.calculatePrice().doubleValue(), 0);

		apple = new Apple("apple", 0.2f, 1);
		Assert.assertEquals(new BigDecimal(0.20).doubleValue(), apple.calculatePrice().doubleValue(), 0);

		apple = new Apple("apple", 0.2f, 2);
		Assert.assertEquals(new BigDecimal(0.20).doubleValue(), apple.calculatePrice().doubleValue(), 0);

		apple = new Apple("apple", 0.2f, 3);
		Assert.assertEquals(new BigDecimal(0.40).doubleValue(), apple.calculatePrice().doubleValue(), 0);

		apple = new Apple("apple", 0.2f, 4);
		Assert.assertEquals(new BigDecimal(0.40).doubleValue(), apple.calculatePrice().doubleValue(), 0);

		apple = new Apple("apple", 0.2f, 5);
		Assert.assertEquals(new BigDecimal(0.60).doubleValue(), apple.calculatePrice().doubleValue(), 0);
	}

}

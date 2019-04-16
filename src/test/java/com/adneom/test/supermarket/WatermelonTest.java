package com.adneom.test.supermarket;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.adneom.test.supermarket.commons.Product;
import com.adneom.test.supermarket.products.Watermelon;

public class WatermelonTest {
	
	@Test
	public void testCalculatePrice(){
		Product watermelon = new Watermelon("Watermelon", 0.8f, 0);
		Assert.assertEquals(new BigDecimal(0.00).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 1);
		Assert.assertEquals(new BigDecimal(0.80).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 2);
		Assert.assertEquals(new BigDecimal(1.60).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 3);
		Assert.assertEquals(new BigDecimal(1.60).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 4);
		Assert.assertEquals(new BigDecimal(2.40).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 5);
		Assert.assertEquals(new BigDecimal(3.20).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);
		
		watermelon = new Watermelon("Watermelon", 0.8f, 6);
		Assert.assertEquals(new BigDecimal(3.20).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 7);
		Assert.assertEquals(new BigDecimal(4.00).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 8);
		Assert.assertEquals(new BigDecimal(4.80).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

		watermelon = new Watermelon("Watermelon", 0.8f, 9);
		Assert.assertEquals(new BigDecimal(4.80).doubleValue(), watermelon.calculatePrice().doubleValue(), 0);

	}

}

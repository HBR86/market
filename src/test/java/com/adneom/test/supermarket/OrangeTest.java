package com.adneom.test.supermarket;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.adneom.test.supermarket.commons.Product;
import com.adneom.test.supermarket.products.Orange;

public class OrangeTest {
	
	@Test
	public void testCalculatePrice(){

		Product orange = new Orange("Orange", 0.5f,0);
		Assert.assertEquals(new BigDecimal(0.00).doubleValue(), orange.calculatePrice().doubleValue(),0);
		
		orange = new Orange("Orange", 0.5f,1);
		Assert.assertEquals(new BigDecimal(0.50).doubleValue(), orange.calculatePrice().doubleValue(),0);
		
		orange = new Orange("Orange", 0.5f,2);
		Assert.assertEquals(new BigDecimal(1.00).doubleValue(), orange.calculatePrice().doubleValue(),0);
		
		orange = new Orange("Orange", 0.5f,3);
		Assert.assertEquals(new BigDecimal(1.50).doubleValue(), orange.calculatePrice().doubleValue(),0);
		
		orange = new Orange("Orange", 0.5f,4);
		Assert.assertEquals(new BigDecimal(2.00).doubleValue(), orange.calculatePrice().doubleValue(),0);
	}

}

package com.adneom.test.supermarket;

import org.junit.Assert;
import org.junit.Test;

import com.adneom.test.supermarket.products.Apple;

public class ProductTest {

	@Test
	public void testConstructor() {
		Product apple = null;
		try {
			apple = new Apple(null, 0.2f, 4);
			Assert.fail("The test should fail here");
		} catch (IllegalArgumentException e) {
			// nothing to do here
		}
		apple = new Apple("Apple", 0.2f, 4);
		Assert.assertEquals("Apple", apple.getName());
		Assert.assertEquals(0.2f, apple.getUnitPrice(), 0);
		Assert.assertEquals(4, apple.getQuantity());
	}

}

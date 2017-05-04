package de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ShoppingBasketTest {

	@Test
	public void testThreeObjects() {
		// setup
		ShoppingBasket shoppingBasket = new ShoppingBasket();
		BigDecimal bd1 = new BigDecimal(3);
		BigDecimal bd2 = new BigDecimal(18);
		BigDecimal bd3 = new BigDecimal(1);
		BigDecimal totalPrice = new BigDecimal(36);
		OrderItem item1 = new OrderItem(1, 5, bd1);
		OrderItem item2 = new OrderItem(2, 1, bd2);
		OrderItem item3 = new OrderItem(3, 3, bd3);
		
		// execute
		try {
			shoppingBasket.addOrderItem(item1);
			shoppingBasket.addOrderItem(item2);
			shoppingBasket.addOrderItem(item3);
		} catch (DuplicateOrderItemException e) {
			e.printStackTrace();
		}
				
		// verify
		assertEquals(shoppingBasket.getTotalSalesPrice(), totalPrice);
	}

}

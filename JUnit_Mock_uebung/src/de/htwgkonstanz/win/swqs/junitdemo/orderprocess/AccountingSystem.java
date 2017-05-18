package de.htwgkonstanz.win.swqs.junitdemo.orderprocess;

import java.math.BigDecimal;

import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.OrderItem;

public interface AccountingSystem {

	public int getNextOrderNumber();
	
	public int saveOrder(int orderNumber, OrderItem items[], BigDecimal totalPrice);
}

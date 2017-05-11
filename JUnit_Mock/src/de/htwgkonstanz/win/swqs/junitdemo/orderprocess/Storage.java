package de.htwgkonstanz.win.swqs.junitdemo.orderprocess;

import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.OrderItem;

public interface Storage {
	public void saveOrderItems(int key, OrderItem[] items);
}

package de.htwgkonstanz.win.swqs.junitdemo.orderprocess;

import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.OrderItem;
import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.ShoppingBasket;

public class OrderProcess {
	public static int key = 0;
	
	private Storage storage;
	private Inventory inventory;
	private AccountingSystem accountingSystem;
	
	public OrderProcess(Inventory inventory, Storage storage, AccountingSystem accountingSystem) {
		this.inventory = inventory;
		this.storage = storage;
		this.accountingSystem = accountingSystem;
		
	}
	
	/**
	 * Stores Shopping Basket for later user and returns a key to retrieve the basket later.
	 */
	public synchronized int saveShoppingBasket(ShoppingBasket shoppingBasket) {
		int myKey = key++;
		storage.saveOrderItems(myKey, shoppingBasket.getOrderItems());
		return myKey;
	}
	
	/**
	 * Checks if the items in the shopping basket are still available in the inventory.
	 */
	public boolean checkAvailability(ShoppingBasket shoppingBasket) {
		for (OrderItem item : shoppingBasket.getOrderItems()) {
			int count = inventory.getInventoryCount(item.getItemId());
			if (count < item.getNumber()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Creates an order. From the account system a new order number is fetched. 
	 * Subsequently the the items in the inventory are assigned to this order and then the
	 * order items are saved in the accounting system.
	 */
	public void order(ShoppingBasket shoppingBasket) {
		int orderNumber = accountingSystem.getNextOrderNumber();
		
		for (OrderItem item : shoppingBasket.getOrderItems()) {
			inventory.assignToOrder(orderNumber, item.getItemId(), item.getNumber());
		}
		
		accountingSystem.saveOrder(orderNumber, shoppingBasket.getOrderItems());
	}
}

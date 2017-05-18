package de.htwgkonstanz.win.swqs.junitdemo.orderprocess;

public interface Inventory {
	public int getInventoryCount(int itemId);

	public boolean assignToOrder(int orderNumber, int itemId, int count);
}

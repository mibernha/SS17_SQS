package de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket;

public class DuplicateOrderItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateOrderItemException(OrderItem item) {
		super("Duplicate Order"+item.toString());
	}
	
}

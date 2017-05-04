package de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a shopping basket as it is used in eCommerce applications.
 * Each element in the shopping basket has a product id and a sales price for the product.
 * This information is stored in the class <code>OrderItem</code>.
 * Additionally a product can be ordered multiple times, therefore the <code>OrderItem</code> class 
 * contains an attribute number, which stores this information.
 * 
 * @author meiglspe
 */
public class ShoppingBasket {
	
	private List<OrderItem> items;
	private BigDecimal totalSalesPrice;
	
	public ShoppingBasket() {
		items = new ArrayList<OrderItem>();
		totalSalesPrice = new BigDecimal(0);
	}
	
	public BigDecimal getTotalSalesPrice() {
		return totalSalesPrice;
	}
	
	/**
	 * Returns the items in the shopping basket as array.
	 * 
	 * @return
	 */
	public OrderItem[] getOrderItems() {
		return items.toArray(new OrderItem[0]);
	}
	
	/**
	 * Removes one order item from the shopping basket.
	 * 
	 * @return
	 */
	public void removeOrder(OrderItem orderItem) {
		items.remove(orderItem);
		totalSalesPrice.subtract(orderItem.getSalesPrice().multiply(new BigDecimal(orderItem.getNumber())));
	}
	
	/**
	 * Adds an orderItem to the ShoppingBasket and updates the totalSalesPrice.
	 * 
	 * @param orderItem
	 * @throws DuplicateOrderItemException
	 */
	public void addOrderItem(OrderItem orderItem) throws DuplicateOrderItemException {
		if (items.contains(orderItem)) {
			throw new DuplicateOrderItemException(orderItem);
		}
		items.add(orderItem);
		totalSalesPrice = totalSalesPrice.add(orderItem.getSalesPrice().multiply(new BigDecimal(orderItem.getNumber())));
	}
	
	public OrderItem[] getOrderItemsWithPriceAboveLimit(BigDecimal limit) {
		ArrayList<OrderItem> result = new ArrayList<OrderItem>();
		for (OrderItem orderItem : items) {
			if (orderItem.getSalesPrice().compareTo(limit) > 0) {
					result.add(orderItem);
			}
		}
		return result.toArray(new OrderItem[0]);
	} 
}

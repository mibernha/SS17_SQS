package de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	
	public OrderItem[] getOrderItems() {
		return items.toArray(new OrderItem[0]);
	}
	
	public void removeOrder(OrderItem orderItem) {
		items.remove(orderItem);
		totalSalesPrice.subtract(orderItem.getSalesPrice().multiply(new BigDecimal(orderItem.getNumber())));
	}
	
	public void addOrderItem(OrderItem orderItem) throws DuplicateOrderItemException {
		if (items.contains(orderItem)) {
			throw new DuplicateOrderItemException(orderItem);
		}
		items.add(orderItem);
		totalSalesPrice.add(orderItem.getSalesPrice().multiply(new BigDecimal(orderItem.getNumber())));
	}
	
	public OrderItem[] getOrderItemsWithPriceAboveLimit(BigDecimal limit) {
		ArrayList<OrderItem> result = new ArrayList<OrderItem>();
		for (OrderItem orderItem : items) {
			if (orderItem.getSalesPrice().compareTo(limit) < 0) {
					result.add(orderItem);
			}
		}
		return result.toArray(new OrderItem[0]);
	} 
}

package de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket;

import java.math.BigDecimal;

/**
 * An item in a shopping basket with an id for the product, the quantity and the price at which it is sold.
 * 
 * @author meiglspe
 *
 */
public class OrderItem {
	 private int itemId;
	  private int number;
	  private BigDecimal salesPrice;

	  public OrderItem(int itemId, int number, BigDecimal salesPrice) {
	    super();
	    this.itemId = itemId;
	    this.number = number;
	    this.salesPrice = salesPrice;
	  }

	  public int getItemId() {
	    return itemId;
	  }

	  public int getNumber() {
	    return number;
	  }

	  public BigDecimal getSalesPrice() {
	    return salesPrice;
	  }   
	  
	  /**
	   * OrderItems are equals if they have the same productId.
	   */
	  public boolean equals(Object object) {
		  if (object == null)
			  return false;
		  if (!(object instanceof OrderItem)) {
				  return false;
		  } else {
			  OrderItem orderItem = (OrderItem)object;
			  return orderItem.itemId == this.itemId;
		  }
	  }
}

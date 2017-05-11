package de.htwgkonstanz.win.swqs.junitdemo.orderprocess;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.DuplicateOrderItemException;
import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.OrderItem;
import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.ShoppingBasket;

public class OrderProcessTest {
	
	@Mock
	Storage storageMock;
	
	@Mock
	Inventory inventoryMock;
	
	@Mock
	AccountingSystem accountingSystemMock;		
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void testCheckShoppingBasketSuccess() throws DuplicateOrderItemException {
		// setup
		when(inventoryMock.getInventoryCount(1)).thenReturn(2);
		OrderProcess orderProcess = new OrderProcess(inventoryMock,storageMock,accountingSystemMock);

		ShoppingBasket basket = new ShoppingBasket();
		OrderItem item = new OrderItem(1,1,new BigDecimal(100));
		basket.addOrderItem(item);		
		
		// execute
		boolean success = orderProcess.checkAvailability(basket);
		
		// verify
		assertTrue(success);		
	}
	
	/**
	 * Tests result of the method.
	 */
	@Test
	public void testCheckShoppingBasketFailure() throws DuplicateOrderItemException {
		// setup
		when(inventoryMock.getInventoryCount(1)).thenReturn(0);
		OrderProcess orderProcess = new OrderProcess(inventoryMock,storageMock,accountingSystemMock);

		ShoppingBasket basket = new ShoppingBasket();
		OrderItem item = new OrderItem(1,1,new BigDecimal(100));
		basket.addOrderItem(item);		
		
		// execute
		boolean success = orderProcess.checkAvailability(basket);
		
		// verify
		assertFalse(success);		
	}

	
	/**
	 * Tests interaction.
	 */
	@Test
	public void testCheckShoppingBasketBehaviour() throws DuplicateOrderItemException {
		// setup
		when(inventoryMock.getInventoryCount(1001)).thenReturn(5);
		when(inventoryMock.getInventoryCount(2500)).thenReturn(1);
		OrderProcess orderProcess = new OrderProcess(inventoryMock,storageMock,accountingSystemMock);

		ShoppingBasket basket = new ShoppingBasket();
		OrderItem item1 = new OrderItem(1001,3,new BigDecimal(100));
		OrderItem item2 = new OrderItem(2500,4,new BigDecimal(200));
		basket.addOrderItem(item1);		
		basket.addOrderItem(item2);		
		
		// execute
		boolean success = orderProcess.checkAvailability(basket);
		
		// verify
		assertFalse(success);		
		verify(inventoryMock).getInventoryCount(1001);
		verify(inventoryMock).getInventoryCount(2500);
	}
	
	
	@Test
	public void testStoreShoppingBasket() throws DuplicateOrderItemException {
		// setup
		OrderProcess orderProcess = new OrderProcess(inventoryMock,storageMock,accountingSystemMock);

		ShoppingBasket basket = new ShoppingBasket();
		OrderItem item = new OrderItem(1,1,new BigDecimal(100));
		basket.addOrderItem(item);		
		
		// execute
		int key = orderProcess.saveShoppingBasket(basket);
		
		// verify
		verify(storageMock).saveOrderItems(eq(key), eq(basket.getOrderItems()));
	}

	
}

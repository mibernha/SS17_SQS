package de.htwgkonstanz.win.swqs.junitdemo.orderprocess;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Test;

import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.DuplicateOrderItemException;
import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.OrderItem;
import de.htwgkonstanz.win.swqs.junitdemo.shoppingbasket.ShoppingBasket;

public class OrderProcessTestComplete {
	
	
	
	@Test
	public void testCheckShoppingBasketSuccess() throws DuplicateOrderItemException {
		// setup
		Storage storageMock = mock(Storage.class);
		Inventory inventoryMock = mock(Inventory.class);
		when(inventoryMock.getInventoryCount(1)).thenReturn(2);
		AccountingSystem accountingSystemMock = mock(AccountingSystem.class);		
		OrderProcess orderProcess = new OrderProcess(inventoryMock,storageMock,accountingSystemMock);

		ShoppingBasket basket = new ShoppingBasket();
		OrderItem item = new OrderItem(1,1,new BigDecimal(100));
		basket.addOrderItem(item);		
		
		// execute
		boolean success = orderProcess.checkAvailability(basket);
		
		// verify
		assertTrue(success);		
	}
	

	@Test
	public void testCheckShoppingBasketFailure() throws DuplicateOrderItemException {
		// setup
		Storage storageMock = mock(Storage.class);
		Inventory inventoryMock = mock(Inventory.class);
		when(inventoryMock.getInventoryCount(1)).thenReturn(0);
		AccountingSystem accountingSystemMock = mock(AccountingSystem.class);		
		OrderProcess orderProcess = new OrderProcess(inventoryMock,storageMock,accountingSystemMock);

		ShoppingBasket basket = new ShoppingBasket();
		OrderItem item = new OrderItem(1,1,new BigDecimal(100));
		basket.addOrderItem(item);		
		
		// execute
		boolean success = orderProcess.checkAvailability(basket);
		
		// verify
		assertFalse(success);		
	}

	
	@Test
	public void testStoreShoppingBasket() throws DuplicateOrderItemException {
		// setup
		Storage storageMock = mock(Storage.class);
		Inventory inventoryMock = mock(Inventory.class);
		AccountingSystem accountingSystemMock = mock(AccountingSystem.class);		
		OrderProcess orderProcess = new OrderProcess(inventoryMock,storageMock,accountingSystemMock);

		ShoppingBasket basket = new ShoppingBasket();
		OrderItem item = new OrderItem(1,1,new BigDecimal(100));
		basket.addOrderItem(item);		
		
		// execute
		int key = orderProcess.saveShoppingBasket(basket);
		
		// verify
		verify(storageMock).saveOrderItems(any(Integer.class), eq(basket.getOrderItems()));
	}

	
}

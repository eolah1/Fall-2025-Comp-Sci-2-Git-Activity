package edu.westga.cs1302.lab3.test.model.bill_item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab3.model.BillItem;

class TestConstructor {

	@Test
	public void testWhenNameIsNull() {
		String name = null;
		double amount = 12.0;
		
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem(name, amount);
		});
	}
	
	@Test
	public void testValidInputs() {
		String name = "Bread";
		double amount = 10.0;
		
		BillItem item = new BillItem(name, amount);
		
		assertEquals(name, item.getName(), "checking item name");
		assertEquals(amount, item.getAmount(), "checking amount value");
	}
	
	@Test
	public void testLowerBoundry() {
		String name = "Water";
		double amount = 0.0;
		
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem(name, amount);
		});
	}
	
	@Test
	public void testUpperBoundry() {
		String name = "Cheese";
		double amount = 1.0;
		
		BillItem item = new BillItem(name, amount);
		
		assertEquals(name, item.getName(), "checking item name");
		assertEquals(amount, item.getAmount(), "checking amount value");
	}
}
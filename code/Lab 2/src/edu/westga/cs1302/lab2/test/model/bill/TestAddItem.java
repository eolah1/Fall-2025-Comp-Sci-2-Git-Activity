package edu.westga.cs1302.lab2.test.model.bill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestAddItem {

	@Test
	public void testVailiditem() {
		Bill bill = new Bill();
		BillItem item = new BillItem("Pencil", 2.0);
		
		bill.addItem(item);
		
		assertTrue(bill.getItems().contains(item));
	}
	
	@Test
	public void testNullItem() {
		Bill bill = new Bill();
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			bill.addItem(null);
		});
		
		assertEquals("item must not be null.", exception.getMessage());
	}
}
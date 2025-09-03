package edu.westga.cs1302.lab2.tests.view.bill_view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;
import edu.westga.cs1302.lab2.view.BillView;

class TestGetText {

	@Test
	public void testEmptyBill() {
		Bill bill = new Bill();
		BillView view = new BillView();
		
		String expectation = "ITEMS" + System.lineSeparator()
			+ System.lineSeparator()
			+ "SUBTOTAL - $0.0" + System.lineSeparator()
			+ "TAX - $0.0" + System.lineSeparator()
			+ "TIP - $0.0" + System.lineSeparator()
			+ "TOTAL - $0.0";
		
		assertEquals(expectation, view.getText(bill));
	}
	
	@Test
	public void testWhenMultipleItems() {
		Bill bill = new Bill();
        bill.addItem(new BillItem("Burger", 5.00));
        bill.addItem(new BillItem("Fries", 2.00));
        
        BillView view = new BillView();
        
        double subtotal = 7.00;
        double tax = subtotal * Bill.TAX_RATE;
        double tip = subtotal * Bill.TIP_RATE;
        double total = subtotal + tax + tip;
        
        String expectation = "ITEMS" + System.lineSeparator()
        		+ "Burger - 5.0" + System.lineSeparator()
        		+ "Fries - 2.0" + System.lineSeparator()
        		+ System.lineSeparator()
        		+ "SUBTOTAL - $" + subtotal + System.lineSeparator()
        		+ "TAX - $" + tax + System.lineSeparator()
        		+ "TIP - $" + tip + System.lineSeparator()
        		+ "TOTAL - $" + total;
        
        assertEquals(expectation, view.getText(bill));
	}

}

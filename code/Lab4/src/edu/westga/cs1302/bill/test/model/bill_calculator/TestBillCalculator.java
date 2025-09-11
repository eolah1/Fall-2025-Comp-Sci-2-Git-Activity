package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculator;

import org.junit.jupiter.api.Test;

class TestBillCalculator {

	@Test
    public void testCalculateSubtotal() {
        BillItem[] items = {
            new BillItem("Burger", 8.0),
            new BillItem("Fries", 3.0),
            new BillItem("Drink", 2.0)
        };
        assertEquals(13.0, BillCalculator.calculateSubtotal(items));
    }

    @Test
    public void testCalculateSubtotalWithNullItems() {
        BillItem[] items = {
            new BillItem("Burger", 8.0),
            null,
            new BillItem("Drink", 2.0)
        };
        assertEquals(10.0, BillCalculator.calculateSubtotal(items));
    }

    @Test
    public void testCalculateTax() {
        BillItem[] items = {
            new BillItem("Sandwich", 10.0)
        };
        assertEquals(1.0, BillCalculator.calculateTax(items));
    }

    @Test
    public void testCalculateTip() {
        BillItem[] items = {
            new BillItem("Sandwich", 10.0)
        };
        assertEquals(2.0, BillCalculator.calculateTip(items));
    }

    @Test
    public void testCalculateTotal() {
        BillItem[] items = {
            new BillItem("Sandwich", 10.0)
        };
        assertEquals(13.0, BillCalculator.calculateTotal(items));
    }

}

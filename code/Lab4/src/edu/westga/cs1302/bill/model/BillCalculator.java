package edu.westga.cs1302.bill.model;

/**
 * Provides utility methods for calculating subtotal, tax, tips, and total
 * for a list of BillItem objects
 * 
 * @author Evan Olah
 * @version Fall 2025
 */
public class BillCalculator {
	
	/**
	 * Calculates the subtotal for the array of bill items
	 * 
	 * @param items the array of BillItem objects
	 * @return the subtotal
	 */
	public static double calculateSubtotal(BillItem[] items) {
		double subTotal = 0.0;
		
		for (BillItem currItem : items) {
			subTotal += currItem.getAmount();
		}
		return subTotal;
	}
	
	/**
	 * Calculates the tax based on the subtotal of the
	 *  bill items. 
	 * 
	 * @param items the array of BillItem objects
	 * @return the tax amount
	 */
	public static double calculateTax(BillItem[] items) {
		return calculateSubtotal(items) * Bill.TAX_RATE;
	}
	
	/**
	 * Calculates the tip based on the subtotal of the bill items
	 * 
	 * @param items the array of BillItem objects
	 * @return the tip amount 
	 */
	public static double calculateTip(BillItem[] items) {
		return calculateSubtotal(items) * Bill.TIP_RATE;
	}
	
	/**
	 * Calculates the costs, including subtotal, tax, and trip. 
	 * 
	 * @param items the array of BillItem objects
	 * @return the total
	 */
	public static double calculateTotal(BillItem[] items) {
		double subtotal = calculateSubtotal(items);
		return subtotal + calculateTax(items) + calculateTip(items);
	}
	
}

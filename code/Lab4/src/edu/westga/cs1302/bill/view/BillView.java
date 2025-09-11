package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillCalculator;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill the bill to be viewed
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public static String getText(Bill bill) {
		String text = "ITEMS" + System.lineSeparator();

		BillItem[] aItems = new BillItem[bill.getItems().size()];
		bill.getItems().toArray(aItems);
		
		for (BillItem item : aItems) {
			text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
		}
		
		text += System.lineSeparator();
		double subTotal = BillCalculator.calculateSubtotal(aItems);
		double tax = BillCalculator.calculateTax(aItems);
		double tip = BillCalculator.calculateTip(aItems);
		double total = BillCalculator.calculateTotal(aItems);
		
		text += "SUBTOTAL - $" + roundToNearestHundredth(subTotal) + System.lineSeparator();
		text += "TAX - $" + roundToNearestHundredth(tax) + System.lineSeparator();
		text += "TIP - $" + roundToNearestHundredth(tip) + System.lineSeparator();
		text += "TOTAL - $" + roundToNearestHundredth(total);
		
		return text;
	}
	
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
}

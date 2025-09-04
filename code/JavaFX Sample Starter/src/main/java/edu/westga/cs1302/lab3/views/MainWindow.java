package edu.westga.cs1302.lab3.views;

import edu.westga.cs1302.lab3.model.BillItem;
import edu.westga.cs1302.lab3.model.Bill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

	@FXML
	private TextField amountBox;

	@FXML
	private TextField nameBox;

	@FXML
	private TextArea output;

	private Bill bill = new Bill();

	/**
	 * Handles the action of adding an item to the bill. This method retrieves the
	 * item name and amount from the input fields, creates a new BillItem, adds it
	 * to the bill, and updates the output display.
	 * 
	 * @param event The action event that triggered this method (e.g., button
	 *              click).
	 */
	@FXML
	public void addItem(ActionEvent event) {
		String nameValue = this.nameBox.getText();
		double amountValue = Double.parseDouble(this.amountBox.getText());

		BillItem item = new BillItem(nameValue, amountValue);

		this.bill.addItem(item);

		BillView billView = new BillView();
		String billText = billView.getText(this.bill);
		this.output.setText(billText);
	}

	/**
	 * Perform any needed initialization of UI components and underlying objects.
	 */
	public void initialize() {

	}
}

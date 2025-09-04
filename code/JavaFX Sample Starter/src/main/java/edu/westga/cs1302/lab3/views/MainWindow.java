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

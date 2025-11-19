package edu.westga.cs1302.password_generator.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

	@FXML private MenuItem aboutFileMenu;
    @FXML private MenuItem closeFileMenu;
    @FXML private MenuItem saveFileMenu;
    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private Label errorTextLabel;
    @FXML private Label minLengthErrorText;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> passwordHistory;
    
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.passwordHistory.setItems(this.vm.getPasswordHistory());
    	
    	this.minimumLength.textProperty().addListener((observable, newValue, oldValue) -> {
    		this.minLengthErrorText.setVisible(!newValue.matches("\\d+") || Integer.parseInt(newValue) == 0);
    	});
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    	
    	this.saveFileMenu.setOnAction(
    		(event) -> {
    			this.handleSave();
    		}
    	);
    	
    	this.aboutFileMenu.setOnAction(
        		(event) -> {
        			this.handleAbout();
        		}
        	);
    	
    	this.closeFileMenu.setOnAction(
        		(event) -> {
        			this.handleClose();
        		}
        	);
    }

	private void handleClose() {
		((Node) (this.errorTextLabel)).getScene().getWindow().hide();
		
	}

	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Password Generator Project Purpose");
		alert.setContentText("This project generates random passwords based on user inputs. Author: Evan Olah");
		alert.showAndWait();
	}

	private void handleSave() {
		FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Save Passwords");
	    fileChooser.getExtensionFilters().addAll(
	        new FileChooser.ExtensionFilter("Text Files", "*.txt"),
	        new FileChooser.ExtensionFilter("All Files", "*.*")
	    );

	    File file = fileChooser.showSaveDialog(this.errorTextLabel.getScene().getWindow());

	    if (file != null) {
	        try (PrintWriter writer = new PrintWriter(file)) {
	            for (String password : this.vm.getPasswordHistory()) {
	                writer.println(password);
	            }
	        } catch (IOException error) {
	            this.vm.getErrorText().set("Error saving file: " + error.getMessage());
	        }
	    }
		
	}
}

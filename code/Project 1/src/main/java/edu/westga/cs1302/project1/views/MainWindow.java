package edu.westga.cs1302.project1.views;

import edu.westga.cs1302.project1.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */

public class MainWindow {
	
	@FXML
    private Button addToList;

    @FXML
    private TextArea taskDescription;

    @FXML
    private ListView<Task> taskList;

    @FXML
    private TextField taskName;

    @FXML
    private ComboBox<String> taskPriority;
    
    /**
     * Initializes the ComboBox with priority options.
     */
    public void initialize() {
    	this.taskPriority.getItems().addAll("High", "Medium", "Low");
    }
    
    /**
     * Displays an error alert with the specified message.
     * 
     * @param message the error message to display
     */
    private void displayErrorBox(String message) {
    	Alert alert = new Alert(Alert.AlertType.ERROR);
    	alert.setContentText(message);
    	alert.showAndWait();
    	return;
    }

    /**
     * Handles the event triggered by clicking the "Add Task" button.
     * Validates input fields, creates a new Task object, and adds it to the ListView.
     * 
     * @param event the ActionEvent triggered by the button click
     */
    @FXML
    void addTask(ActionEvent event) {
    	
    	try {
	    	String name = this.taskName.getText();
	        String description = this.taskDescription.getText();
	        String priority = this.taskPriority.getValue();
	        
	        if (name == null || name.isEmpty()) {
	        	this.displayErrorBox("Task name cannot be empty");
	        	return;
	        }
	        
	        if (description == null || description.isEmpty()) {
	        	this.displayErrorBox("Task description cannot be empty");
	        	return;
	        }
	        
	        if (priority == null || priority.isEmpty()) {
	        	this.displayErrorBox("Task priority must be selected");
	        	return;
	        }
	        
	        Task tasksView = new Task(name, description, priority);
	        this.taskList.getItems().add(tasksView);
	        
	    } catch (Exception error) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setHeaderText("Unexpected Error");
	        alert.setContentText(error.getMessage());
	        alert.showAndWait();
	    }
    }

    /**
     * Handles the event triggered when a task in the ListView is clicked.
     * Displays the selected task's details in an information alert.
     * 
     * @param event the MouseEvent triggered by clicking a task
     */
    @FXML
    void showSelectedTask(javafx.scene.input.MouseEvent event) {
        Task selectedTask = this.taskList.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Selected Task");
            alert.setContentText("Name: " + selectedTask.getName() + "\n"
                    + "Description: " + selectedTask.getDescription() + "\n"
                    + "Priority: " + selectedTask.getPriority());
            alert.showAndWait();
        } 
    }
}

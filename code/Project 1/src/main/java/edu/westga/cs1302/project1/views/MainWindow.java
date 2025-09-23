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
    
    public void initialize() {
    	this.taskPriority.getItems().add("High");
    	this.taskPriority.getItems().add("Medium");
    	this.taskPriority.getItems().add("Low");
    }

    @FXML
    void addTask(ActionEvent event) {
    	
    	try {
	    	String name = this.taskName.getText();
	        String description = this.taskDescription.getText();
	        String priority = this.taskPriority.getValue();
	        
	        if (name == null || name.isEmpty()) {
	        	Alert alert = new Alert(Alert.AlertType.ERROR);
	        	alert.setContentText("Task name cannot be empty");
	        	alert.showAndWait();
	        	return;
	        }
	        
	        if (description == null || description.isEmpty()) {
	        	Alert alert = new Alert(Alert.AlertType.ERROR);
	        	alert.setContentText("Task description cannot be empty");
	        	alert.showAndWait();
	        	return;
	        }
	        
	        if (priority == null || priority.isEmpty()) {
	        	Alert alert = new Alert(Alert.AlertType.ERROR);
	        	alert.setContentText("Piority must be selected");
	        	alert.showAndWait();
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

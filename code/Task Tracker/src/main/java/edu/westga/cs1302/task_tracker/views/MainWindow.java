package edu.westga.cs1302.task_tracker.views;

import java.util.Comparator;

import edu.westga.cs1302.task_tracker.model.Ascending;
import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.NameAscending;
import edu.westga.cs1302.task_tracker.model.NameDescending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.TaskUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/** Controller class for MainWindow of the Task Tracker system.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    @FXML private TextArea description;
    @FXML private Label highCount;
    @FXML private Label lowCount;
    @FXML private Label mediumCount;
    @FXML private TextField name;
    @FXML private ComboBox<TaskPriority> priority;
    @FXML private TextArea selectedDescription;
    @FXML private TextField selectedPriority;
    @FXML private ListView<Task> tasks;
    @FXML private ComboBox<Comparator<Task>> order;
    @FXML private Button addSubTasks;
    @FXML private ListView<Task> subTasks;

    /** Add a new task with the provided information to the listview.
     * 
     * @precondition none
     * @postcondition A task will be added to the listview with 
     * 							  1) a name matching the text of the name textfield, 
     * 							  2) a description matching the text of the description textarea,
     * 							  3) a priority matching the selected value of the priority combobox,
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML 
    void addTask(ActionEvent event) {
    	try {
    		Task newTask = new Task(this.name.getText(), 
    				this.description.getText(), this.priority.getValue());
    		this.tasks.getItems().add(newTask);
    		
    		Comparator<Task> comparator = this.order.getValue();
    		if (comparator != null) {
    			this.tasks.getItems().sort(comparator);
    		}
    		
    	} catch (IllegalArgumentException error) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(error.getMessage());
    		alert.showAndWait();
    	}
    }
    
    /** Add a new subtask to the currently selected task.
     * 
     * @precondition a task must be selected in the listview &&
     *               the name, description, and priority fields must contain valid values
     * @postcondition the selected task in the listview will be replaced with a new task 
     *                that includes the subtask && the subtask listview will
     *                be updated to display the subtasks of the updated task
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void addSubTask(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Please select a task to add a subtask to.");
            alert.showAndWait();
            return;
        }

        try {
            Task subTask = new Task(this.name.getText(), this.description.getText(), this.priority.getValue());
            Task updatedTask = selectedTask.addTask(subTask);

            int index = this.tasks.getItems().indexOf(selectedTask);
            this.tasks.getItems().set(index, updatedTask);

            this.displaySubTasks(updatedTask);

        } catch (IllegalArgumentException error) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText(error.getMessage());
            alert.showAndWait();
        }
    }

    /** Display the priority and description of the task selected in the listview.
     * 
     * @precondition none
     * @postcondition the description for the selected task will be displayed in the selectedDescription text area &&
     * 				  the priority for the selected task will be displayed in the selectedPriority text field
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void selectTask(MouseEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		this.selectedPriority.setText(selectedTask.getPriority().toString());
    		this.selectedDescription.setText(selectedTask.getDescription());
    		this.displaySubTasks(selectedTask);
    	}
    }

    /** Remove the currently selected task.
     * 
     * @precondition none
     * @postcondition task selected in the listview will be removed
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void removeTask(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		this.tasks.getItems().remove(selectedTask);
    	}
    }

    /** Update the description of the selected task.
     * 
     * @precondition none
     * @postcondition description for the task selected in the listview will be updated to match the text in the selectedDescription text area.
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void updateDescription(ActionEvent event) {
    	Task selectedTask = this.tasks.getSelectionModel().getSelectedItem();
    	if (selectedTask != null) {
    		selectedTask.setDescription(this.selectedDescription.getText());
    	}
    }

    /** Display the count of tasks for each priority.
     * 
     * @precondition none
     * @postcondition count of tasks for each priority are displayed in the appropriate labels.
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void countPriorities(ActionEvent event) {
    	this.highCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.HIGH, this.tasks.getItems())));
    	this.mediumCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.MEDIUM, this.tasks.getItems())));
    	this.lowCount.setText(Integer.toString(TaskUtility.countOfPriority(TaskPriority.LOW, this.tasks.getItems())));
    }
    
    /** Sort tasks based on the selected ordering.
     * 
     * @precondition none
     * @postcondition tasks in the listview are sorted based on the provided ordering.
     * 
     * @param event we will not use this parameter, only here due to JavaFX Library requirement
     */
    @FXML
    void sortTasks(ActionEvent event) {
    	if (this.order.getValue() != null) {
    		this.tasks.getItems().sort(this.order.getValue());
    	}
    }
    
    /** Display the list of subtasks for the provided task.
     * 
     * @precondition task != null
     * @postcondition the subtask listview will display all subtasks of the provided task,
     *                or be cleared if the task has no subtasks
     * 
     * @param task the task whose subtasks will be displayed
     */
    private void displaySubTasks(Task task) {
        if (task.getSubTasks().isEmpty()) {
            this.subTasks.getItems().clear();
        } else {
            this.subTasks.getItems().setAll(task.getSubTasks());
        }
    }
    
    /**
     * Displays the details of the selected subtask in the name, description,
     * and priority fields.
     * 
     * @precondition  none
     * @postcondition The text fields and combo box show the selected subtask’s
     *                name, description, and priority. If no subtask is selected,
     *                fields are cleared.
     * 
     * @param event   the event triggered by selecting a subtask
     */
    @FXML
    void displaySelectedSubTask(MouseEvent event) {
        Task selectedSubTask = this.subTasks.getSelectionModel().getSelectedItem();
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("SubTask Information");
        alert.setHeaderText(selectedSubTask.getName());
        alert.setContentText("Priority: " + selectedSubTask.getPriority() 
        	+ "\n\n" + "Description: " + selectedSubTask.getDescription()
        ); 
        alert.showAndWait();
    }

    /** Perform any needed initialization of UI components and underlying objects.
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    @FXML
    public void initialize() {
    	this.priority.getItems().addAll(TaskPriority.HIGH, TaskPriority.MEDIUM, TaskPriority.LOW);
    	this.priority.setValue(this.priority.getItems().get(0));
    	this.order.getItems().add(new Ascending());
    	this.order.getItems().add(new Descending());
    	this.order.getItems().add(new NameAscending());
    	this.order.getItems().add(new NameDescending());
    	this.priority.setValue(this.priority.getItems().get(0));
    }
    
}

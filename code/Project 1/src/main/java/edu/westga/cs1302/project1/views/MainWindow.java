package edu.westga.cs1302.project1.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */

public class MainWindow {
	
	@FXML
    private TextArea taskDescription;

    @FXML
    private ListView<?> taskList;

    @FXML
    private TextField taskName;

    @FXML
    private ComboBox<?> taskPriority;

    @FXML
    void addTitle(ActionEvent event) {

    }

    @FXML
    void popUpFavorite(ActionEvent event) {

    }
}

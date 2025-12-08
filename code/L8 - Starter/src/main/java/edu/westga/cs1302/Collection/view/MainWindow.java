package edu.westga.cs1302.Collection.view;

import edu.westga.cs1302.Collection.model.Collection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

	@FXML
    private Button addCollection;

    @FXML
    private TextField collectionName;

    @FXML
    private ListView<Collection> displayCollections;
    
    private ObservableList<String> collections;

    @FXML
    private Button removeCollection;

    @FXML
    void handleAddCollection(ActionEvent event) {
    	String name = collectionName.getText();
    	if (!name.isEmpty()) {
    		Collection item = new Collection(name);
    		if (!collections.contains(item)) {
    			collections.add(item);
    		}
    	}
    }

    @FXML
    void handleRemoveCollection(ActionEvent event) {
    	Collection selectedCollection = displayCollections.getSelectionModel().getSelectedItem();
    	if (selectedCollection != null) {
    		collections.remove(selectedCollection);
    	}
    }

    @FXML
    void removeFromContext(ActionEvent event) {

    }
}

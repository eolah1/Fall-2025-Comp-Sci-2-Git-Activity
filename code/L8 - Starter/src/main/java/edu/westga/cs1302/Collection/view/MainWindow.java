package edu.westga.cs1302.Collection.view;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.viewmodel.ViewModel;
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
public class MainWindow{

	@FXML
    private Button addCollection;
    @FXML
    private Button addComic;
    @FXML
    private TextField collectionName;
    @FXML
    private ListView<?> displayCollections;
    @FXML
    private Button removeCollection;
    @FXML
    private Button removeComic;

    private ViewModel vm;
    
    @FXML
    public void initialize() {
    	this.vm = new ViewModel();
        this.collectionName.textProperty().bindBidirectional(this.vm.getName());
        this.displayCollections.itemsProperty().bind(this.vm.getDisplayCollections());
        this.vm.getSelectedCollections().bind(this.displayCollections.getSelectionModel().selectedItemProperty());
        this.addCollection.disableProperty().bind(
        		this.vm.getName().isEmpty()
        );
    }
    
    @FXML
    void handleAddCollection(ActionEvent event) {
        this.vm.addCollection();
    }

    @FXML
    void handleRemoveCollection(ActionEvent event) {
        this.vm.removeCollection();
    }

    @FXML
    void removeFromContext(ActionEvent event) {
        this.vm.removeCollection();
    }
    
    @FXML
    void handleRemoveComic(ActionEvent event) {

    }

    @FXML
    void handleAddComic(ActionEvent event) {

    }
    
    @FXML
    void removeComicFromContext(ActionEvent event) {

    }
}

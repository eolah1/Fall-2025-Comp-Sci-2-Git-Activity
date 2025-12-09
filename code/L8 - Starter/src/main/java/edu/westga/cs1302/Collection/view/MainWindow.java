package edu.westga.cs1302.Collection.view;

import java.io.IOException;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import edu.westga.cs1302.Collection.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class MainWindow {

    @FXML
    private Button addCollection;
    @FXML
    private Button addComic;
    @FXML
    private TextField collectionName;
    @FXML
    private ListView<Collection> displayCollections;
    @FXML
    private Button removeCollection;
    @FXML
    private Button removeComic;
    @FXML
    private ListView<Comic> displayComics;

    public MainWindowViewModel vm;

    @FXML
    public void initialize() {
        this.vm = new MainWindowViewModel();

        this.collectionName.textProperty().bindBidirectional(this.vm.getName());
        this.displayCollections.itemsProperty().bind(this.vm.getDisplayCollections());
        this.vm.getSelectedCollections().bind(this.displayCollections.getSelectionModel().selectedItemProperty());

        this.displayComics.itemsProperty().bind(this.vm.getDisplayComics());
        this.vm.getSelectedComic().bind(this.displayComics.getSelectionModel().selectedItemProperty());

        this.addCollection.disableProperty().bind(this.vm.getName().isEmpty());
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
        this.vm.removeComic();
    }

    @FXML
    void handleAddComic(ActionEvent event) throws IOException {
    	if (this.vm.getSelectedCollections().get() == null) {
            return;
        }

    	FXMLLoader loader = new FXMLLoader(
    		    getClass().getResource("/edu/westga/cs1302/Collection/view/ComicWindow.fxml")
    		);
        Parent root = loader.load();

        ComicWindow controller = loader.getController();
        controller.setViewModel(this.vm);

        Stage stage = new Stage();
        stage.setTitle("Add Comic");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();
    	
    }

    @FXML
    void removeComicFromContext(ActionEvent event) {
        this.vm.removeComic();
    }
}
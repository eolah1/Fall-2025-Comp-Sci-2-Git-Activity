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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

/**
 * Main window controller for managing comic collections and comics.
 */
public class MainWindow {

    @FXML
    private Button addCollection;
    @FXML
    private Button addComic;
    @FXML
    private TextField collectionName;
    @FXML
    private TextField titleField;
    @FXML
    private TextField issueField;
    @FXML
    private ListView<Collection> displayCollections;
    @FXML
    private Button removeCollection;
    @FXML
    private Button removeComic;
    @FXML
    private Button findComic;
    @FXML
    private ListView<Comic> displayComics;

    public MainWindowViewModel vm;

    /**
     * Initializes bindings between the view and the ViewModel.
     */
    @FXML
    public void initialize() {
        this.vm = new MainWindowViewModel();

        this.collectionName.textProperty().bindBidirectional(this.vm.getName());
        this.displayCollections.itemsProperty().bind(this.vm.getDisplayCollections());
        this.vm.getSelectedCollections().bind(this.displayCollections.getSelectionModel().selectedItemProperty());

        this.displayComics.itemsProperty().bind(this.vm.getDisplayComics());
        this.vm.getSelectedComic().bind(this.displayComics.getSelectionModel().selectedItemProperty());

        this.addCollection.disableProperty().bind(this.vm.getName().isEmpty());
        
        this.titleField.textProperty().bindBidirectional(this.vm.getComicName());
        this.issueField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                this.vm.getIssueNum().set(Integer.parseInt(newVal));
            } catch (NumberFormatException error) {
                this.vm.getIssueNum().set(0);
            }
        });
        this.findComic.disableProperty().bind(
                this.vm.getComicName().isEmpty()
                    .or(this.vm.getIssueNum().isEqualTo(0))
            );
    }

    /**
     * Handles adding a new collection.
     * @param event the action event
     */
    @FXML
    void handleAddCollection(ActionEvent event) {
        this.vm.addCollection();
    }

    /**
     * Handles removing the selected collection.
     * @param event the action event
     */
    @FXML
    void handleRemoveCollection(ActionEvent event) {
        this.vm.removeCollection();
    }

    /**
     * Removes a collection from context menu.
     * @param event the action event
     */
    @FXML
    void removeFromContext(ActionEvent event) {
        this.vm.removeCollection();
    }

    /**
     * Handles removing the selected comic.
     * @param event the action event
     */
    @FXML
    void handleRemoveComic(ActionEvent event) {
        this.vm.removeComic();
    }

    /**
     * Opens the comic window to add a new comic.
     * @param event the action event
     * @throws IOException if the FXML cannot be loaded
     */
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

    /**
     * Removes a comic from context menu.
     * @param event the action event
     */
    @FXML
    void removeComicFromContext(ActionEvent event) {
        this.vm.removeComic();
    }
    
    /**
     * Handles searching for a comic by title and issue number.
     * @param event the action event
     */
    @FXML
    void handleFindComic(ActionEvent event) {
        String title = this.titleField.getText().trim();
        String issueText = this.issueField.getText().trim();

        int issue;
        try {
            issue = Integer.parseInt(issueText);
            if (issue < 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Issue number must be positive");
                alert.setContentText("Please enter a valid issue number.");
                alert.showAndWait();
                return;
            }
        } catch (NumberFormatException error) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Issue number must be numeric");
            alert.setContentText("You entered: " + issueText);
            alert.showAndWait();
            return;
        }

        Comic foundComic = this.vm.searchComic(title, issue);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (foundComic != null) {
            alert.setTitle("Comic Found");
            alert.setHeaderText("Search Result");
            alert.setContentText(foundComic.toString());
        } else {
            alert.setTitle("Comic Not Found");
            alert.setHeaderText("Search Result");
            alert.setContentText("No comic with title '" + title + "' and issue #" + issue + " was found.");
        }
        alert.showAndWait();
    }
}
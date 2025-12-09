package edu.westga.cs1302.Collection.view;

import edu.westga.cs1302.Collection.viewmodel.MainWindowViewModel;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Comic window controller for adding a comic to a collection.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ComicWindow {

    @FXML
    private Button confirmAdd;
    @FXML
    private Button cancelAdd;
    @FXML
    private TextField comicName;
    @FXML
    private TextField issueNumber;

    private MainWindowViewModel vm;

    /**
     * Sets the ViewModel and binds UI fields to its properties.
     * @param vm the MainWindowViewModel to bind
     */
    public void setViewModel(MainWindowViewModel vm) {
        this.vm = vm;

        this.comicName.textProperty().bindBidirectional(this.vm.getComicName());

        this.issueNumber.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if (newVal == null || newVal.isBlank()) {
                    this.vm.getIssueNum().set(0);
                    return;
                }
                int val = Integer.parseInt(newVal);
                this.vm.getIssueNum().set(val);
            } catch (NumberFormatException error) {
                this.vm.getIssueNum().set(0);
            }
        });

        BooleanBinding invalidIssueNum = this.vm.getIssueNum().isEqualTo(0);
        this.confirmAdd.disableProperty().bind(
            this.vm.getComicName().isEmpty().or(invalidIssueNum)
        );
    }

    /**
     * Handles confirming the comic addition and closes the window.
     * @param event the action event
     */
    @FXML
    void handleConfirm(ActionEvent event) {
        this.vm.addComic();
        ((Stage) this.confirmAdd.getScene().getWindow()).close();
    }

    /**
     * Handles canceling the comic addition and closes the window.
     * @param event the action event
     */
    @FXML
    void handleCancel(ActionEvent event) {
        ((Stage) this.cancelAdd.getScene().getWindow()).close();
    }
}
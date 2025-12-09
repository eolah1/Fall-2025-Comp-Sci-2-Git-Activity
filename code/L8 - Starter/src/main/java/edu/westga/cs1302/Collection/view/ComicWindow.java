package edu.westga.cs1302.Collection.view;

import edu.westga.cs1302.Collection.viewmodel.MainWindowViewModel;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void setViewModel(MainWindowViewModel vm) {
        this.vm = vm;

        this.comicName.textProperty().bindBidirectional(this.vm.getComicName());

        this.issueNumber.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                int val = (newVal == null || newVal.isBlank()) ? 0 : Integer.parseInt(newVal);
                this.vm.getIssueNum().set(val);
            } catch (NumberFormatException error) {
                this.vm.getIssueNum().set(0);
            }
        });

        BooleanBinding invalidIssue = this.vm.getIssueNum().isEqualTo(0);
        this.confirmAdd.disableProperty().bind(
            this.vm.getComicName().isEmpty().or(invalidIssue)
        );
    }

    @FXML
    void handleConfirm(ActionEvent event) {
        this.vm.addComic();
        ((Stage) this.confirmAdd.getScene().getWindow()).close();
    }

    @FXML
    void handleCancel(ActionEvent event) {
        ((Stage) this.cancelAdd.getScene().getWindow()).close();
    }
}
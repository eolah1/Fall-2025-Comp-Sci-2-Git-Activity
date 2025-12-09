package edu.westga.cs1302.Collection.viewmodel;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import edu.westga.cs1302.Collection.view.ComicWindow;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ComicWindowViewModel {

    private StringProperty comicName;
    private IntegerProperty issueNum;
    private ListProperty<Comic> comics;
    private ObjectProperty<Comic> selectedComic;
    private ObjectProperty<Collection> selectedCollection;

    public ComicWindowViewModel() {
        this.comicName = new SimpleStringProperty("");
        this.issueNum = new SimpleIntegerProperty();
        this.comics = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.selectedComic = new SimpleObjectProperty<>();
        this.selectedCollection = new SimpleObjectProperty<>();

        this.selectedCollection.addListener((obs, oldColl, newColl) -> {
            if (newColl != null) {
                this.comics.set(newColl.getComics());
            } else {
                this.comics.set(FXCollections.observableArrayList());
            }
        });
    }

    public StringProperty getComicName() {
        return this.comicName;
    }

    public IntegerProperty getIssueNum() {
        return this.issueNum;
    }

    public ListProperty<Comic> getComics() {
        return this.comics;
    }

    public ObjectProperty<Comic> getSelectedComic() {
        return this.selectedComic;
    }

    public ObjectProperty<Collection> getSelectedCollection() {
        return this.selectedCollection;
    }
}
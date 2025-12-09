package edu.westga.cs1302.Collection.viewmodel;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * ViewModel for the ComicWindow, managing comic input and selection.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ComicWindowViewModel {

    private StringProperty comicName;
    private IntegerProperty issueNum;
    private ListProperty<Comic> comics;
    private ObjectProperty<Comic> selectedComic;
    private ObjectProperty<Collection> selectedCollection;

    /**
     * Creates a new ComicWindowViewModel with default values.
     */
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

    /**
     * Gets the comic name property.
     * 
     * @return the comic name property
     */
    public StringProperty getComicName() {
        return this.comicName;
    }

    /**
     * Gets the issue number property.
     * 
     * @return the issue number property
     */
    public IntegerProperty getIssueNum() {
        return this.issueNum;
    }

    /**
     * Gets the comics list property.
     * 
     * @return the comics list property
     */
    public ListProperty<Comic> getComics() {
        return this.comics;
    }

    /**
     * Gets the selected comic property.
     * 
     * @return the selected comic property
     */
    public ObjectProperty<Comic> getSelectedComic() {
        return this.selectedComic;
    }

    /**
     * Gets the selected collection property.
     * 
     * @return the selected collection property
     */
    public ObjectProperty<Collection> getSelectedCollection() {
        return this.selectedCollection;
    }
}
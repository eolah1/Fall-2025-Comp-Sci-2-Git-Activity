package edu.westga.cs1302.Collection.viewmodel;

import edu.westga.cs1302.Collection.model.Collection;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * Provides properties and methods to manage collections
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ViewModel {

    private StringProperty name;
    private ListProperty<Collection> displayCollections;
    private ObjectProperty<Collection> selectedCollection;
    
    /**
     * Creates a new ViewModel with empty values.
     */
    public ViewModel() {
        this.name = new SimpleStringProperty("");
        this.displayCollections = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.selectedCollection = new SimpleObjectProperty<>();
    }
    
    /**
     * Gets the property for the collection name.
     * 
     * @return the name property
     */
    public StringProperty getName() {
        return this.name;
    }

    /**
     * Gets the property for the list of collections.
     * 
     * @return the displayCollections property
     */
    public ListProperty<Collection> getDisplayCollections() {
        return this.displayCollections;
    }

    /**
     * Gets the property for the selected collection.
     * 
     * @return the selectedCollection property
     */
    public ObjectProperty<Collection> getSelectedCollections() {
        return this.selectedCollection;
    }

    /**
     * Adds a new collection if the name is valid
     * and not already in the list.
     */
    public void addCollection() {
        String newName = this.name.get();
        if (newName != null && !newName.isEmpty()) {
            Collection item = new Collection(newName);
            if (!this.displayCollections.contains(item)) {
                this.displayCollections.add(item);
                this.name.set("");
            }
        }
    }

    /**
     * Removes the currently selected collection
     * from the list if one is selected.
     */
    public void removeCollection() {
        Collection selected = selectedCollection.get();
        if (selected != null) {
            displayCollections.remove(selected);
        }
    }
}
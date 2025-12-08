package edu.westga.cs1302.Collection.viewmodel;

import edu.westga.cs1302.Collection.model.Collection;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ViewModel {

	private StringProperty name;
	private ListProperty<Collection> displayCollections;
	private ObjectProperty<Collection> selectedCollection;
	
	public ViewModel() {
		this.name = new SimpleStringProperty("");
		this.displayCollections = new SimpleListProperty<Collection>(FXCollections.observableArrayList());
		this.selectedCollection = new SimpleObjectProperty<>();
	}
	
	public StringProperty getName() {
		return name;
	}

	public ListProperty<Collection> getDisplayCollections() {
		return displayCollections;
	}

	public ObjectProperty<Collection> getSelectedCollections() {
		return selectedCollection;
	}

	public void addCollection() {
		String newName = name.get();
    	if (!newName.isEmpty() && newName != null) {
    		Collection item = new Collection(newName);
    		if (!displayCollections.contains(item)) {
    			displayCollections.add(item);
    			name.set("");
    		}
    	}
	}

	public void removeCollection() {
		Collection selected = selectedCollection.get();
    	if (selected != null) {
    		displayCollections.remove(selected);
    	}
	}

}

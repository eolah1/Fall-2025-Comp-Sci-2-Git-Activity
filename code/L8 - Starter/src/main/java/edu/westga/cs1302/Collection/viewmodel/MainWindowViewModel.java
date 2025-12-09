package edu.westga.cs1302.Collection.viewmodel;

import java.util.HashMap;
import java.util.Map;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * ViewModel for the main window, managing collections and comics.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindowViewModel {

    private StringProperty name;
    private ListProperty<Collection> displayCollections;
    private ObjectProperty<Collection> selectedCollection;
    private ListProperty<Comic> displayComics;
    private ObjectProperty<Comic> selectedComic;
    private StringProperty comicName;
    private ObjectProperty<Integer> issueNum;
    private Map<String, Comic> comicMap = new HashMap<>();

    /**
     * Creates a new MainWindowViewModel with default values.
     */
    public MainWindowViewModel() {
        this.name = new SimpleStringProperty("");
        this.displayCollections = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.selectedCollection = new SimpleObjectProperty<>();
        this.displayComics = new SimpleListProperty<>(FXCollections.observableArrayList());
        this.selectedComic = new SimpleObjectProperty<>();
        this.comicName = new SimpleStringProperty("");
        this.issueNum = new SimpleObjectProperty<>(0);
        
        this.selectedCollection.addListener((obs, oldCollection, newCollection) -> {
            if (newCollection != null) {
                this.displayComics.set(newCollection.getComics());
            } else {
                this.displayComics.set(FXCollections.observableArrayList());
            }
        });
    }

    /**
     * Gets the collection name property.
     * 
     * @return the name property
     */
    public StringProperty getName() { 
        return this.name; 
    }
    
    /**
     * Gets the list of collections to display.
     * 
     * @return the collections list property
     */
    public ListProperty<Collection> getDisplayCollections() { 
        return this.displayCollections; 
    }
    
    /**
     * Gets the selected collection property.
     * 
     * @return the selected collection property
     */
    public ObjectProperty<Collection> getSelectedCollections() { 
        return this.selectedCollection; 
    }
    
    /**
     * Gets the list of comics to display.
     * 
     * @return the comics list property
     */
    public ListProperty<Comic> getDisplayComics() { 
        return this.displayComics;
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
    public ObjectProperty<Integer> getIssueNum() { 
        return this.issueNum; 
    }

    /**
     * Adds a new collection if the name is valid and not duplicate.
     */
    public void addCollection() {
        String newName = this.name.get();
        if (newName != null && !newName.isEmpty()) {
            boolean exists = this.displayCollections.stream()
                                .anyMatch(c -> c.getName().equals(newName));
            if (exists) {
                return;
            }
            Collection item = new Collection(newName);
            this.displayCollections.add(item);
            this.name.set("");
        }
    }

    /**
     * Removes the selected collection.
     */
    public void removeCollection() {
        Collection selected = this.selectedCollection.get();
        if (selected != null) {
            this.displayCollections.remove(selected);
            this.displayComics.set(FXCollections.observableArrayList());
        }
    }
    
    /**
     * Adds a comic using the bound properties and updates the map.
     */
    public void addComic() {
        String title = this.comicName.get();
        Integer issue = this.issueNum.get();

        if (title == null || title.isBlank() || issue == null || issue <= 0) {
            return;
        }

        Collection selected = this.selectedCollection.get();
        if (selected == null) {
            return;
        }

        Comic newComic = new Comic(title.trim(), issue);
        if (!selected.getComics().contains(newComic)) {
            selected.addComic(newComic);
            
            String key = newComic.getComicName().toLowerCase() + "#" + newComic.getIssueNum();
            this.comicMap.put(key, newComic);
        }

        this.displayComics.set(selected.getComics());

        this.comicName.set("");
        this.issueNum.set(0);
    }

    /**
     * Removes the selected comic from the collection.
     */
    public void removeComic() {
        Collection selected = this.selectedCollection.get();
        Comic comic = this.selectedComic.get();

        if (selected != null && comic != null) {
            selected.removeComic(comic);
            this.displayComics.set(selected.getComics());
        }
    }

    /**
     * Adds a comic directly and updates the map.
     * 
     * @param comic the comic to add
     */
    public void addComic(Comic comic) {
        if (comic != null) {
            String key = comic.getComicName().toLowerCase() + "#" + comic.getIssueNum();
            this.comicMap.put(key, comic);
            this.displayComics.add(comic);
        }
    }
 
    /**
     * Searches for a comic by title and issue number.
     * 
     * @param title the comic title
     * @param issue the issue number
     * @return the matching comic, or null if not found
     */
    public Comic searchComic(String title, int issue) {
        if (title == null) {
            return null;
        }
        
        String key = title.toLowerCase() + "#" + issue;
        return this.comicMap.get(key);
    }
}
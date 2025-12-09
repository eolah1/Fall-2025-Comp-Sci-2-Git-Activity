package edu.westga.cs1302.Collection.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Represents a collection of comics with a name and list of comics.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Collection {

    private String name;
    private ObservableList<Comic> comics;
    
    /**
     * Creates a new Collection with the given name.
     * 
     * @param name the name of the collection
     */
    public Collection(String name) {
        this.name = name;
        this.comics = FXCollections.observableArrayList();
    }
    
    /**
     * Gets the comics in this collection.
     * 
     * @return the list of comics
     */
    public ObservableList<Comic> getComics() {
        return this.comics;
    }
    
    /**
     * Gets the name of this collection.
     * 
     * @return the collection name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets the comics in this collection.
     * 
     * @param comics the new list of comics
     */
    public void setComics(ObservableList<Comic> comics) {
        this.comics = comics;
    }
    
    /**
     * Sets the name of this collection.
     * 
     * @param name the new collection name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns the name of this collection.
     * 
     * @return the collection name
     */
    @Override
    public String toString() {
        return this.name;
    }
    
    /**
     * Adds a comic to the collection if not already present.
     * 
     * @param comic the comic to add
     */
    public void addComic(Comic comic) {
        if (comic != null && !this.comics.contains(comic)) {
            this.comics.add(comic);
        }
    }
    
    /**
     * Removes a comic from the collection.
     * 
     * @param comic the comic to remove
     */
    public void removeComic(Comic comic) {
        this.comics.remove(comic);
    }
}

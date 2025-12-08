package edu.westga.cs1302.Collection.model;

import javafx.collections.ObservableList;

/**
 * Generates a random password based on the characteristics required.
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
		this.comics = comics;
	}
	
	public ObservableList<Comic> getComics() {
		return this.comics;
	}
	
	public String getName() {
		return name;
	}
	
	public void setComics(ObservableList<Comic> comics) {
		this.comics = comics;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
}

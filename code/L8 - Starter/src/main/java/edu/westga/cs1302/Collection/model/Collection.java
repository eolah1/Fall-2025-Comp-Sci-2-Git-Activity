package edu.westga.cs1302.Collection.model;

/**
 * Generates a random password based on the characteristics required.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Collection {

	private String name;
	
	public Collection(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

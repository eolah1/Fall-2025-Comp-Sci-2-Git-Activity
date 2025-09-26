package edu.westga.cs1302.project1;

public class Task {
	
	private final String name;
	private final String priority;
	private String description;
	
	public Task(String name, String description, String priority) {
		this.name = name;
		this.priority = priority;
		this.description = description; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getPriority() {
		return this.priority;
	}
	
	public void setDescription(String newDescription) {
	    this.description = newDescription;
	}
	
	public String toString() {
	    return "(" + this.priority + ") " + this.name + " - " + this.description;
	}
}

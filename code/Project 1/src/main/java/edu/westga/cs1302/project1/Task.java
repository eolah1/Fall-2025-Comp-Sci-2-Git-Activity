package edu.westga.cs1302.project1;

/**
 * Represents a task with a name, description, and priority level.
 * Used to manage and display tasks in a to do list.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Task {
	
	private final String name;
	private final String priority;
	private String description;
	
	/**
     * Creates a new Task with the specified name, description, and priority.
     * 
     * @param name the name of the task
     * @param description the description of the task
     * @param priority the priority level of the task (e.g., "High", "Medium", "Low")
     */
	public Task(String name, String description, String priority) {
		this.name = name;
		this.priority = priority;
		this.description = description; 
	}
	
	/**
     * Gets the name of the task.
     * 
     * @return the task name
     */
	public String getName() {
		return this.name;
	}
	
	/**
     * Gets the description of the task.
     * 
     * @return the task description
     */
	public String getDescription() {
		return this.description;
	}
	
	/**
     * Gets the priority level of the task.
     * 
     * @return the task priority
     */
	public String getPriority() {
		return this.priority;
	}
	
	/**
     * Updates the description of the task.
     * 
     * @param newDescription the new description to set
     */
	public void setDescription(String newDescription) {
	    this.description = newDescription;
	}
	
	/**
     * Returns a string representation of the task, including its priority, name, and description.
     * 
     * @return a formatted string of the task
     */
	public String toString() {
	    return "(" + this.priority + ") " + this.name + " - " + this.description;
	}
}

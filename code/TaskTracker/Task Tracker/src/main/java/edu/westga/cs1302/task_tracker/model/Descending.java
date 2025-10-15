package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/**
 * Compares tasks and sorts them in descending order
 * 
 * @version CS 1302
 * @author Fall 2025
 */
public class Descending implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		return t1.getPriority().compareTo(t2.getPriority());
	}
	
	@Override 
	public String toString() {
		return "Descending";
	}
}

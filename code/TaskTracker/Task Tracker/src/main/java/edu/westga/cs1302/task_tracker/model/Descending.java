package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/**
 * Compares tasks and sorts them in ascending order
 * 
 * @version CS 1302
 * @author Fall 2025
 */
public class Descending implements Comparator<Task> {

	@Override
	public int compare(Task t1, Task t2) {
		return t2.getPriority().compareTo(t1.getPriority());
	}
	
	@Override 
	public String toString() {
		return "Descending";
	}
}

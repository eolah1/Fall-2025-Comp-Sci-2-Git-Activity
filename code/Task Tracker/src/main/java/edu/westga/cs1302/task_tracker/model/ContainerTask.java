package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Task that contains subtasks.
 * 
 * @author CS 1302
 * @version Fall 2025 
 */
public class ContainerTask extends Task {
	
	private final List<Task> subtasks;

	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		this.subtasks = new ArrayList<>();
	}
	
	@Override
	public ContainerTask addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Subtask cannot be null");
		}
		this.subtasks.add(task);
		return this;
	}
	
	@Override
	public List<Task> getSubTasks() {
		return this.subtasks;
	}
	
	@Override
	public String toString() {
		return this.getName() + " (+)";
	}
}

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

	/** Creates a new ContainerTask with the specified name, description, and priority.
	 * 
	 * @precondition name != null && description != null &&
	 *               priority != null
	 * @postcondition a ContainerTask object is created with the given name, description,
	 *                and priority, and an empty list of subtasks
	 * 
	 * @param name the name of the task
	 * @param description the description of the task
	 * @param priority the priority level of the task
	 */
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		this.subtasks = new ArrayList<>();
	}
	
	/** Adds the provided subtask to this ContainerTask.
	 * 
	 * @precondition task != null
	 * @postcondition the specified subtask is added to this ContainerTask’s list of subtasks &&
	 *                this ContainerTask is returned
	 * 
	 * @param task the Task to be added as a subtask
	 * @return this ContainerTask with the new subtask added
	 * @throws IllegalArgumentException if task is null
	 */
	@Override
	public ContainerTask addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Subtask cannot be null");
		}
		this.subtasks.add(task);
		return this;
	}
	
	/** Retrieves the list of subtasks contained within this ContainerTask.
	 * 
	 * @precondition none
	 * @postcondition the list of subtasks is returned; the returned list
	 *                directly references the collection
	 * 
	 * @return the list of subtasks for this ContainerTask
	 */
	@Override
	public List<Task> getSubTasks() {
		return this.subtasks;
	}
	
	/** Returns a String representing this ContainerTask
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a String representing this COntainerTask in the format "name (+)"
	 */
	@Override
	public String toString() {
		return this.getName() + " (+)";
	}
}

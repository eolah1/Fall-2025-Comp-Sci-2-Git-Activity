package edu.westga.cs1302.project1;

import java.util.List;

import javafx.scene.control.Alert;

/**
 * Utility class for performing operations on lists of Task objects.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Utility {
	
	/**
	 * Counts the number of tasks in the given list that match the specified priority.
	 * 
	 * @param priority the priority to match
	 * @param tasks the list of tasks to search
	 * @return the number of tasks with the given priority or 0 if input is invalid
	 */
	public static int countTaskPriority(String priority, List<Task> tasks) {
        if (priority == null || tasks == null) {
            return 0;
        }

        int count = 0;
        for (Task task : tasks) {
            if (task.getPriority().equals(priority)) {
                count++;
            }
        }
        return count;
    }
}

package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testDescendingComparatorSortsHighBeforeLow() {
	    Task low = new Task("Low", "description", TaskPriority.LOW);
	    Task high = new Task("High", "description", TaskPriority.HIGH);
	    Descending comparator = new Descending();
	    assertTrue(comparator.compare(high, low) < 0);
	}

}

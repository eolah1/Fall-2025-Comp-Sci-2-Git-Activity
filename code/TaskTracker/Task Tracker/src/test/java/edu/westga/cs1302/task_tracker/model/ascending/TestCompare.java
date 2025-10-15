package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Ascending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testAscendingComparatorSortsLowBeforeHigh() {
	    Task low = new Task("Low", "description", TaskPriority.LOW);
	    Task high = new Task("High", "description", TaskPriority.HIGH);
	    Ascending comparator = new Ascending();
	    assertTrue(comparator.compare(low, high) < 0);
	}

}

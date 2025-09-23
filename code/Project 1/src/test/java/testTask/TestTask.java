package testTask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.Task;

class TestTask {

	@Test
	void testToStringReturnsName() {
		Task task = new Task("Homework", "Do math exercises", "High");
	    assertEquals("(High) Homework - Do math exercises", task.toString());
	}

}

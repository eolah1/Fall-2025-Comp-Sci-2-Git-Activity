package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.Task;

class TestTask {

	@Test
	public void testConstructorWithValidInputs() {
		Task task = new Task("Homework", "Finish math problems", "High");
		assertEquals("Homework", task.getName());
		assertEquals("Finish math problems", task.getDescription());
		assertEquals("High", task.getPriority());
	}

	@Test
	public void testConstructorWithEmptyDescription() {
		Task task = new Task("Homework", "", "Low");
		assertEquals("", task.getDescription());
	}

	@Test
	public void testSetDescriptionUpdatesDescription() {
		Task task = new Task("Homework", "Science quiz", "High");
		task.setDescription("Science project");
		assertEquals("Science project", task.getDescription());
	}

	@Test
	public void testSetDescriptionToEmptyString() {
		Task task = new Task("Homework", "Old description", "High");
		task.setDescription("");
		assertEquals("", task.getDescription());
	}

	@Test
	public void testToStringFormat() {
		Task task = new Task("Homework", "Finish math problems", "High");
		assertEquals("(High) Homework - Finish math problems", task.toString());
	}

	@Test
	public void testToStringWithEmptyDescription() {
		Task task = new Task("Homework", "", "High");
		assertEquals("(High) Homework - ", task.toString());
	}
}

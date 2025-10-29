package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;

class TestAddTask {

	@Test
    void testNullAddTask() {
        Task task = new Task("Main", "Main description", Task.TaskPriority.HIGH);

        assertThrows(IllegalArgumentException.class, () -> {
            task.addTask(null);
        });
    }

	@Test
    void testAddTaskCreatesTaskWithSameInfo() {
        Task mainTask = new Task("Main", "Main description", Task.TaskPriority.MEDIUM);
        Task subTask = new Task("Sub", "Sub description", Task.TaskPriority.LOW);

        Task result = mainTask.addTask(subTask);

        assertEquals("Main", result.getName());
        assertEquals("Main description", result.getDescription());
        assertEquals(Task.TaskPriority.MEDIUM, result.getPriority());
    }

	@Test
    void testAddTaskAddsSubTaskCorrectly() {
        Task mainTask = new Task("Main", "Main description", Task.TaskPriority.HIGH);
        Task subTask = new Task("Sub", "Sub description", Task.TaskPriority.LOW);

        Task result = mainTask.addTask(subTask);

        assertEquals(1, result.getSubTasks().size());
        assertEquals(subTask, result.getSubTasks().get(0));
    }

    @Test
    void testToString() {
        Task mainTask = new Task("Main", "Main description", Task.TaskPriority.HIGH);
        Task subTask = new Task("Sub", "Sub description", Task.TaskPriority.LOW);

        Task result = mainTask.addTask(subTask);

        assertTrue(result.toString().contains("(+)"));
    }

}

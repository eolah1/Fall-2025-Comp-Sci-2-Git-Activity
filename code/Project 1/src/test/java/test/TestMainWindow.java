package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.Task;

class TestMainWindow {

	@Test
    public void testAddSingleTaskToList() {
        ArrayList<Task> taskList = new ArrayList<>();
        Task newTask = new Task("Study", "Read chapter 5", "Medium");
        taskList.add(newTask);
        assertEquals(1, taskList.size());
        assertEquals("Study", taskList.get(0).getName());
    }

    @Test
    public void testAddMultipleTasksToList() {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Study", "Read chapter 5", "Medium"));
        taskList.add(new Task("Exercise", "Run 3 miles", "High"));
        taskList.add(new Task("Relax", "Watch a movie", "Low"));
        assertEquals(3, taskList.size());
    }

    @Test
    public void testRemoveTaskFromList() {
        ArrayList<Task> taskList = new ArrayList<>();
        Task task = new Task("Study", "Read chapter 5", "Medium");
        taskList.add(task);
        taskList.remove(task);
        assertEquals(0, taskList.size());
    }

    @Test
    public void testRemoveTaskFromEmptyList() {
        ArrayList<Task> taskList = new ArrayList<>();
        Task task = new Task("Study", "Read chapter 5", "Medium");
        taskList.remove(task);
        assertEquals(0, taskList.size());
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("Study", "Old description", "Medium");
        task.setDescription("Updated description");
        assertEquals("Updated description", task.getDescription());
    }

    @Test
    public void testUpdateTaskDescriptionToEmpty() {
        Task task = new Task("Study", "Old description", "Medium");
        task.setDescription("");
        assertEquals("", task.getDescription());
    }

    @Test
    public void testUpdateMultipleTaskDescriptions() {
        Task task1 = new Task("Study", "Old 1", "Medium");
        Task task2 = new Task("Exercise", "Old 2", "High");
        task1.setDescription("New 1");
        task2.setDescription("New 2");
        assertEquals("New 1", task1.getDescription());
        assertEquals("New 2", task2.getDescription());
    }

}

package edu.westga.cs1302.task_tracker.model.addTask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import edu.westga.cs1302.task_tracker.model.Ascending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;
import edu.westga.cs1302.task_tracker.model.Descending;

import org.junit.jupiter.api.Test;

class TestAddTaskSorting {

	@Test
    void testAddToEmptyListAscending() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> ascending = new Ascending();

        Task newTask = new Task("Task1", "Desc", TaskPriority.HIGH);
        tasks.add(newTask);
        tasks.sort(ascending);

        assertEquals(1, tasks.size());
        assertEquals(TaskPriority.HIGH, tasks.get(0).getPriority());
    }

    @Test
    void testAddToEmptyListDescending() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> descending = new Descending();

        Task newTask = new Task("Task1", "Desc", TaskPriority.LOW);
        tasks.add(newTask);
        tasks.sort(descending);

        assertEquals(1, tasks.size());
        assertEquals(TaskPriority.LOW, tasks.get(0).getPriority());
    }

    @Test
    void testAddWithoutComparator() {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Task1", "Desc", TaskPriority.MEDIUM));
        tasks.add(new Task("Task2", "Desc", TaskPriority.LOW)); // append

        assertEquals(TaskPriority.MEDIUM, tasks.get(0).getPriority());
        assertEquals(TaskPriority.LOW, tasks.get(1).getPriority());
    }

    @Test
    void testAddAscendingHighTask() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> ascending = new Ascending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.LOW));
        tasks.add(new Task("Task2", "Desc", TaskPriority.MEDIUM));
        Task newTask = new Task("Task3", "Desc", TaskPriority.HIGH);

        tasks.add(newTask);
        tasks.sort(ascending);

        assertEquals(TaskPriority.LOW, tasks.get(0).getPriority());
        assertEquals(TaskPriority.MEDIUM, tasks.get(1).getPriority());
        assertEquals(TaskPriority.HIGH, tasks.get(2).getPriority());
    }

    @Test
    void testAddAscendingLowTask() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> ascending = new Ascending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.MEDIUM));
        tasks.add(new Task("Task2", "Desc", TaskPriority.HIGH));
        Task newTask = new Task("Task3", "Desc", TaskPriority.LOW);

        tasks.add(newTask);
        tasks.sort(ascending);

        assertEquals(TaskPriority.LOW, tasks.get(0).getPriority());
        assertEquals(TaskPriority.MEDIUM, tasks.get(1).getPriority());
        assertEquals(TaskPriority.HIGH, tasks.get(2).getPriority());
    }

    @Test
    void testAddAscendingDuplicatePriority() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> ascending = new Ascending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.MEDIUM));
        Task newTask = new Task("Task2", "Desc", TaskPriority.MEDIUM);

        tasks.add(newTask);
        tasks.sort(ascending);

        assertEquals(2, tasks.size());
        assertEquals(TaskPriority.MEDIUM, tasks.get(0).getPriority());
        assertEquals(TaskPriority.MEDIUM, tasks.get(1).getPriority());
    }
    
    @Test
    void testAddDescendingHighTask() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> descending = new Descending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.MEDIUM));
        tasks.add(new Task("Task2", "Desc", TaskPriority.LOW));
        Task newTask = new Task("Task3", "Desc", TaskPriority.HIGH);

        tasks.add(newTask);
        tasks.sort(descending);

        assertEquals(TaskPriority.HIGH, tasks.get(0).getPriority());
        assertEquals(TaskPriority.MEDIUM, tasks.get(1).getPriority());
        assertEquals(TaskPriority.LOW, tasks.get(2).getPriority());
    }

    @Test
    void testAddDescendingLowTask() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> descending = new Descending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.HIGH));
        tasks.add(new Task("Task2", "Desc", TaskPriority.MEDIUM));
        Task newTask = new Task("Task3", "Desc", TaskPriority.LOW);

        tasks.add(newTask);
        tasks.sort(descending);

        assertEquals(TaskPriority.HIGH, tasks.get(0).getPriority());
        assertEquals(TaskPriority.MEDIUM, tasks.get(1).getPriority());
        assertEquals(TaskPriority.LOW, tasks.get(2).getPriority());
    }

    @Test
    void testAddDescendingDuplicatePriority() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> descending = new Descending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.LOW));
        Task newTask = new Task("Task2", "Desc", TaskPriority.LOW);

        tasks.add(newTask);
        tasks.sort(descending);

        assertEquals(2, tasks.size());
        assertEquals(TaskPriority.LOW, tasks.get(0).getPriority());
        assertEquals(TaskPriority.LOW, tasks.get(1).getPriority());
    }

    @Test
    void testMultipleAddAscending() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> ascending = new Ascending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.HIGH));
        tasks.add(new Task("Task2", "Desc", TaskPriority.LOW));
        tasks.add(new Task("Task3", "Desc", TaskPriority.MEDIUM));

        tasks.sort(ascending);

        assertEquals(TaskPriority.LOW, tasks.get(0).getPriority());
        assertEquals(TaskPriority.MEDIUM, tasks.get(1).getPriority());
        assertEquals(TaskPriority.HIGH, tasks.get(2).getPriority());
    }

    @Test
    void testMultipleAddDescending() {
        List<Task> tasks = new ArrayList<>();
        Comparator<Task> descending = new Descending();

        tasks.add(new Task("Task1", "Desc", TaskPriority.LOW));
        tasks.add(new Task("Task2", "Desc", TaskPriority.HIGH));
        tasks.add(new Task("Task3", "Desc", TaskPriority.MEDIUM));

        tasks.sort(descending);

        assertEquals(TaskPriority.HIGH, tasks.get(0).getPriority());
        assertEquals(TaskPriority.MEDIUM, tasks.get(1).getPriority());
        assertEquals(TaskPriority.LOW, tasks.get(2).getPriority());
    }

}

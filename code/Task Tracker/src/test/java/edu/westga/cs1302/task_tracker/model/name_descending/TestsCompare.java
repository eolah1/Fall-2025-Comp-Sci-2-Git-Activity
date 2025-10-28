package edu.westga.cs1302.task_tracker.model.name_descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.NameDescending;
import edu.westga.cs1302.task_tracker.model.Task;

class TestsCompare {

	@Test
    void testFirstNameBeforeSecond() {
        Task t1 = new Task("Adam", "desc", Task.TaskPriority.HIGH);
        Task t2 = new Task("Bart", "desc", Task.TaskPriority.HIGH);
        NameDescending comparator = new NameDescending();

        assertTrue(comparator.compare(t1, t2) > 0);
    }

    @Test
    void testFirstNameAfterSecond() {
        Task t1 = new Task("Cameron", "desc", Task.TaskPriority.HIGH);
        Task t2 = new Task("Bart", "desc", Task.TaskPriority.HIGH);
        NameDescending comparator = new NameDescending();

        assertTrue(comparator.compare(t1, t2) < 0);
    }

    @Test
    void testSameName() {
        Task t1 = new Task("Mark", "desc", Task.TaskPriority.LOW);
        Task t2 = new Task("Mark", "desc", Task.TaskPriority.HIGH);
        NameDescending comparator = new NameDescending();

        assertEquals(0, comparator.compare(t1, t2));
    }

    @Test
    void testSameNameDifferentCase() {
        Task t1 = new Task("Ethan", "desc", Task.TaskPriority.HIGH);
        Task t2 = new Task("ethan", "desc", Task.TaskPriority.MEDIUM);
        NameDescending comparator = new NameDescending();

        assertEquals(0, comparator.compare(t1, t2));
    }

    @Test
    void testNameInsideName() {
        Task t1 = new Task("Ann", "desc", Task.TaskPriority.LOW);
        Task t2 = new Task("Anna", "desc", Task.TaskPriority.MEDIUM);
        NameDescending comparator = new NameDescending();

        assertTrue(comparator.compare(t1, t2) > 0);
    }

    @Test
    void testNamesWithSpaces() {
        Task t1 = new Task("Mary Blake", "desc", Task.TaskPriority.LOW);
        Task t2 = new Task("Mary Cameron", "desc", Task.TaskPriority.LOW);
        NameDescending comparator = new NameDescending();

        assertTrue(comparator.compare(t1, t2) > 0);
    }

    @Test
    void testNamesWithNumbers() {
        Task t1 = new Task("Blake1", "desc", Task.TaskPriority.HIGH);
        Task t2 = new Task("Blake2", "desc", Task.TaskPriority.LOW);
        NameDescending comparator = new NameDescending();

        assertTrue(comparator.compare(t1, t2) > 0);
    }

    @Test
    void testFirstTaskNullThrowsException() {
        Task t2 = new Task("Task", "desc", Task.TaskPriority.HIGH);
        NameDescending comparator = new NameDescending();

        assertThrows(IllegalArgumentException.class, () -> {
            comparator.compare(null, t2);
        });
    }

    @Test
    void testSecondTaskNullThrowsException() {
        Task t1 = new Task("Task", "desc", Task.TaskPriority.HIGH);
        NameDescending comparator = new NameDescending();

        assertThrows(IllegalArgumentException.class, () -> {
            comparator.compare(t1, null);
        });
    }

}

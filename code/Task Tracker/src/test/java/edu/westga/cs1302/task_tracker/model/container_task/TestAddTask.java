package edu.westga.cs1302.task_tracker.model.container_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;

class TestAddTask {

	@Test
    void testAddTaskWithNull() {
        ContainerTask container = new ContainerTask("Main", "Main description", Task.TaskPriority.HIGH);

        assertThrows(IllegalArgumentException.class, () -> {
            container.addTask(null);
        });
    }

    @Test
    void testAddTaskReturnsContainerTask() {
        ContainerTask container = new ContainerTask("Main", "Main description", Task.TaskPriority.MEDIUM);
        Task subTask = new Task("Sub", "Sub description", Task.TaskPriority.LOW);

        Task result = container.addTask(subTask);

        assertEquals(container, result);
    }

    @Test
    void testAddTaskAddsSubTask() {
        ContainerTask container = new ContainerTask("Main", "Main description", Task.TaskPriority.MEDIUM);
        Task subTask = new Task("Sub", "Sub description", Task.TaskPriority.LOW);

        container.addTask(subTask);

        assertEquals(1, container.getSubTasks().size());
        assertEquals(subTask, container.getSubTasks().get(0));
    }

    @Test
    void testAddMultipleSubTasks() {
        ContainerTask container = new ContainerTask("Main", "Main description", Task.TaskPriority.LOW);
        Task sub1 = new Task("Sub1", "Desc1", Task.TaskPriority.HIGH);
        Task sub2 = new Task("Sub2", "Desc2", Task.TaskPriority.MEDIUM);

        container.addTask(sub1);
        container.addTask(sub2);

        assertEquals(2, container.getSubTasks().size());
        assertTrue(container.getSubTasks().contains(sub1));
        assertTrue(container.getSubTasks().contains(sub2));
    }
}

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.Task;
import edu.westga.cs1302.project1.Utility;

class TestUtility {

	@Test
    public void testCountTasksByPriorityWithMatches() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Study", "Read", "High"));
        tasks.add(new Task("Exercise", "Run", "High"));
        tasks.add(new Task("Relax", "Movie", "Low"));

        int result = Utility.countTaskPriority("High", tasks);
        assertEquals(2, result);
    }

    @Test
    public void testCountTasksByPriorityWithNoMatches() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Study", "Read", "Medium"));
        tasks.add(new Task("Relax", "Movie", "Low"));

        int result = Utility.countTaskPriority("High", tasks);
        assertEquals(0, result);
    }

    @Test
    public void testCountTasksByPriorityWithEmptyList() {
        List<Task> tasks = new ArrayList<>();
        int result = Utility.countTaskPriority("High", tasks);
        assertEquals(0, result);
    }

    @Test
    public void testCountTasksByPriorityWithNullPriority() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Study", "Read", "High"));

        int result = Utility.countTaskPriority(null, tasks);
        assertEquals(0, result);
    }

    @Test
    public void testCountTasksByPriorityWithNullList() {
        int result = Utility.countTaskPriority("High", null);
        assertEquals(0, result);
    }
}

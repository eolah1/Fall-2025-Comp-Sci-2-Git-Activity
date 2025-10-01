package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestSaveStudentData {

	@Test
    public void testSaveSingleStudent() throws Exception {
        Student[] students = { new Student("Alice", 95) };
        StudentDataPersistenceManager.saveStudentData(students);

        File file = new File(StudentDataPersistenceManager.FILE_LOCATION);
        List<String> lines = Files.readAllLines(file.toPath());

        assertEquals(1, lines.size());
        assertEquals("Alice,95", lines.get(0));
    }

    @Test
    public void testSaveMultipleStudents() throws Exception {
        Student[] students = {
            new Student("Bob", 80),
            new Student("Carol", 70),
            new Student("Dave", 100)
        };
        StudentDataPersistenceManager.saveStudentData(students);

        File file = new File(StudentDataPersistenceManager.FILE_LOCATION);
        List<String> lines = Files.readAllLines(file.toPath());

        assertEquals(3, lines.size());
        assertEquals("Bob,80", lines.get(0));
        assertEquals("Carol,70", lines.get(1));
        assertEquals("Dave,100", lines.get(2));
    }

    @Test
    public void testSaveNullThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentDataPersistenceManager.saveStudentData(null);
        });
    }
}

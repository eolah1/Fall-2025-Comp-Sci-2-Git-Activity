package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

	private void createTestFile(String content) throws IOException {
        File file = new File("data.txt"); 
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
    }

    @Test
    public void testLoadSingleStudent() throws Exception {
        createTestFile("Alice,95");
        Student[] students = StudentDataPersistenceManager.loadStudentData();
        assertEquals(1, students.length);
        assertEquals("Alice", students[0].getName());
        assertEquals(95, students[0].getGrade());
    }

    @Test
    public void testLoadMultipleStudents() throws Exception {
        createTestFile("Bob,80\nCarol,70\nDave,100");
        Student[] students = StudentDataPersistenceManager.loadStudentData();
        assertEquals(3, students.length);
    }

    @Test
    public void testMissingGrade() throws Exception {
        createTestFile("Emily");
        assertThrows(IOException.class, () -> StudentDataPersistenceManager.loadStudentData());
    }

    @Test
    public void testExtraComma() throws Exception {
        createTestFile("Frank,90,Extra");
        assertThrows(IOException.class, () -> StudentDataPersistenceManager.loadStudentData());
    }

    @Test
    public void testNonIntegerGrade() throws Exception {
        createTestFile("George,abc");
        assertThrows(IOException.class, () -> StudentDataPersistenceManager.loadStudentData());
    }

    @Test
    public void testEmptyLineIsIgnored() throws Exception {
        createTestFile("Henry,85\n\nIsla,90");
        Student[] students = StudentDataPersistenceManager.loadStudentData();
        assertEquals(2, students.length);
    }

    @Test
    public void testShortName() throws Exception {
        createTestFile("Al,77");
        assertThrows(IOException.class, () -> StudentDataPersistenceManager.loadStudentData());
    }

    @Test
    public void testBlankName() throws Exception {
        createTestFile(",85");
        assertThrows(IOException.class, () -> StudentDataPersistenceManager.loadStudentData());
    }

    @Test
    public void testEmptyFileReturnsEmptyArray() throws Exception {
        createTestFile("");
        Student[] students = StudentDataPersistenceManager.loadStudentData();
        assertEquals(0, students.length);
    }

}

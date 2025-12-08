package edu.westga.cs1302.collection.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Collection.model.Collection;

class TestCollection {

	@Test
    void testConstructorAndGetName() {
        Collection c = new Collection("MyCollection");
        assertEquals("MyCollection", c.getName());
    }

    @Test
    void testSetName() {
        Collection collection = new Collection("OldName");
        collection.setName("NewName");
        assertEquals("NewName", collection.getName());
    }

    @Test
    void testToString() {
        Collection collection = new Collection("DisplayName");
        assertEquals("DisplayName", collection.toString());
    }

    @Test
    void testDifferentName() {
        Collection collection1 = new Collection("One");
        Collection collection2 = new Collection("Two");
        assertNotEquals(collection1, collection2);
    }
}

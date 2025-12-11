package edu.westga.cs1302.collection.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Collection.model.Comic;

class TestComic {

	    @Test
	    public void testConstructorInitializesFieldsCorrectly() {
	        Comic comic = new Comic("Spider-Man", 10);
	        assertEquals("Spider-Man", comic.getTitle());
	        assertEquals(10, comic.getIssueNum());
	    }

	    @Test
	    public void testGetComicNameReturnsCorrectName() {
	        Comic comic = new Comic("Batman", 15);
	        assertEquals("Batman", comic.getTitle());
	    }

	    @Test
	    public void testGetIssueNumReturnsCorrectIssueNumber() {
	        Comic comic = new Comic("Iron Man", 37);
	        assertEquals(37, comic.getIssueNum());
	    }

	    @Test
	    public void testSetNameUpdatesComicName() {
	        Comic comic = new Comic("Thor", 98);
	        comic.setName("Mighty Thor");
	        assertEquals("Mighty Thor", comic.getTitle());
	    }

	    @Test
	    public void testToStringReturnsFormattedString() {
	        Comic comic = new Comic("Hulk", 76);
	        String expected = "Hulk (Issue #: 76)";
	        assertEquals(expected, comic.toString());
	    }

	    @Test
	    public void testToStringReflectsUpdatedName() {
	        Comic comic = new Comic("Captain America", 50);
	        comic.setName("Cap");
	        String expected = "Cap (Issue #: 50)";
	        assertEquals(expected, comic.toString());
	    }

	    @Test
	    public void testToStringReflectsDifferentIssueNumbers() {
	        Comic comic = new Comic("X-Men", 101);
	        String expected = "X-Men (Issue #: 101)";
	        assertEquals(expected, comic.toString());
	    }

}

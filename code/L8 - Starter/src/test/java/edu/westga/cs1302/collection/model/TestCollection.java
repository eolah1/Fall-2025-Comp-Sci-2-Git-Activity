package edu.westga.cs1302.collection.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import javafx.collections.FXCollections;

class TestCollection {

	@Test
    public void testConstructorStoresNameAndInitializesComics() {
        Collection coll = new Collection("Favorites");
        assertEquals("Favorites", coll.getName());
        assertNotNull(coll.getComics());
        assertTrue(coll.getComics().isEmpty());
    }

    @Test
    public void testSetNameUpdatesName() {
        Collection coll = new Collection("Old Name");
        coll.setName("New Name");
        assertEquals("New Name", coll.getName());
    }

    @Test
    public void testSetComicsReplacesList() {
        Collection coll = new Collection("Favorites");
        Comic comic = new Comic("Batman", 1);
        var newList = FXCollections.<Comic>observableArrayList(comic);
        coll.setComics(newList);
        assertEquals(1, coll.getComics().size());
        assertTrue(coll.getComics().contains(comic));
    }

    @Test
    public void testAddComicAddsComic() {
        Collection coll = new Collection("Favorites");
        Comic comic = new Comic("Batman", 1);
        coll.addComic(comic);
        assertEquals(1, coll.getComics().size());
        assertTrue(coll.getComics().contains(comic));
    }

    @Test
    public void testAddComicDoesNotAddDuplicate() {
        Collection coll = new Collection("Favorites");
        Comic comic = new Comic("Batman", 1);
        coll.addComic(comic);
        coll.addComic(comic);
        assertEquals(1, coll.getComics().size());
    }

    @Test
    public void testAddComicNullDoesNothing() {
        Collection coll = new Collection("Favorites");
        coll.addComic(null);
        assertTrue(coll.getComics().isEmpty());
    }

    @Test
    public void testRemoveComicRemovesComic() {
        Collection coll = new Collection("Favorites");
        Comic comic = new Comic("Batman", 1);
        coll.addComic(comic);
        coll.removeComic(comic);
        assertTrue(coll.getComics().isEmpty());
    }

    @Test
    public void testRemoveComicNotInListDoesNothing() {
        Collection coll = new Collection("Favorites");
        Comic comic1 = new Comic("Batman", 1);
        Comic comic2 = new Comic("Superman", 2);
        coll.addComic(comic1);
        coll.removeComic(comic2);
        assertEquals(1, coll.getComics().size());
        assertTrue(coll.getComics().contains(comic1));
    }

    @Test
    public void testToStringReturnsName() {
        Collection coll = new Collection("Favorites");
        assertEquals("Favorites", coll.toString());
    }
}

package edu.westga.cs1302.collection.viewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class TestMainWindowViewModel {

	@Test
    public void testConstructorInitializesWithGivenName() {
        Collection collection = new Collection("Marvel");
        assertEquals("Marvel", collection.getName());
    }

    @Test
    public void testConstructorInitializesWithEmptyComicsList() {
        Collection collection = new Collection("Marvel");
        assertTrue(collection.getComics().isEmpty());
    }

    @Test
    public void testSetNameUpdatesCollectionName() {
        Collection collection = new Collection("Marvel");
        collection.setName("DC");
        assertEquals("DC", collection.getName());
    }

    @Test
    public void testSetComicsReplacesComicsList() {
        Collection collection = new Collection("Marvel");
        ObservableList<Comic> comics = FXCollections.observableArrayList();
        Comic comic = new Comic("Batman", 15);
        comics.add(comic);

        collection.setComics(comics);

        assertEquals(1, collection.getComics().size());
        assertEquals(comic, collection.getComics().get(0));
    }

    @Test
    public void testToStringReturnsCollectionName() {
        Collection collection = new Collection("Marvel");
        assertEquals("Marvel", collection.toString());
    }

    @Test
    public void testAddComicAddsComicWhenValidAndNotDuplicate() {
        Collection collection = new Collection("Marvel");
        Comic comic = new Comic("Spider-Man", 10);
        collection.addComic(comic);

        assertEquals(1, collection.getComics().size());
        assertEquals(comic, collection.getComics().get(0));
    }

    @Test
    public void testAddComicDoesNotAddNullComic() {
        Collection collection = new Collection("Marvel");
        collection.addComic(null);
        assertTrue(collection.getComics().isEmpty());
    }

    @Test
    public void testAddComicDoesNotAddDuplicateComic() {
        Collection collection = new Collection("Marvel");
        Comic comic = new Comic("Iron Man", 37);
        collection.addComic(comic);
        collection.addComic(comic);

        assertEquals(1, collection.getComics().size());
    }

    @Test
    public void testRemoveComicRemovesComicIfExists() {
        Collection collection = new Collection("Marvel");
        Comic comic = new Comic("Thor", 98);
        collection.addComic(comic);

        collection.removeComic(comic);

        assertTrue(collection.getComics().isEmpty());
    }

    @Test
    public void testRemoveComicDoesNothingIfComicNotInList() {
        Collection collection = new Collection("Marvel");
        Comic comic = new Comic("Hulk", 76);
        collection.removeComic(comic);

        assertTrue(collection.getComics().isEmpty());
    }
}

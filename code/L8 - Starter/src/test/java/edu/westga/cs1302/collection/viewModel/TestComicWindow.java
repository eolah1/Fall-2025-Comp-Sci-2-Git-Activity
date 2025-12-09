package edu.westga.cs1302.collection.viewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import edu.westga.cs1302.Collection.viewmodel.ComicWindowViewModel;

class TestComicWindow {

	@Test
    public void testConstructorInitializesPropertiesCorrectly() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();

        assertNotNull(viewModel.getComicName());
        assertEquals("", viewModel.getComicName().get());

        assertNotNull(viewModel.getIssueNum());
        assertEquals(0, viewModel.getIssueNum().get());

        assertNotNull(viewModel.getComics());
        assertTrue(viewModel.getComics().isEmpty());

        assertNotNull(viewModel.getSelectedComic());
        assertNull(viewModel.getSelectedComic().get());

        assertNotNull(viewModel.getSelectedCollection());
        assertNull(viewModel.getSelectedCollection().get());
    }

    @Test
    public void testComicNamePropertyCanBeUpdated() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();
        viewModel.getComicName().set("Spider-Man");
        assertEquals("Spider-Man", viewModel.getComicName().get());
    }

    @Test
    public void testIssueNumPropertyCanBeUpdated() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();
        viewModel.getIssueNum().set(15);
        assertEquals(15, viewModel.getIssueNum().get());
    }

    @Test
    public void testSelectedComicPropertyCanBeUpdated() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();
        Comic comic = new Comic("Batman", 20);
        viewModel.getSelectedComic().set(comic);
        assertEquals(comic, viewModel.getSelectedComic().get());
    }

    @Test
    public void testSelectedCollectionUpdatesComicsList() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();
        Collection collection = new Collection("Marvel");
        Comic comic1 = new Comic("Iron Man", 37);
        Comic comic2 = new Comic("Thor", 98);
        collection.addComic(comic1);
        collection.addComic(comic2);

        viewModel.getSelectedCollection().set(collection);

        assertEquals(2, viewModel.getComics().size());
        assertTrue(viewModel.getComics().contains(comic1));
        assertTrue(viewModel.getComics().contains(comic2));
    }

    @Test
    public void testSelectedCollectionSetToNullResetsComicsList() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();
        Collection collection = new Collection("DC");
        Comic comic = new Comic("Superman", 1);
        collection.addComic(comic);

        viewModel.getSelectedCollection().set(collection);
        assertFalse(viewModel.getComics().isEmpty());

        // Now set to null
        viewModel.getSelectedCollection().set(null);
        assertTrue(viewModel.getComics().isEmpty());
    }

    @Test
    public void testComicsListInitiallyEmpty() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();
        assertTrue(viewModel.getComics().isEmpty());
    }

    @Test
    public void testComicsListReflectsCollectionChanges() {
        ComicWindowViewModel viewModel = new ComicWindowViewModel();
        Collection collection = new Collection("X-Men");
        viewModel.getSelectedCollection().set(collection);

        Comic comic = new Comic("Wolverine", 5);
        collection.addComic(comic);

        assertEquals(1, viewModel.getComics().size());
        assertEquals(comic, viewModel.getComics().get(0));
    }

}

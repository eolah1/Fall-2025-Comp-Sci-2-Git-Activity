package edu.westga.cs1302.collection.viewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.model.Comic;
import edu.westga.cs1302.Collection.view.MainWindow;
import edu.westga.cs1302.Collection.viewmodel.ComicWindowViewModel;
import edu.westga.cs1302.Collection.viewmodel.MainWindowViewModel;
import javafx.event.ActionEvent;

class TestMainWindowViewModel {

	@Test
    public void testConstructorInitializesProperties() {
        MainWindowViewModel vm = new MainWindowViewModel();

        assertNotNull(vm.getName());
        assertEquals("", vm.getName().get());

        assertNotNull(vm.getDisplayCollections());
        assertTrue(vm.getDisplayCollections().isEmpty());

        assertNotNull(vm.getSelectedCollections());
        assertNull(vm.getSelectedCollections().get());
    }

    @Test
    public void testAddCollectionAddsNewCollection() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Favorites");

        vm.addCollection();

        assertEquals(1, vm.getDisplayCollections().size());
        assertEquals("Favorites", vm.getDisplayCollections().get(0).getName());
    }

    @Test
    public void testAddCollectionClearsNameAfterAdd() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Favorites");

        vm.addCollection();

        assertEquals("", vm.getName().get());
    }

    @Test
    public void testAddCollectionDoesNotAddIfNameIsEmpty() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("");

        vm.addCollection();

        assertTrue(vm.getDisplayCollections().isEmpty());
    }

    @Test
    public void testAddCollectionDoesNotAddIfNameIsNull() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set(null);

        vm.addCollection();

        assertTrue(vm.getDisplayCollections().isEmpty());
    }

    @Test
    public void testAddCollectionDoesNotAddDuplicate() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Favorites");
        vm.addCollection();

        vm.getName().set("Favorites");
        vm.addCollection();

        assertEquals(1, vm.getDisplayCollections().size());
    }

    @Test
    public void testRemoveCollectionRemovesSelected() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Favorites");
        vm.addCollection();

        Collection coll = vm.getDisplayCollections().get(0);
        vm.getSelectedCollections().set(coll);

        vm.removeCollection();

        assertTrue(vm.getDisplayCollections().isEmpty());
    }

    @Test
    public void testRemoveCollectionDoesNothingIfNoneSelected() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Favorites");
        vm.addCollection();

        vm.getSelectedCollections().set(null);
        vm.removeCollection();

        assertEquals(1, vm.getDisplayCollections().size());
    }
}

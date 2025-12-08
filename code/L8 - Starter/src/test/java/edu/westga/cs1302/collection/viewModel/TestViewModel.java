package edu.westga.cs1302.collection.viewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.Collection.model.Collection;
import edu.westga.cs1302.Collection.viewmodel.ViewModel;

class TestViewModel {

	    @Test
	    void testInitialWindow() {
	        ViewModel vm = new ViewModel();
	        assertEquals("", vm.getName().get());
	        assertTrue(vm.getDisplayCollections().isEmpty());
	        assertNull(vm.getSelectedCollections().get());
	    }

	    @Test
	    void testAddCollectionWithValidName() {
	        ViewModel vm = new ViewModel();
	        vm.getName().set("TestCollection");
	        vm.addCollection();
	        assertEquals(1, vm.getDisplayCollections().size());
	        assertEquals("TestCollection", vm.getDisplayCollections().get(0).getName());
	        assertEquals("", vm.getName().get()); // cleared after add
	    }

	    @Test
	    void testAddCollectionWithEmptyNameDoesNothing() {
	        ViewModel vm = new ViewModel();
	        vm.getName().set("");
	        vm.addCollection();
	        assertTrue(vm.getDisplayCollections().isEmpty());
	    }

	    @Test
	    void testAddDuplicateCollectionDoesNothing() {
	        ViewModel vm = new ViewModel();
	        vm.getName().set("Dup");
	        vm.addCollection();
	        vm.getName().set("Dup");
	        vm.addCollection();
	        assertEquals(1, vm.getDisplayCollections().size());
	    }

	    @Test
	    void testRemoveCollectionWhenSelected() {
	        ViewModel vm = new ViewModel();
	        Collection collection = new Collection("RemoveMe");
	        vm.getDisplayCollections().add(collection);
	        vm.getSelectedCollections().set(collection);
	        vm.removeCollection();
	        assertTrue(vm.getDisplayCollections().isEmpty());
	    }

	    @Test
	    void testRemoveCollectionWhenNoneSelectedDoesNothing() {
	        ViewModel vm = new ViewModel();
	        vm.getDisplayCollections().add(new Collection("KeepMe"));
	        vm.removeCollection();
	        assertEquals(1, vm.getDisplayCollections().size());
	    }

}

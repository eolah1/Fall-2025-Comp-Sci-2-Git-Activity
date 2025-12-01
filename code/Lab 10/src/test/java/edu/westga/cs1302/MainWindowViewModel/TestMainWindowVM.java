package edu.westga.cs1302.MainWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class TestMainWindowVM {

	@Test
    public void testAddContactStoresInListAndMaps() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Sebastian");
        vm.getPhoneNumber().set("1234567");
        vm.addContact();

        assertEquals(1, vm.getContacts().size());
        assertEquals("Sebastian", vm.getContacts().get(0).getName());
        assertEquals("1234567", vm.getContacts().get(0).getPhoneNumber());
    }

    @Test
    public void testFindContactByName() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Terrance");
        vm.getPhoneNumber().set("621-3923");
        vm.addContact();

        vm.getSearchCriteria().set("Terrance");
        String result = vm.findContact();

        assertTrue(result.contains("Terrance"));
        assertTrue(result.contains("621-3923"));
    }

    @Test
    public void testFindContactByPhoneNumber() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getName().set("Mica");
        vm.getPhoneNumber().set("9875642");
        vm.addContact();

        vm.getSearchCriteria().set("9875642");
        String result = vm.findContact();

        assertTrue(result.contains("Mica"));
        assertTrue(result.contains("9875642"));
    }

    @Test
    public void testFindContactInvalidCriteriaThrowsException() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getSearchCriteria().set("93jnx89");

        assertThrows(IllegalArgumentException.class, () -> vm.findContact());
    }

    @Test
    public void testFindContactNotFoundReturnsMessage() {
        MainWindowViewModel vm = new MainWindowViewModel();
        vm.getSearchCriteria().set("NonExistentName");

        String result = vm.findContact();

        assertEquals("No contact found.", result);
    }
}

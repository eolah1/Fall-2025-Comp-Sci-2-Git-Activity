package edu.westga.cs1302.contact_manager.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.westga.cs1302.contact_manager.model.Contact;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** View model for the MainWindow view
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindowViewModel {
	private StringProperty name;
	private StringProperty phoneNumber;
	private StringProperty searchCriteria;
	private ListProperty<Contact> contacts;	
	private Map<String, Contact> contactName;
	private Map<String, Contact> contactPhoneNumber;
	
	/** Initialize the MainWindowViewModel
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public MainWindowViewModel() {
		this.name = new SimpleStringProperty("");
		this.phoneNumber = new SimpleStringProperty("");
		this.searchCriteria = new SimpleStringProperty("");
		this.contacts = new SimpleListProperty<Contact>(FXCollections.observableList(new ArrayList<Contact>()));
		this.contactName = new HashMap<>();
		this.contactPhoneNumber = new HashMap<>();
	}
	
	/** Return the name property used when adding a contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name property used when adding a contact
	 */
	public StringProperty getName() {
		return this.name;
	}
	
	/** Return the phone number property used when adding a contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the phone number property used when adding a contact
	 */
	public StringProperty getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/** Return the search criteria property used when finding a contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the search criteria property used when finding a contact
	 */
	public StringProperty getSearchCriteria() {
		return this.searchCriteria;
	}
	
	/** Return the list property containing all contacts added to the system
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list property containing all contacts added to the system
	 */
	public ListProperty<Contact> getContacts() {
		return this.contacts;
	}
	
	/** Adds a new contact with name and phone number set by the appropriate property
	 * 
	 * @precondition none
	 * @postcondition a new contact with name and phone number provided has been added
	 * 
	 * @throws IllegalArgumentException if either name or phone number are invalid (see Contact class)
	 */
	public void addContact() throws IllegalArgumentException {
		String newName = this.name.get();
		String newPhone = this.phoneNumber.get();
		
		if (this.contactName.containsKey(newName)) {
			throw new IllegalArgumentException("Contact name already exists");
		}
		
		if (this.contactPhoneNumber.containsKey(newPhone)) {
			throw new IllegalArgumentException("Contact phone number already exists");
		}
		
		Contact newContact = new Contact(this.name.get(), this.phoneNumber.get());
		this.contacts.add(newContact);
		this.contactName.put(newContact.getName(), newContact);
		this.contactPhoneNumber.put(newContact.getPhoneNumber(), newContact);
	}
	
	/** Finds a contact with name or phone number matches provide search criteria
	 * 
	 * @precondition none
	 * @postcondition getResultContact().get() is set to the appropriate contact (if contact found) OR null (if no contact found)
	 * 
	 * @return A string representation of the contact found or "No contact found." if none match.
	 */
	public String findContact() {
		String criteria = this.searchCriteria.get();
		
		if (!Contact.checkName(this.searchCriteria.get()) && !Contact.checkPhoneNumber(this.searchCriteria.get())) {
			throw new IllegalArgumentException("Search criteria is not a valid name or phone number");
		}
		
		Contact found = this.contactName.get(criteria);
		if (found == null) {
			found = this.contactPhoneNumber.get(criteria);
		}
		
		if (found != null) {
			return found.toString();
		} else {
			return "No contact found.";
		}
	}
	
}

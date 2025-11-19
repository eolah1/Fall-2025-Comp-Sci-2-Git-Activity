package edu.westga.cs1302.password_generator.viewmodel;

import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/** Manages utilizing the model and makes properties available to bind the UI elements.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ViewModel {
	private StringProperty minimumLength;
	private BooleanProperty requireDigits;
	private BooleanProperty requireLowercase;
	private BooleanProperty requireUppercase;
	
	private ListProperty<String> passwordHistory;
	private StringProperty errorText;
	
    private PasswordGenerator generator;
	private SimpleBooleanProperty inputValid;
	
	/** Initialize the properties for the viewmodel
	 */
	public ViewModel() {
		this.minimumLength = new SimpleStringProperty("1");
		this.requireDigits = new SimpleBooleanProperty(false);
		this.requireLowercase = new SimpleBooleanProperty(false);
		this.requireUppercase = new SimpleBooleanProperty(false);
		
		this.passwordHistory = new SimpleListProperty<String>(FXCollections.observableArrayList(new ArrayList<String>()));
		this.errorText = new SimpleStringProperty("");
		this.inputValid = new SimpleBooleanProperty(true);

        Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
	}

	/** Return weather input is valid
	 * 
	 * @return the input valid property
	 */
	public BooleanProperty getInputValid() {
		return this.inputValid;
	}
	
	/** Return the minimum length property
	 * 
	 * @return the minimum length property
	 */
	public StringProperty getMinimumLength() {
		return this.minimumLength;
	}

	/** Return the require digits property
	 * 
	 * @return the require digits property
	 */
	public BooleanProperty getRequireDigits() {
		return this.requireDigits;
	}

	/** Return the require upper case property
	 * 
	 * @return the require upper case property
	 */
	public BooleanProperty getRequireUppercase() {
		return this.requireUppercase;
	}

	/** Return the require lower case property
	 * 
	 * @return the require lower case property
	 */
	public BooleanProperty getRequireLowercase() {
		return this.requireLowercase;
	}

	/** Return the password property
	 * 
	 * @return the password property
	 */
	public ListProperty<String> getPasswordHistory() {
		return this.passwordHistory;
	}

	/** Return the error text property
	 * 
	 * @return the error text property
	 */
	public StringProperty getErrorText() {
		return this.errorText;
	}

	/** Generates a password using the minimum length, require digit, require lower case, and require upper case property values.
	 * 
	 * If a password is successfully generated, the error text property is set to empty string and the password property is set to the password generated.
	 * 
	 * If an error is encountered, the password property is set to empty, and the error text property is populated with a message describing the problem.
	 */
	public void generatePassword() {
    	int minimumLength = -1;
    	
    	try {
    		minimumLength = Integer.parseInt(this.minimumLength.getValue());
    	} catch (NumberFormatException numberError) {
    		this.errorText.setValue("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.getValue());
    		return;
    	}
    	
    	try {
    		this.generator.setMinimumLength(minimumLength);
    	} catch (IllegalArgumentException invalidLengthError) {
    		this.errorText.setValue("Invalid Minimum Length: " + invalidLengthError.getMessage());
    		return;
    	}
    	
    	this.generator.setMustHaveAtLeastOneDigit(this.requireDigits.getValue());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.requireLowercase.getValue());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.requireUppercase.getValue());
    	
    	String password = this.generator.generatePassword();
    	
    	this.passwordHistory.add(password);
    }
	
	/** Validates the minimum length input and updates errorText and inputValid accordingly.
	 * 
	 * @param input the string to validate as a minimum length
	 * @return true if valid, false otherwise
	 */
	public boolean validateMinimumLength(String input) {
	    if (!input.matches("\\d+")) {
	        this.errorText.set("Minimum length must be a positive whole number.");
	        this.inputValid.set(false);
	        return false;
	    }

	    int length = Integer.parseInt(input);
	    if (length < 1) {
	        this.errorText.set("Minimum length must be at least 1.");
	        this.inputValid.set(false);
	        return false;
	    }

	    this.errorText.set("");
	    this.minimumLength.set(input);
	    this.inputValid.set(true);
	    return true;
	}

}

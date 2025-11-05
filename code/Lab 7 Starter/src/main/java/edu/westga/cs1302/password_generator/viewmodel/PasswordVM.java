package edu.westga.cs1302.password_generator.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;

/**
 * ViewModel class that connects UI to the PasswordGenerator model.
 * Manages user input properties and generates random passwords based on them.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class PasswordVM {

	private final PasswordGenerator generator;
	private final IntegerProperty minimumLength;
	private final BooleanProperty mustHaveAtLeastOneDigit;
	private final BooleanProperty mustHaveAtLeastOneUpperCaseLetter;
	private final BooleanProperty mustHaveAtLeastOneLowerCaseLetter;
	private final StringProperty generatedPass = new SimpleStringProperty();

	/**
	 * Creates a new password view model and binds all properties to PasswordGenerator model.
	 * 
	 * @precondition password != null
	 * @postcondition properties reflect the current state of the model
	 * 
	 * @param password the PasswordGenerator model binds to
	 */
	public PasswordVM(PasswordGenerator password) {
		if (password == null) {
			throw new IllegalArgumentException("password cannot be null");
		}
		this.generator = password;
		this.minimumLength = new SimpleIntegerProperty(this.generator.getMinimumLength());
		this.mustHaveAtLeastOneDigit = new SimpleBooleanProperty(this.generator.getMustHaveAtLeastOneDigit());
		this.mustHaveAtLeastOneUpperCaseLetter = new SimpleBooleanProperty(this.generator.getMustHaveAtLeastOneUpperCaseLetter());
		this.mustHaveAtLeastOneLowerCaseLetter = new SimpleBooleanProperty(this.generator.getMustHaveAtLeastOneLowerCaseLetter());
		
		this.minimumLength.addListener((obs, oldValue, newValue) -> {
			if (newValue.intValue() >= 1) {
				this.generator.setMinimumLength(newValue.intValue());
			}
		});
        this.mustHaveAtLeastOneDigit.addListener((obs, oldValue, newValue) -> {
        	this.generator.setMustHaveAtLeastOneDigit(newValue);
        });
        this.mustHaveAtLeastOneUpperCaseLetter.addListener((obs, oldValue, newValue) -> {
        	 this.generator.setMustHaveAtLeastOneUpperCaseLetter(newValue);
        });
        this.mustHaveAtLeastOneLowerCaseLetter.addListener((obs, oldValue, newValue) -> {
        	this.generator.setMustHaveAtLeastOneLowerCaseLetter(newValue);
        });
	}
	
    /**
     * Gets the minimum length property.
     * 
     * @return the minimum length property
     */
    public IntegerProperty getMinimumLength() {
        return this.minimumLength;
    }

    /**
     * Gets the digit requirement property.
     * 
     * @return the digit requirement property
     */
    public BooleanProperty getMustHaveAtLeastOneDigit() {
        return this.mustHaveAtLeastOneDigit;
    }

    /**
     * Gets the uppercase letter requirement property.
     * 
     * @return the uppercase letter requirement property
     */
    public BooleanProperty getMustHaveAtLeastOneUpperCaseLetter() {
        return this.mustHaveAtLeastOneUpperCaseLetter;
    }

    /**
     * Gets the lowercase letter requirement property.
     * 
     * @return the lowercase letter requirement property
     */
    public BooleanProperty getMustHaveAtLeastOneLowerCaseLetter() {
        return this.mustHaveAtLeastOneLowerCaseLetter;
    }

    /**
     * Gets the generated password property.
     * 
     * @return the generated password property
     */
    public StringProperty getGeneratedPass() {
        return this.generatedPass;
    }
	
	/**
	 * Generates a password using the model and updates the property.
	 * 
	 * @precondition none
	 * @postcondition generatedPass is updated with a new password
	 */
	public void generatePassword() {
		String password = this.generator.generatePassword();
		this.generatedPass.set(password);
	}
}

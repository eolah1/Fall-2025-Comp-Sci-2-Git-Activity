package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestGeneratePassword {

	@Test
	void testMinimumLengthNotANumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("apple");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue(), "checking the password property");
		assertEquals("Invalid Minimum Length: must be a positive integer, but was apple", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testMinimumLengthNotAValidNumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("-2");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue(), "checking the password property");
		assertEquals("Invalid Minimum Length: minimum length must be at least 1", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		
		vm.generatePassword();
		
		assertTrue(vm.getPassword().getValue().length() >= 2, "checking the password property has an appropriate number of characters");
		assertEquals("", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testIsValidMinimumLengthValidNumber() {
	    ViewModel vm = new ViewModel();
	    boolean result = vm.isValidMinimumLength("5");

	    assertTrue(result, "should accept valid positive number");
	    assertEquals("5", vm.getMinimumLength().getValue(), "minimum length should be updated");
	    assertEquals("", vm.getErrorText().getValue(), "error text clears");
	}

	@Test
	void testIsValidMinimumLengthNonNumber() {
	    ViewModel vm = new ViewModel();
	    boolean result = vm.isValidMinimumLength("abc");

	    assertFalse(result, "should reject non number input");
	    assertEquals("Minimum length must be a positive whole number.", vm.getErrorText().getValue(), "error message should appear");
	}

	@Test
	void testIsValidMinimumLengthEmptyString() {
	    ViewModel vm = new ViewModel();
	    boolean result = vm.isValidMinimumLength("");

	    assertFalse(result, "should reject empty input");
	    assertEquals("Minimum length must be a positive whole number.", vm.getErrorText().getValue(), "error message should appear");
	}

	@Test
	void testIsValidMinimumLengthRejectsZero() {
	    ViewModel vm = new ViewModel();
	    boolean result = vm.isValidMinimumLength("0");

	    assertFalse(result, "should reject zero");
	    assertEquals("Minimum length must be at least 1.", vm.getErrorText().getValue(), "error message should appear");
	}

	@Test
	void testIsValidMinimumLengthNegativeNumber() {
	    ViewModel vm = new ViewModel();
	    boolean result = vm.isValidMinimumLength("-3");

	    assertFalse(result, "should reject negative number");
	    assertEquals("Minimum length must be a positive whole number.", vm.getErrorText().getValue(), "error message should appear");
	}

}

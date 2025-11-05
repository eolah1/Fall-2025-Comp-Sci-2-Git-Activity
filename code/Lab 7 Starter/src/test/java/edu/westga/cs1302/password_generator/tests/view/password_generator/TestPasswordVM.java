package edu.westga.cs1302.password_generator.tests.view.password_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.PasswordVM;

class TestPasswordVM {

	@Test
    void testWhenPasswordGeneratorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new PasswordVM(null));
    }

	@Test
	void testConstructorInitializesProperties() {
	    PasswordGenerator generator = new PasswordGenerator(12345L);
	    PasswordVM viewModel = new PasswordVM(generator);

	    assertEquals(generator.getMinimumLength(), viewModel.getMinimumLength().get());
	    assertEquals(generator.getMustHaveAtLeastOneDigit(), viewModel.getMustHaveAtLeastOneDigit().get());
	    assertEquals(generator.getMustHaveAtLeastOneUpperCaseLetter(), viewModel.getMustHaveAtLeastOneUpperCaseLetter().get());
	    assertEquals(generator.getMustHaveAtLeastOneLowerCaseLetter(), viewModel.getMustHaveAtLeastOneLowerCaseLetter().get());
	}
	
	@Test
    public void testMinimumLengthPropertyUpdatesModel() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMinimumLength().set(8);
        assertEquals(8, generator.getMinimumLength());
    }

    @Test
    public void testDigitRequirementProperty() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMustHaveAtLeastOneDigit().set(true);
        assertTrue(generator.getMustHaveAtLeastOneDigit());
    }

    @Test
    public void testUpperCaseRequirementProperty() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMustHaveAtLeastOneUpperCaseLetter().set(true);
        assertTrue(generator.getMustHaveAtLeastOneUpperCaseLetter());
    }

    @Test
    public void testLowerCaseRequirementProperty() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMustHaveAtLeastOneLowerCaseLetter().set(true);
        assertTrue(generator.getMustHaveAtLeastOneLowerCaseLetter());
    }

    @Test
    public void testGeneratePasswordUpdatesGeneratedPassProperty() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.generatePassword();
        String password = viewModel.getGeneratedPass().get();
        assertNotNull(password);
        assertFalse(password.isEmpty());
    }

    @Test
    public void testGeneratedPasswordMinimumLengthOrMore() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMinimumLength().set(8);
        viewModel.generatePassword();
        String password = viewModel.getGeneratedPass().get();
        assertTrue(password.length() >= 8);
    }

    @Test
    public void testGeneratedPasswordContainsDigit() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMinimumLength().set(10);
        viewModel.getMustHaveAtLeastOneDigit().set(true);
        viewModel.generatePassword();
        String password = viewModel.getGeneratedPass().get();
        assertTrue(password.matches(".*\\d.*"));
    }

    @Test
    public void testGeneratedPasswordContainsUpperCase() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMinimumLength().set(10);
        viewModel.getMustHaveAtLeastOneUpperCaseLetter().set(true);
        viewModel.generatePassword();
        String password = viewModel.getGeneratedPass().get();
        assertTrue(password.matches(".*[A-Z].*"));
    }

    @Test
    public void testGeneratedPasswordContainsLowerCase() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMinimumLength().set(10);
        viewModel.getMustHaveAtLeastOneLowerCaseLetter().set(true);
        viewModel.generatePassword();
        String password = viewModel.getGeneratedPass().get();
        assertTrue(password.matches(".*[a-z].*"));
    }

    @Test
    public void testGeneratedPasswordContainAllRequiredTypes() {
        PasswordGenerator generator = new PasswordGenerator(12345L);
        PasswordVM viewModel = new PasswordVM(generator);

        viewModel.getMinimumLength().set(12);
        viewModel.getMustHaveAtLeastOneDigit().set(true);
        viewModel.getMustHaveAtLeastOneUpperCaseLetter().set(true);
        viewModel.getMustHaveAtLeastOneLowerCaseLetter().set(true);
        viewModel.generatePassword();
        String password = viewModel.getGeneratedPass().get();

        assertTrue(password.matches(".*\\d.*"));
        assertTrue(password.matches(".*[A-Z].*"));
        assertTrue(password.matches(".*[a-z].*"));
    }

}

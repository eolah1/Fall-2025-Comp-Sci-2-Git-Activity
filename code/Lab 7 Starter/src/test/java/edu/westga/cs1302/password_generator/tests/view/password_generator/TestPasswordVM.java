package edu.westga.cs1302.password_generator.tests.view.password_generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import edu.westga.cs1302.password_generator.viewmodel.PasswordVM;

class TestPasswordVM {

	@Test
    void constructorShouldThrowExceptionIfPasswordGeneratorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new PasswordVM(null));
    }

	@Test
	void constructorShouldInitializePropertiesFromModel() {
	    PasswordGenerator generator = new PasswordGenerator(12345L);
	    PasswordVM viewModel = new PasswordVM(generator);

	    assertEquals(generator.getMinimumLength(), viewModel.getMinimumLength().get());
	    assertEquals(generator.getMustHaveAtLeastOneDigit(), viewModel.getMustHaveAtLeastOneDigit().get());
	    assertEquals(generator.getMustHaveAtLeastOneUpperCaseLetter(), viewModel.getMustHaveAtLeastOneUpperCaseLetter().get());
	    assertEquals(generator.getMustHaveAtLeastOneLowerCaseLetter(), viewModel.getMustHaveAtLeastOneLowerCaseLetter().get());
	}

}

package de.itemis.registerpage;

import de.itemis.registerpage.verification.PasswordVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CrazyFastUnitTests {

    public static final String VALID_PASSWORD = "0123456Lu";
    public static final String LESS_THAN_EIGHT_SYMBOLS = "0123456";
    public static final String NO_UPPER_CASE = "0123456ll";
    public static final String NO_LOWER_CASE = "0123456LL";
    public static final String NO_NUMBER = "LLLLLLLll";
    public static final String AT_LEAST_8_CHARACTERS_MESSAGE = "Password must have at least 8 characters";
    public static final String AT_LEAST_ONE_UPPER_CASE_CHARACTER_MSG = "Password must have at least one upper case character";
    public static final String AT_LEAST_ONE_LOWER_CASE_CHARACTER_MSG = "Password must have at least one lower case character";
    public static final String AT_LEAST_ONE_NUMBER_MSG = "Password must have at least one number";

    @Test
    void checkCorrectPassword() {
        Assertions.assertTrue(PasswordVerifier.verify(VALID_PASSWORD));
    }

    @Test
    void passwordShouldNotBeNull() {
        assertFalse(PasswordVerifier.verify(null));
    }

    @Test
    void passwordShouldBeLargerThan8Chars() {
        assertFalse(PasswordVerifier.verify(LESS_THAN_EIGHT_SYMBOLS));
    }

    @Test
    void passwordShouldAtLeastHaveOneUpperCase() {
        assertFalse(PasswordVerifier.verify(NO_UPPER_CASE));
    }

    @Test
    void passwordShouldAtLeastHaveOneLowerCase() {
        assertFalse(PasswordVerifier.verify(NO_LOWER_CASE));
    }

    @Test
    void passwordShouldHaveAtLeastOneNumber() {
        assertFalse(PasswordVerifier.verify(NO_NUMBER));
    }

    @Test
    void testVerifiedMessageForValidPassword() {
        assertEquals("Verified", PasswordVerifier.getVerficationString(VALID_PASSWORD));
    }

    @Test
    void testErrorMessageForPasswordWhichIsToShort() {
        assertEquals(AT_LEAST_8_CHARACTERS_MESSAGE, PasswordVerifier.getVerficationString(LESS_THAN_EIGHT_SYMBOLS));
    }

    @Test
    void testErrorMessageForPasswordWithoutUpperCase() {
        assertEquals(AT_LEAST_ONE_UPPER_CASE_CHARACTER_MSG, PasswordVerifier.getVerficationString(NO_UPPER_CASE));
    }

    @Test
    void testErrorMessageForPasswordWithoutLowerCase() {
        assertEquals(AT_LEAST_ONE_LOWER_CASE_CHARACTER_MSG, PasswordVerifier.getVerficationString(NO_LOWER_CASE));
    }

    @Test
    void testErrorMessageForPasswordWithoutANumber() {
        assertEquals(AT_LEAST_ONE_NUMBER_MSG, PasswordVerifier.getVerficationString(NO_NUMBER));
    }

    @Test
    void testErrorMessageForPasswordNull() {
        assertEquals("Password can not be null", PasswordVerifier.getVerficationString(null));
    }
}


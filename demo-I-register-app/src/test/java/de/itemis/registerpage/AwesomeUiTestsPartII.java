package de.itemis.registerpage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static de.itemis.registerpage.CrazyFastUnitTests.AT_LEAST_8_CHARACTERS_MESSAGE;
import static de.itemis.registerpage.CrazyFastUnitTests.AT_LEAST_ONE_LOWER_CASE_CHARACTER_MSG;
import static de.itemis.registerpage.CrazyFastUnitTests.AT_LEAST_ONE_NUMBER_MSG;
import static de.itemis.registerpage.CrazyFastUnitTests.AT_LEAST_ONE_UPPER_CASE_CHARACTER_MSG;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class AwesomeUiTestsPartII extends AbstractUiTest {


    @Test
    void pageShouldLoad() {
        assertThat(driver.getTitle()).contains("Register");
    }

    @Test
    void insertValidPassword() {
        insertUsernameAndPassword(USERNAME, CrazyFastUnitTests.VALID_PASSWORD);

        assertThat(getErrorMessage()).contains("Hello, " + USERNAME);
    }

    @Test
    void insertPasswordWhichIsTooShort() {
        insertUsernameAndPassword(USERNAME, CrazyFastUnitTests.LESS_THAN_EIGHT_SYMBOLS);

        assertThat(getErrorMessage()).contains(AT_LEAST_8_CHARACTERS_MESSAGE);
    }

    @Test
    void insertPasswordWhichHasNoNumber() {
        insertUsernameAndPassword(USERNAME, CrazyFastUnitTests.NO_NUMBER);

        assertThat(getErrorMessage()).contains(AT_LEAST_ONE_NUMBER_MSG);
    }

    @Test
    void insertPasswordWhichHasNoLowerCaseCharacter() {
        insertUsernameAndPassword(USERNAME, CrazyFastUnitTests.NO_LOWER_CASE);

        assertThat(getErrorMessage()).contains(AT_LEAST_ONE_LOWER_CASE_CHARACTER_MSG);
    }

    @Test
    void insertPasswordWhichHasNoUpperCaseCharacter() {
        insertUsernameAndPassword(USERNAME, CrazyFastUnitTests.NO_UPPER_CASE);

        assertThat(getErrorMessage()).contains(AT_LEAST_ONE_UPPER_CASE_CHARACTER_MSG);
    }









    public AwesomeUiTestsPartII(ChromeDriver driver) {
        super(driver);
    }
}

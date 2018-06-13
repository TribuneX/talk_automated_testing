package de.itemis.registerpage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static de.itemis.registerpage.CrazyFastUnitTests.AT_LEAST_8_CHARACTERS_MESSAGE;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class MinimalUiTests extends AbstractUiTest {

    public MinimalUiTests(ChromeDriver driver) {
        super(driver);
    }

    @Test
    void testRegisterPageLoads() {
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

}

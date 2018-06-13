package de.itemis.registerpage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class AwesomeUiTestsPartI extends AbstractUiTest {


    @Test
    void pageShouldLoad() {
        assertThat(driver.getTitle()).contains("Register");
    }

















    public AwesomeUiTestsPartI(ChromeDriver driver) {
        super(driver);
    }
}

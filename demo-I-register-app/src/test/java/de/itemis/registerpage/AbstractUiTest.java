package de.itemis.registerpage;

import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@ExtendWith(SeleniumExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class AbstractUiTest {

    @LocalServerPort
    int port;

    protected static final String USERNAME = "UserA";
    protected final String BASE_URL = "http://localhost:";
    protected ChromeDriver driver;

    public AbstractUiTest(ChromeDriver driver) {
        this.driver = driver;
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @BeforeEach
    void loadPage() {
        String url = BASE_URL + port + "/register";
        driver.get(url);
    }

    protected void insertUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement confirmPassword = driver.findElement(By.id("retypedPassword"));
        confirmPassword.clear();
        confirmPassword.sendKeys(password);
        confirmPassword.submit();
    }

    protected String getErrorMessage() {
        return driver.findElement(By.tagName("body")).getText();
    }
}

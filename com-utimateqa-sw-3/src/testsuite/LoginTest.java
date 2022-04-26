package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find login link and click on login Link
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        //requirement
        String expectedMessage = "Welcome Back!";
        //Find the Log out text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        //find element for login button and click
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        // Find and send the email field element
        sendTextToElement(By.id("user[email]"), "rashila13@gmail.com");
        // Find and send the password field element
        sendTextToElement(By.name("user[password]"), "Abc123");
        //find element for login button and click
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        //requirement
        String expectedMessage = "Invalid email or password.";
        //Find the Log out text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//li[@class='form-error__list-item']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

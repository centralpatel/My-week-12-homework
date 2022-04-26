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

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find and send the email field element
        sendTextToElement(By.id("username"), "tomsmith");
        // Find and send the password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword!");
        //find element for login button and click
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //requirement
        String expectedMessage = "Secure Area";
        //Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//div[@class='example']//h2"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Find and send the email field element
        sendTextToElement(By.id("username"), "tomsmith1");
        // Find and send the password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword!");
        //find element for login button and click
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //requirement
        String expectedMessage = "Your username is invalid!\n×";
        //Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.id("flash"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Find and send the email field element
        sendTextToElement(By.id("username"), "tomsmith");
        // Find and send the password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword");
        //find element for login button and click
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //requirement
        String expectedMessage = "Your password is invalid!\n×";
        //Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.id("flash"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);
    }

    @After

    public void tearDown() {
        closeBrowser();
    }
}

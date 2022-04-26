package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find login link and click on login Link
        clickOnElement(By.linkText("Log in"));
        //requirement
        String expectedMessage = "Welcome, Please Sign In!";
        // Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']"));
        // Validate actual and expected message
        Assert.assertEquals("Can not navigate to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find element for login button and click
        clickOnElement(By.linkText("Log in"));
        // Find and send the email field element
        sendTextToElement(By.id("Email"), "rashila8@gmail.com");
        // Find and send the password field element
        sendTextToElement(By.name("Password"), "Abc123!");
        //find element for login button and click
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        //requirement
        String expectedMessage = "Log out";
        //Find the Log out text element and get the text
        String actualErrorMessage = getTextFromElement(By.className("ico-logout"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //find element for login button
        clickOnElement(By.linkText("Log in"));
        // Find and send the email field element
        sendTextToElement(By.id("Email"), "rashila123@gmail.com");
        // Find and send the password field element
        sendTextToElement(By.id("Password"), "Abc123!");
        //find element for login button and click
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        //Requirement
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        //Find the message element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']\n"));
        // Validate actual and expected message
        //Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
        Assert.assertEquals("Error message not displayed", expectedErrorMessage,actualErrorMessage);

    }
    @After

    public void tearDown() {
        closeBrowser();
    }
}

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
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find and send Element of userName field
        sendTextToElement(By.xpath("//input[@type='text']"), "neha123456");
        //Find and send Element of Password field
        sendTextToElement(By.xpath("//input[@type='password']"), "Abc123!");
        //Find Login element and click on it
        clickOnElement(By.xpath("//input[@type='submit']"));
        //Requirement
        String expectedMessage = "Accounts Overview";
        //Find text element
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find and Send Element of Invalid userName field
        sendTextToElement(By.xpath("//input[@type='text']"), "neha54321");
        //Find and Send invalid password to Password field
        sendTextToElement(By.xpath("//input[@type='password']"), "123ABC!");
        //Find Login element and click on it
        clickOnElement(By.xpath("//input[@type='submit']"));
        //Requirement
        String expectedMessage = "The username and password could not be verified.";
        //Find text element
        String actualMessage = getTextFromElement(By.xpath("//p[@class='error']"));
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Find and send Element of userName field
        sendTextToElement(By.xpath("//input[@type='text']"), "neha123456");
        //Find and send Element of Password field
        sendTextToElement(By.xpath("//input[@type='password']"), "Abc123!");
        //Find Login element and click on it
        clickOnElement(By.xpath("//input[@type='submit']"));
        //Find Logout element and click on it
        clickOnElement(By.xpath("//a[@href='/parabank/logout.htm']"));
        //Requirement
        String expectedMessage = "Customer Login";
        //Find text element
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //Find Register link element and click on it
        clickOnElement(By.linkText("Register"));
        //requirement
        String expectedMessage = "Signing up is easy!";
        // Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));
        // Validate actual and expected message
        Assert.assertEquals("Can not navigate to login page", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Find Register link element and click on it
        clickOnElement(By.linkText("Register"));
        // Find and send Element of First Name
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"), "Neha");
        //Find and send Element of Last name field
        sendTextToElement(By.xpath("//input[@id='customer.lastName']"), "Patel");
        //Find and send Element of Address field
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "3 Wembley Road");
        //Find and send Element of City field
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"), "Wembley");
        //Find and send Element of State field
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "Middlesex");
        //Find and send Element of Zip Code field
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "HA0 2RG");
        //Find and send Element of Phone field
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"), "07852554569");
        //Find and send Element of SSN field
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"), "AA-12-34-56-B");
        //Find and send Element of userName field
        sendTextToElement(By.xpath("//input[@id='customer.username']"), "neha123456");
        //Find and send Element of Password field
        sendTextToElement(By.xpath("//input[@id='customer.password']"), "Abc123!");
        //Find and send Element of Confirm Password field
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "Abc123!");
        //Find Register link element and click on it
        clickOnElement(By.xpath("//input[@value='Register']"));
        //requirement
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        // Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        // Validate actual and expected message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

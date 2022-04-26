package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //Find Register link and click on login Link
        clickOnElement(By.linkText("Register"));
        //requirement
        String expectedMessage = "Register";
        // Find the Register text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Message : ", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Find register and click on register
        clickOnElement(By.linkText("Register"));
        //Select and click on gender button
        clickOnElement(By.cssSelector("input#gender-female"));
        // Find Element of First Name
        sendTextToElement(By.id("FirstName"), "Rashila");
        //Find Element of Last name field
        sendTextToElement(By.name("LastName"), "Patel");
        //Find Element of Day field
        sendTextToElement(By.name("DateOfBirthDay"), "13");
        //Find Element of Month field
        sendTextToElement(By.name("DateOfBirthMonth"), "June");
        //send Year of birth to Year field
        sendTextToElement(By.name("DateOfBirthYear"), "1985");
        //Find Element of Email field
        sendTextToElement(By.id("Email"), "rashila8@gmail.com");
        //Find Element of Password field
        sendTextToElement(By.id("Password"), "Abc123!");
        //Find Element of Confirm Password field
        sendTextToElement(By.id("ConfirmPassword"), "Abc123!");
        clickOnElement(By.id("register-button"));
        //requirement
        String expectedMessage = "Your registration completed";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Message : ", expectedMessage, actualMessage);
    }
    @After

    public void tearDown() {
        closeBrowser();
    }
}

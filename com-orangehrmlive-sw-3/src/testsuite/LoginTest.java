package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Find and send the email field element
        sendTextToElement(By.id("txtUsername"), "Admin");
        // Find and send the password field element
        sendTextToElement(By.id("txtPassword"), "admin123");
        //find element for login button and click
        clickOnElement(By.id("btnLogin"));
        //requirement
        String expectedMessage = "Welcome Paul";
        //Find the Log out text element and get the text
        String actualErrorMessage = getTextFromElement(By.partialLinkText("Welcome"));
        // Validate actual and expected message
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualErrorMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}

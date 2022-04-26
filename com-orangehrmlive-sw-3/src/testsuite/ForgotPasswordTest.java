package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //find element for forgot password button and click
        clickOnElement(By.linkText("Forgot your password?"));
        //requirement
        String expectedMessage = "Forgot Your Password?";
        //Find the Log out text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        // Validate actual and expected message
        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualErrorMessage);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}

package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        //Click on the “Shipping” link
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Shipping')]"));
        //requirement
        String expectedErrorMessage = "Shipping";
        // Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        //Click on the “New!” link
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'New!')]"));
        //requirement
        String expectedErrorMessage = "New arrivals";
        // Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        //Click on the “Coming soon” link
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Coming soon')]"));
        //requirement
        String expectedErrorMessage = "Coming soon";
        // Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        //Click on the “Contact us” link
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Contact us')]"));
        //requirement
        String expectedErrorMessage = "Contact us";
        // Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }
    @After

    public void tearDown() {
        closeBrowser();
    }
}

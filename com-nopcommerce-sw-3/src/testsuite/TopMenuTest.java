package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        // Find computer tab and click on computer tab
        clickOnElement(By.linkText("Computers"));
        //requirement
        String expectedMessage = "Computers";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Tab Name : ", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        // Find Electronics tab and click on Electronics tab
        clickOnElement(By.linkText("Electronics"));
        //requirement
        String expectedMessage = "Electronics";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.linkText("Electronics"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Tab Name : ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        // Find Apparel tab and click on Apparel tab
        clickOnElement(By.linkText("Apparel"));
        //requirement
        String expectedMessage = "Apparel";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.linkText("Apparel"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Tab Name : ", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        // Find Apparel tab and click on Apparel tab
        clickOnElement(By.linkText("Digital downloads"));
        //requirement
        String expectedMessage = "Digital downloads";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.linkText("Digital downloads"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Tab Name : ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        // Find Apparel tab and click on Apparel tab
        clickOnElement(By.linkText("Books"));
        //requirement
        String expectedMessage = "Books";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.linkText("Books"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Tab Name : ", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        // Find Apparel tab and click on Apparel tab
        clickOnElement(By.linkText("Jewelry"));
        //requirement
        String expectedMessage = "Jewelry";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.linkText("Jewelry"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Tab Name : ", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        // Find Apparel tab and click on Apparel tab
        clickOnElement(By.linkText("Gift Cards"));
        //requirement
        String expectedMessage = "Gift Cards";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.linkText("Gift Cards"));
        // Validate actual and expected message
        Assert.assertEquals("Can not Verify Tab Name : ", expectedMessage, actualMessage);
    }
    @After

    public void tearDown() {
        closeBrowser();
    }
}

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        // Find and send to the username field element
        sendTextToElement(By.id("user-name"), "standard_user");
        // Find and send the password field element
        sendTextToElement(By.name("password"), "secret_sauce");
        //find element for login button and click
        clickOnElement(By.id("login-button"));
        //requirement
        String expectedMessage = "PRODUCTS";
        //Find the text element and get the text
        String actualErrorMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedMessage, actualErrorMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Find and send to the username field element
        sendTextToElement(By.id("user-name"), "standard_user");
        // Find and send the password field element
        sendTextToElement(By.name("password"), "secret_sauce");
        //find element for login button and click
        clickOnElement(By.id("login-button"));
        //Find Element of products
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']\n"));
        //Print number of Items
        System.out.println("Items displayed : " + products.size());
        //to Count how many items
        for (WebElement element : products)
            Assert.assertEquals(true, element.isDisplayed());

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
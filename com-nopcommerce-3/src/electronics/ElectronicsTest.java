package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.Random;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified()throws InterruptedException{
        // 1.1 Mouse Hover on “Electronics”Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //mouseHoverOnly(By.xpath("Electronics"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        mouseClick(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        // mouseHoverOnly(By.xpath("Cell phones"));
        // 1.3 Verify the text “Cell phones”
        verifyText("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")), "Not Match");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(4000);
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        Thread.sleep(3000);
        mouseClick(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));
        //2.3 Verify the text “Cell phones”
        Thread.sleep(2000);
        verifyText("Cell phones", getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")), "Not Match");
        // 	2.4 Click on List View Tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //	2.5 Click on product name “Nokia Lumia 1020” link
        sendTextToElement(By.xpath("//div[@class='item-grid']//a[contains(text(),'Nokia Lumia 1020')]"), Keys.ENTER + "1");
        //clickOnElement(By.xpath("//div[@class='picture']//img[@title='Show details for Nokia Lumia 1020']"));
        //	2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(2000);
        verifyText("Nokia Lumia 1020",getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']")),"Not Match");
        //	2.7 Verify the price “$349.00”
        verifyText("$349.00",getTextFromElement(By.xpath("//span[contains(text(),' $349.00 ')]")),"Not match");
        //	2.8 Change quantity to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), Keys.BACK_SPACE + "2");
        //	2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //	2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("The product has been added to your shopping cart", getTextFromElement(By.xpath("//p[@class='content']")), "Invalid Message");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        //	2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[@class='cart-label']"));
        mouseClick(By.xpath("//span[@class='cart-label']"));
        //	2.12 Verify the message "Shopping cart"
        verifyText("Shopping cart", getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']")), "Invalid Message");
        //	2.13 Verify the quantity is 2
        Thread.sleep(2000);
        verifyText("(2)", getTextFromElement(By.xpath("//span[contains(text(),'(2)')]")), "Incorrect Quantity");
        //2.14 Verify the Total $698.00
        verifyText("$698.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']")), "Incorrect Amount");
        //2.15 click on checkbox “I agree with the terms of service”
        setCheckBoxElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //“2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")), "Error Message");
        // 	2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //	2.19 Verify the text “Register”
        verifyText("Register", getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")), "Error Message");
        //	2.20 Fill the mandatory fields
        //clickOnElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Rosie");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Cross");
        sendTextToElement(By.xpath("//input[@id='Email']"), "rose14@gmail.com");
        sendTextToElement(By.id("Password"), "Cross123");
        sendTextToElement(By.id("ConfirmPassword"), "Cross123");
        //	2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //	2.22 Verify the message “Your registration completed”
        verifyText("Your registration completed", getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")), "Invalid Message");
        //	2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //	2.24 Verify the text “Shopping cart”
        verifyText("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Invalid Message");
        //	2.25 click on checkbox “I agree with the terms of service”
        setCheckBoxElement(By.xpath("//input[@id='termsofservice']"));
        //	2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //	2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Wembley");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1 Shefton Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA0 3RW");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07758481254");
        //	2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //	2.29 Click on Radio Button “2nd Day Air ($0.00)”
        setRadioElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        setRadioElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.32 Select “Visa” From Select credit card dropdown
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='CreditCardType'])[1]"), "Visa");
        Thread.sleep(2000);
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Rosie Cross");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111 2222 3333 4444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "321");
        //2.34 Click on “CONTINUE”CHECKOUT”
       clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(2000);
        verifyText("Credit Card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")), "Invalid Payment Method");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(2000);
        verifyText("2nd Day Air", getTextFromElement(By.xpath("//span[contains(.,'2nd Day Air')]")), "Invalid Shipping Method");
        //	2.37 Verify Total is “$698.00”
        Thread.sleep(4000);
        verifyText("$698.00", getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]")), "Incorrect Total");
        //	2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //	2.39 Verify the Text “Thank You”
        Thread.sleep(3000);
        verifyText("Thank you", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")), "Invalid Message");
       // verifyText("Thank You", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")), "Invalid Message");
        //	2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(2000);
        verifyText("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")), "Invalid Message");
        //	2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")), "Invalid Message");
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");

    }
    @After

    public void tearDown() {
        closeBrowser();
    }
}

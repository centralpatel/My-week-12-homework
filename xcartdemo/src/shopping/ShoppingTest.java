package shopping;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //1.2 Mouse hover on the “Bestsellers”  link and click
        Thread.sleep(2000);
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        //1.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", "Bestsellers", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseClick(By.xpath("//a[@data-sort-by='translations.name' and @data-sort-order='asc']\n"));
        verifyText("Name A - Z", "Name A - Z", "Not in alphabetical order");
        getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]"));
        //1.5 Click on “Add to cart” button of the product “Ollie - The App ControlledRobot"
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-42']"));
        //clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[2]/div[4]/div[1]/button[1]/span[1]"));
        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        verifyText("Product has been added to your cart","Product has been added to your cart","Not Match");
        getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[5]/div[4]/div[1]"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        //  clickOnElement(By.xpath("//div[@title='Your cart']"));
        //1.9 Verify the text “Your shopping cart - 1 item”
        verifyText("Your shopping cart - 1 items","Your shopping cart - 1 items","Not Match");
        getTextFromElement(By.xpath("//h1[@class='title']"));
        //1.10 Verify the Subtotal $299.00
        verifyText("$299.00","$299.00","Not Match");
        getTextFromElement(By.xpath("//a[@class='regular-main-button checkout']"));
        //1.11 Verify the total $311.03
        verifyText("$310.74","$310.74","Not Match");
        getTextFromElement(By.xpath("//li[@class='total']"));
        // 1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button checkout']"));
        //1.13 Verify the text “Log in to your account”
        verifyText("Log in to your account","Log in to your account","Not Match");
        getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        //1.14 Enter Email address
        sendTextToElement(By.xpath("//input[@id='email']"),"rasi123455@gmail.com");
        //1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));
        //1.16 Verify the text “Secure Checkout”
        verifyText("Secure Checkout","Secure Checkout","Not Match");
        getTextFromElement(By.xpath("//h1[@class='title']"));
        //1.17 Fill all the mandatory fields
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"),"Rasi");//Firstname
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"),"Patel");//Lastname
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"),"4 Elms Park Avenue");//address
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"),"Wembley");//city
        sendTextToElement(By.xpath("//select[@id='shippingaddress-country-code']"),"United Kingdon");//country
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"),"Middlesex");//state
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"),"HA0 2RS");//90001
        sendTextToElement(By.xpath("//input[@id='email']"),"");//email
        //Check the check box “Create an account for later use”
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        //Enter the password
        sendTextToElement(By.xpath("//input[@id='password']"), "Abc123!");
        //1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.xpath("//input[@id='method128']"));
        //1.21 Select Payment Method “COD”
        clickOnElement(By.xpath("//input[@id='pmethod6']"));
        //1.22 Verify the total $99.00
        verifyText("$311.03","$311.03","Not Match");
        getTextFromElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]"));
        //1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));
        //1.24 Verify the text “Thank you for your order”
        verifyText("Thank you for your order","Thank you for your order","Not Match");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException{
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //1.2 Mouse hover on the “Bestsellers”  link and click
        Thread.sleep(2000);
        mouseHover(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        //1.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", "Bestsellers", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        Thread.sleep(2000);
        mouseClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        //1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[9]/div[1]/div[2]/div[4]/div[1]/button[1]"));
        Thread.sleep(2000);
        verifyText("Product has been added to your cart","Product has been added to your cart","Not Match");
        getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        //1.9 Verify the text “Your shopping cart - 1 item”
        verifyText("Your shopping cart - 1 items","Your shopping cart - 1 items","Not Match");
        getTextFromElement(By.xpath("//h1[@class='title']"));
        //1.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        switchToAlert();
        String expectedAlertMessage = "Are you sure you want to clear your cart?";
        String actualAlertMessage = getTextAlert();
        Assert.assertEquals("Not valid message", expectedAlertMessage, actualAlertMessage);
        //1.12 Click “Ok” on alert
        acceptAlert();
        //1.13 Verify the message “Item(s) deleted from your cart”
        verifyText("Item(s) deleted from your cart","Item(s) deleted from your cart","Not Match");
        getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        //1.15 Verify the text “Your cart is empty”
        verifyText("Your cart is empty","Your cart is empty","Not Match");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully1() throws InterruptedException{
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));
        //1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        //1.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", "Bestsellers", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseClick(By.xpath("//a[@data-sort-by='translations.name' and @data-sort-order='asc']\n"));
        //1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        scrolldown(By.xpath("//div[@class='product productid-13 ']"));
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
        verifyText("Product has been added to your cart","Product has been added to your cart","Not Match");
        getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        //1.9 Verify the text “Your shopping cart - 1 item”
        verifyText("Your shopping cart - 1 items","Your shopping cart - 1 items","Not Match");
        getTextFromElement(By.xpath("//h1[@class='title']"));
        //1.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        //1.12 Click “Ok” on alert
        acceptAlert();
        //1.13 Verify the message “Item(s) deleted from your cart”
        verifyText("Item(s) deleted from your cart","Item(s) deleted from your cart","Not Match");
        getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        //1.15 Verify the text “Your cart is empty”
        verifyText("Your cart is empty","Your cart is empty","Not Match");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }

    @After

    public void tearDown() {
        closeBrowser();
    }
}

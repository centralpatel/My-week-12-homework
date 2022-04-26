package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.awt.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void Testname () {
        //1.1 Click on Computer Menu
        clickOnElement(By.linkText("Computers"));
        //1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //	1.4 Verify the Product will arrange in Descending order.
        listDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        //2.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //mouse hover
        //2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"), Keys.ENTER + "1");
        //2.5 Verify the Text "Build your own computer"
        verifyText("Build your own computer", By.xpath("//h1[normalize-space()='Build your own computer']"), "Build your own computer");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_1']"), 1);
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"), 3);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        setRadioElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        setRadioElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        setCheckBoxElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        verifyText("$1,475.00", getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]")), "Price does not match!");
        //2.12 Click on "ADD TO CART" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("The product has been added to your shopping cart", getTextFromElement(By.xpath("//div[@class='bar-notification success']")), "Incorrect Message");
        clickOnElement(By.className("close"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//a[@class='ico-cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]\n"));
        //2.15 Verify the message "Shopping cart"
        verifyText("Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Incorrect Message");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        sendTextToElement(By.xpath("(//input[contains(@id, 'itemquantity')])"), Keys.BACK_SPACE + "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //2.17 Verify the Total"$2,950.00"
        verifyText("$2,950.00", getTextFromElement(By.xpath("//span[@class='product-subtotal']")), "Price does not match");
        //2.18 click on checkbox “I agree with the terms of service”
        setCheckBoxElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")), "Error Message");
        // 2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Naina");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"Nai123@gmail.com");
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Wembley");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"91 Westend Avenue");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA0 2RN");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07736365421");
        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        setRadioElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        setRadioElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Naina Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 5454 8787 9878");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "322");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']")), "Incorrect payment method");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Next Day Air", getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']")), "Incorrect Shipping method");
        //2.33 Verify Total is “$2,950.00”
        verifyText("$2,950.00", getTextFromElement(By.xpath("(//strong[contains(text(),'$2,950.00')])[2]")), "Error Message");
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        //2.35 Verify the Text “Thank You”
        verifyText("Thank you", getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']")), "Incorrect Message");
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")), "Incorrect Message");
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")), "Incorrect page");
    }
    @After

    public void tearDown() {
        closeBrowser();
    }
}

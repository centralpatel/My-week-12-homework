package utilities;



import browsertesting.BaseTest;
import com.beust.jcommander.internal.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class Utility extends BaseTest {
    /**
     * *This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    /**
     * *This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    /**
     * *This method will send text element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    //***************************************  Alerts Methods ****************************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }

    /**
     * This method will accept the alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    // This method is for get text from Alerts
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }
    //*************************** Select class methods **************************************//
    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void sortBy (By by, String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int indexNo) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNo);
    }

    public void mouseClickOnly(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseClickOnly = driver.findElement(by);
        actions.moveToElement(mouseClickOnly).click().build().perform();
    }
        public void mouseHoverOnly(By by){
            Actions actions = new Actions(driver);
            WebElement mouseHoverOnly = driver.findElement(by);
            actions.moveToElement(mouseHoverOnly).build().perform();
    }

    public void verifyText(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }
    public void verifyText(By by,String text){
        String expectedMessage = text;
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals("Not matched with original text",expectedMessage,actualMessage);
    }
    public void mouseClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    public void mouseHover(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).build().perform();
    }

    public void scrolldown (By by) throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement mouseScrollDown = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseScrollDown).build().perform();
    }
    public void scrollup (By by) throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement mouseScrollDown = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseScrollDown).build().perform();
    }


}

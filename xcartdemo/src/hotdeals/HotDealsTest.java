package hotdeals;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.sql.Driver;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
        //Mouse hover on the “Sale”  link and click
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
        clickOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
        //Verify the text “Sale”
        //verifyText("Sale", "Sale", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        verifyText(By.xpath("//span[contains(text(),'Name A - Z')]"), "Sale");
        //Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        //Verify that the product arrange alphabetically
        verifyText("Name A - Z", "Name A - Z", "Not in alphabetical order");
        getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]"));

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
        //Mouse hover on the “Sale”  link and click
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]\n"));
        mouseClick(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
        //Verify the text “Sale”
        verifyText("Sale", "Sale", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //Mouse hover on “Sort By” and select “Price Low-High”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseClick(By.xpath("//a[normalize-space()='Price Low - High']"));
        //Verify that the product’s price arrange Low to High
        verifyText("Price Low - High", "Price Low - High", "Not in descending order");
        getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')]"));
    }
    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
        //Mouse hover on the “Sale”  link and click
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
        mouseClick(By.xpath("//div[@id='header-area']//span[contains(text(),'Sale')]"));
        //Verify the text “Sale”
        verifyText("Sale", "Sale", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //Mouse hover on “Sort By” and select “Rates”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseClick(By.xpath("//a[normalize-space()='Rates']"));
        //Verify that the product’s price arrange Low to High
        verifyText("Rates", "Rates", "Not in order");
        getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
        //Mouse hover on the “Bestsellers”  link and click
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        mouseClick(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        //Verify the text “Bestsellers”
        verifyText("Bestsellers", "Bestsellers", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //Mouse hover on “Sort By” and select “Name Z-A”
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseClick(By.xpath("//a[@data-sort-by='translations.name' and @data-sort-order='desc']"));
        // Verify that the product arrange by Z to A
        verifyText("Name Z-A", "Name Z-A", "Not in order");
        getTextFromElement(By.xpath("//a[@data-sort-by='translations.name' and @data-sort-order='desc']"));
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
        //Mouse hover on the “Bestsellers”  link and click
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        mouseClick(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        //Verify the text “Bestsellers”
        verifyText("Bestsellers", "Bestsellers", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //Mouse hover on “Sort By” and select “Price High-Low”
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseClick(By.xpath("//a[@data-sort-by='p.price' and @data-sort-order='desc']"));
        // Verify that the product arrange by Price High-Low
        verifyText("Price High-Low", "Price High-Low", "Not in order");
        getTextFromElement(By.xpath("//a[@data-sort-by='p.price' and @data-sort-order='desc']"));
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
        //Mouse hover on the “Bestsellers”  link and click
        mouseHover(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        mouseClick(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        //Verify the text “Bestsellers”
        verifyText("Bestsellers", "Bestsellers", "Text not Verified");
        getTextFromElement(By.xpath("//h1[@id='page-title']"));
        //Mouse hover on “Sort By” and select “Rates”
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseClick(By.xpath("//a[@data-sort-by='r.rating' and @data-sort-order='asc']"));
        // Verify that the product arrange by Rates
        verifyText("Rates", "Rates", "Not in order");
        getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));
    }

    @After

    public void tearDown() {
        closeBrowser();
    }
}

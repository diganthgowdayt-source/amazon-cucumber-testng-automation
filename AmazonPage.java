package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

public class AmazonPage {

    WebDriver driver;
    WebDriverWait wait;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchBox = By.id("twotabsearchtextbox");
    By firstResult = By.xpath("(//div[@data-component-type='s-search-result']//h2/a)[1]");
    By addToCartBtn = By.id("add-to-cart-button");

    public void searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox))
                .sendKeys(product + Keys.ENTER);
    }

    public void clickFirstResult() {
        wait.until(ExpectedConditions.elementToBeClickable(firstResult)).click();
    }

    public void validateAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        System.out.println("Add to Cart button is displayed.");
    }

    public void takeScreenshot() {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("screenshots/product_page.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

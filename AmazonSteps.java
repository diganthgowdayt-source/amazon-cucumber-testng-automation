package stepdefinitions;

import io.cucumber.java.en.*;
import pages.AmazonPage;
import utils.DriverFactory;

public class AmazonSteps {

    AmazonPage amazonPage = new AmazonPage(DriverFactory.getDriver());

    @Given("user is on Amazon homepage")
    public void open_homepage() {
        DriverFactory.getDriver().get("https://www.amazon.com");
    }

    @When("user searches for {string}")
    public void search_product(String product) {
        amazonPage.searchProduct(product);
    }

    @When("user clicks on first search result")
    public void click_first_result() {
        amazonPage.clickFirstResult();
    }

    @Then("product details page should be displayed")
    public void validate_product_page() {
        amazonPage.validateAddToCart();
        amazonPage.takeScreenshot();
    }
}

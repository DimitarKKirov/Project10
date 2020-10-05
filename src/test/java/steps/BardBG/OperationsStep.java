package steps.BardBG;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import masterManager.MasterPageManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.BardBG.BardBG;

public class OperationsStep {

    BardBG bardBG;
    String searchCriteria;
    String totalPriceOld;

    @Given("the user is on {string}")
    public void openPage(String link) {
        bardBG= MasterPageManager.getMasterManager().bardBG();
        bardBG.startBrowser(link,"chrome");
    }

    @When("the user enters search for {string} in the search field")
    public void usingSearchFunction(String criteria) {
        searchCriteria=criteria;
        bardBG.search(criteria);
    }

    @When("clicks on the search button")
    public void searchButtonClick() {
        bardBG.pressSearchButton();
    }

    @When("the user is presented with the search result")
    public void verifyResult() {
       WebElement result= bardBG.getResultOfSearch(searchCriteria);
       String titleOfResult = result.getText();
        Assert.assertEquals(searchCriteria,titleOfResult);

    }

    @Then("the user adds the item in favorites")
    public void addToFavorites() {
        bardBG.addResultToFavorites();
        bardBG.quitBrowser();
    }

    @When("the user clicks on order")
    public void makeOrder() {
        bardBG.order();
    }

    @Then("the book is added to My Orders")
    public void checkForOrderInCart() {
        bardBG.openShoppingCart();
        WebElement bookName = bardBG.getAllOrdersFromCart(searchCriteria);
        String name = bookName.getText();
        Assert.assertTrue(name,true);
        bardBG.quitBrowser();
    }
    @When("opens Shopping cart")
    public void goToCart() {
        bardBG.openShoppingCart();
    }

    @When("the user rise the quantity of the item to be bought with {string}")
    public void riseNumberOfItems(String numberOfItems) {
       bardBG.quantityField(numberOfItems);
    }

    @When("the user clicks the recalculating button")
    public void recalculatePrice() {
       totalPriceOld = bardBG.getTotalPriceOfCart();
       bardBG.reCalculateButton();

    }

    @Then("the price of the item is update")
    public void checkNewTotalPrice() {
        String newPrice=bardBG.getTotalPriceOfCart();
        Assert.assertNotEquals(totalPriceOld,newPrice);
        bardBG.quitBrowser();
    }
    @When("the user changes the quantity of items to {string}")
    public void changeQuantity(String items) {
        bardBG.quantityField(items);
        bardBG.reCalculateButton();

    }

    @When("the user meats the requirement for {string} level treasure points")
    public void discountLevelApplied(String level) {
       WebElement discount = bardBG.findElementByXpath("//div[@class=\"discount-level-inner\"]");
      String text = discount.getText();
      Assert.assertTrue(text.contains(level));
    }

    @Then("the user will receive {string} from the total amount to his treasure wallet")
    public void discountApplied(String percent) {
        WebElement discount = bardBG.findElementByXpath("//div[@class=\"discount-level-inner\"]");
        String text = discount.getText();
        Assert.assertTrue(text.contains(percent));
        bardBG.quitBrowser();

    }

}

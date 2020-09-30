package steps.emagSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import masterManager.MasterPageManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.eMagPages.SearchInEmag;

public class SearchSteps {

    SearchInEmag emag;

    @Given("the user is on in {string}")
    public void openEmag(String link) {
        SearchInEmag emag = MasterPageManager.getMasterManager().eMagPageManager().searchInEmag();
        emag.startBrowser(link, "chrome");
        emag.createWait(2).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"btn btn-primary js-accept gtm_h76e8zjgoo col-xs-7 col-sm-6\"]")));
        emag.findElementByXpath("//button[@class=\"btn btn-primary js-accept gtm_h76e8zjgoo col-xs-7 col-sm-6\"]").click();
    }

    @When("user enters search criteria {string}")
    public void useSearchField(String searchArg) {
        emag = MasterPageManager.getMasterManager().eMagPageManager().searchInEmag();
        emag.enterInSearchField(searchArg);
        emag.clickSearch();

    }

    @Then("the user can see the results {string}")
    public void checkTheResult(String name) {
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title=\"" + name + "\"]")));
        WebElement funko = emag.findElementByXpath("//a[@title=\"" + name + "\"]");
        funko.click();
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"product-code-display pull-left\"]")));
        String funkoID = emag.findElementByXpath("//span[@class=\"product-code-display pull-left\"]").getText();

        Assert.assertEquals("Код на продукта: FK5891", funkoID);
        emag.quitBrowser();

    }

    @When("click on {string}")
    public void clickCategory(String categoryName) {
        emag.createWait(4).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt=\"" + categoryName + "\"]")));
        emag.createWait(5).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt=\"" + categoryName + "\"]")));
        WebElement leftCategory = emag.findElementByXpath("//img[@alt=\"" + categoryName + "\"]");
        leftCategory.click();
    }

    @When("find and open {string}")
    public void findAndOpenTheCorespondingItem(String nameOfItem) {
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@title,\"" + nameOfItem + "\")]")));
        WebElement item = emag.findSearchResult(nameOfItem);
        emag.createWait(7).until(ExpectedConditions.elementToBeClickable(item));
        emag.createAction().moveToElement(item).moveByOffset(15, 15);
        item.click();
    }

    @Then("add the funko figure {string} to favorite")
    public void addItemToFavorites(String name) {
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"add-to-favorites btn btn-xl btn-default btn-icon btn-block gtm_t95ovv\"]")));
        emag.createWait(5).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"add-to-favorites btn btn-xl btn-default btn-icon btn-block gtm_t95ovv\"]")));
        emag.addToFavorites();
        emag.openFavorites();
        String nameFigure = emag.itemsInFavorites(name).getText();
        Assert.assertEquals(name, nameFigure);
        emag.quitBrowser();

    }

    @When("choose one item and opens its view page")
    public void randomItemClickInTheList() {
        emag.createWait(5).until(ExpectedConditions.titleIs("Търсене на: \"cougar\" в категория Компютърни кутии - eMAG.bg"));
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"card-item js-product-data\"]")));
        emag.getListResultsAndClickRandomOneFromPCBox();
    }

    @When("add the item to the favorites list")
    public void addTheItemToTheFavoritesList() {
        emag.addToFavorites();
    }

    @When("opens the favorites list")
    public void goToFavoritesList() {
        emag.openFavorites();
    }

    @Then("the users adds the item to the basket")
    public void the_users_adds_the_item_to_the_basket() {
        emag.addItemToBasket().click();
        emag.createWait(5).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class=\"em em-cart2 navbar-icon\"]")));
        emag.openCart();
        Assert.assertEquals("Количка за пазаруване - eMAG.bg", emag.getPageTitle());
    }
}

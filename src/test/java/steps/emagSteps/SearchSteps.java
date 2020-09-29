package steps.emagSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import masterManager.MasterPageManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjectsEMag.eMagPages.SearchInEmag;

import java.util.Timer;

public class SearchSteps {

    SearchInEmag emag;

    @When("user enters search criteria {string}")
    public void useSearchField(String searchArg) {
        emag = MasterPageManager.getMasterManager().eMagPageManager().searchInEmag();
        emag.enterInSearchField(searchArg);
        emag.clickSearch();

    }

    @Then("the user can see the results")
    public void checkTheResult() {
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title=\"Колекционерска Фигурка Funko Pop Хари Потър Harry Potter Quiddich Размер 10см\"]")));
        WebElement funko = emag.findElementByXpath("//a[@title=\"Колекционерска Фигурка Funko Pop Хари Потър Harry Potter Quiddich Размер 10см\"]");
        funko.click();
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"product-code-display pull-left\"]")));
        String funkoID = emag.findElementByXpath("//span[@class=\"product-code-display pull-left\"]").getText();

        Assert.assertEquals("Код на продукта: HGA2374", funkoID);
        emag.quitBrowser();

    }

    @When("click on {string}")
    public void clickCategory(String categoryName) {
        emag.createWait(4).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt=\"" + categoryName + "\"]")));
        WebElement leftCategory = emag.findElementByXpath("//img[@alt=\"" + categoryName + "\"]");
        emag.createAction().moveToElement(leftCategory).click();
    }

    @When("find and open {string}")
    public void find_and_open(String nameOfItem) {
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@title,\"" + nameOfItem + "\")]")));
        WebElement item = emag.findSearchResult(nameOfItem);
        emag.scrollPageBySetPixels("5000");
        emag.createWait(7).until(ExpectedConditions.elementToBeClickable(item));
        emag.createAction().moveToElement(item).moveByOffset(15,15);
        item.click();
    }

    @Then("add the funko figure {string} to favorite")
    public void add_the_funko_figure_to_favorite(String name) {
        emag.createWait(3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"add-to-favorites btn btn-xl btn-default btn-icon btn-block gtm_t95ovv\"]")));
        emag.addToFavorites();
        emag.openFavorites();
        String nameFigure = emag.itemsInFavorites(name).getText();
        Assert.assertEquals(name, nameFigure);
        emag.quitBrowser();

    }
}

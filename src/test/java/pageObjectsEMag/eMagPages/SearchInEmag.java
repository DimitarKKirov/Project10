package pageObjectsEMag.eMagPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SearchInEmag extends EmagRegularElements {


    //locating,enabling and using the search field
    public void enterInSearchField(String search) {
        WebElement searchField = driver.findElement(By.xpath("//input[@id=\"searchboxTrigger\"]"));
        searchField.click();
        searchField.sendKeys(search);
    }

    //locating and clicking the search button (looks like a magnifying glass)
    public void clickSearch() {
        WebElement searchButton = driver.findElement(By.xpath("//i[@class=\"em em-search\"]"));
        searchButton.click();
    }

    public WebElement findSearchResult(String name) {

        return driver.findElement(By.xpath("//div[@data-name=\"" + name + "\"]"));

    }

    public void addToFavorites() {

        WebElement favorites = driver.findElement(By.xpath("//button[@class=\"add-to-favorites btn btn-xl btn-default btn-icon btn-block gtm_t95ovv\"]"));
        favorites.click();
    }




}

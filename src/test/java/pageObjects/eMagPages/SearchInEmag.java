package pageObjects.eMagPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


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

    //returning the web element found by its exact name
    //name must be passed as an argument, fot example Фигура Funko - Harry Potter - Dumbledore with Wand POP! Movies
    public WebElement findSearchResult(String name) {

        return driver.findElement(By.xpath("//div[@data-name=\"" + name + "\"]"));

    }

    public void addToFavorites() {

        WebElement favorites = driver.findElement(By.xpath("//i[@class=\"em em-fav gtm_t95ovv\"]"));
        favorites.click();
    }


}

package pageObjects.BardBG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BardBG extends BardRegularElements {

    public void search(String input) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(input);
    }

    public void pressSearchButton() {
        driver.findElement(By.className("submit")).click();
    }

    public void addResultToFavorites() {
        driver.findElement(By.xpath("//a[@href=\"/wishlist/\"]")).click();
    }

    public WebElement getResultOfSearch(String criteria) {
        return driver.findElement(By.xpath("//h1[text()=\"" + criteria + "\"]"));
    }

    public void order(){
        driver.findElement(By.xpath("//a[@class=\"btn-order\"]")).click();
    }
    public void openShoppingCart(){
        driver.findElement(By.xpath("//a[@href=\"/shopping-cart/\"]")).click();
    }

    public WebElement getAllOrdersFromCart(String itemName){

      List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class=\"book\"]"));

        for (WebElement book:cartItems) {
            if (book.getText().contains(itemName)){
                return book;
            }

        }return null;
    }
    public void quantityField(String number){
      WebElement quantityField =  driver.findElement(By.xpath("//input[@name=\"quantity[bvar2947]\"]"));
      quantityField.click();
      quantityField.sendKeys(number);
    }

    public void reCalculateButton(){
        driver.findElement(By.xpath("//a[@class=\"bardbutton bardbutton_gold quantity-update\"]")).click();
    }
    public String getTotalPriceOfCart(){
       return driver.findElement(By.xpath("//td[@class=\"price totalprice\"]")).getText();
    }
}

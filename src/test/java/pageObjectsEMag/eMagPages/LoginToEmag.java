package pageObjectsEMag.eMagPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

 public class LoginToEmag extends EmagRegularElements {


    //navigating and clicking the user icon in order to go to login page
    public void login() {
        Actions action = new Actions(driver);
        WebElement userIcon = driver.findElement(By.xpath("//i[@class=\"em em-user2 navbar-icon\"]"));
        action.moveToElement(userIcon).build().perform();
        userIcon.click();
    }

    //navigating to the email field activating and typing the email
    public void enterEmail(String email) {
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id=\"user_login_email\"]"));
        userEmailField.click();
        userEmailField.sendKeys(email);
    }

    //finding the and clicking the continue button
    public void clickContinue() {
        WebElement continueButton = driver.findElement(By.xpath("//button[@id=\"user_login_continue\"]"));
        continueButton.click();
    }

    //finding password field and entering the given password
    public void enterPass(String pass) {
        WebElement passField = driver.findElement(By.xpath("//input[@name=\"user_login[password]\"]"));
        passField.click();
        passField.sendKeys(pass);
    }
}

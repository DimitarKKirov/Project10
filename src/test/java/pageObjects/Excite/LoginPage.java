package pageObjects.Excite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends ExciteRegularElements {



    @FindBy(how = How.LINK_TEXT, using = "Click here to access your email.")
    WebElement accessEmailPage;
    @FindBy(how = How.LINK_TEXT, using = "need an account?")
    WebElement accountRegistration;
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(name = "Login")
    WebElement loginButton;
    @FindBy(how = How.CLASS_NAME, using = "msg")
    WebElement invalidCredentialsMSG;


    public void goToEmailPage() {
        accessEmailPage.click();
    }

    public void goToRegistration() {
        accountRegistration.click();
    }

    public void enterUsernameLogin(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void enterPasswordLogin(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.name("Login")).click();
    }

    public String findInvalidCredentialsMSG() {
        return driver.findElement(By.className("msg")).getText();
    }

}
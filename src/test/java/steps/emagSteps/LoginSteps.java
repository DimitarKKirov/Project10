package steps.emagSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import masterManager.MasterPageManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.eMagPages.LoginToEmag;

public class LoginSteps {
    LoginToEmag login;

    @Given("clicks on user icon located on the navigational bar")
    public void enterLoginPage() {
        login = MasterPageManager.getMasterManager()
                .eMagPageManager()
                .loginToEmag();

        login.login();
    }

    @When("the user is redirected to the login page of EMag")
    public void confirmLoginPage() {
        login.createWait(5).until(ExpectedConditions.presenceOfElementLocated(By.id("user_login_email")));

    }

    @When("enter his {string}")
    public void enterEmail(String email) {
        login.enterEmail(email);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("something went wrong");
        }
    }

    @When("clicks on continue button")
    public void clicksContinue() {
        login.clickContinue();
    }

    @When("enters the necessary {string}")
    public void enterPassword(String pass) {
        System.out.println("Please pass Captcha");
        login.createWait(300).until(ExpectedConditions.presenceOfElementLocated(By.id("user_login_password")));
        login.enterPass(pass);
    }

    @Then("the user is logged in EMag webShop")
    public void confirmLogIn() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.clickContinue();
        System.out.println("Please pass Captcha");
        login.createWait(300).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class=\"cookie-banner-text mrg-btm-none\"]")));
        login.saveCookies();
    }
}

package steps.ExciteStepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import masterManager.MasterPageManager;
import org.junit.Assert;
import pageObjects.Excite.RegistrationPage;

//import static Browsers.BrowserDrivers.startBrowser;

public class ExciteEmailRegistrationPage {


   private RegistrationPage registration;

    @Given("user is on registration page")
    public void registrationPage() {

       registration= MasterPageManager.getMasterManager().pageManagerExcite().registrationPage();
       registration.startBrowser("https://registration.excite.com/", "headless");

    }

    @When("user enters the necessary data in all fields")
    public void fillingTheFields(){
        registration.fieldsInput("Dimitar", "Kirov", "1/11/2000", "08956564321", "my@email.com", "Mladost 1", "none",
                "Sofia", "Sofia", "1000", "Bulgaria", "Dkk", "12345Ww", "12345Ww");

    }

    @When("user clicks complete registration")
    public void completeRegistration() {
        registration.completeRegButtonClick();
    }

    @Then("the user is redirected to the login page")
    public void loginPageLading() {
        String s = String.valueOf(registration.findElementByXpath("//input[@id=\"signup_button\"]").isEnabled());
        Assert.assertEquals("false", s);
        registration.quitBrowser();
    }
}

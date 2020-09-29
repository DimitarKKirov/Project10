package steps.emagSteps;

import io.cucumber.java.en.Given;
import masterManager.MasterPageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjectsEMag.eMagPages.LoginToEmag;

public class RepeatableSteps {

    @Given("the user is on in {string}")
    public void openEmag(String link) {
        LoginToEmag emag = MasterPageManager.getMasterManager().eMagPageManager().loginToEmag();
        emag.startBrowser(link, "chrome");
        emag.createWait(2).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"btn btn-primary js-accept gtm_h76e8zjgoo col-xs-7 col-sm-6\"]")));
        emag.findElementByXpath("//button[@class=\"btn btn-primary js-accept gtm_h76e8zjgoo col-xs-7 col-sm-6\"]").click();
    }
}

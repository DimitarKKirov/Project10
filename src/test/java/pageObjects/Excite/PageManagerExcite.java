package pageObjects.Excite;

import org.openqa.selenium.WebDriver;

public class PageManagerExcite {


    private LoginPage loginPage;
    private RegistrationPage registrationPage;



    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public RegistrationPage registrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage();
        }
        return registrationPage;
    }
}

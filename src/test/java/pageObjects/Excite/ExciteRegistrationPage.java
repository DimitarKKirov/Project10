package pageObjects.Excite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ExciteRegistrationPage extends ExciteRegularElements {


    public void fieldsInput(String firstName, String lastName, String dateOfBirth,
                            String phoneNumber, String userSecondEmail, String streetAddress1,
                            String streetAddress2, String userCity, String stateOrProvince,
                            String zipCode, String country, String userName, String password, String confirmPass) {

        driver.findElement(By.id("first_name")).sendKeys(firstName);
        driver.findElement(By.id("last_name")).sendKeys(lastName);
        driver.findElement(By.id("bday")).sendKeys(dateOfBirth);
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);
        driver.findElement(By.id("email")).sendKeys(userSecondEmail);
        driver.findElement(By.id("street_one")).sendKeys(streetAddress1);
        driver.findElement(By.id("street_two")).sendKeys(streetAddress2);
        driver.findElement(By.name("city")).sendKeys(userCity);
        driver.findElement(By.id("state")).sendKeys(stateOrProvince);
        driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys(zipCode);
        Select dopDown = new Select(driver.findElement(By.id("country")));
        dopDown.selectByVisibleText(country);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.id("password_confirm")).sendKeys(confirmPass);

    }

    public void completeRegButtonClick() {
        driver.findElement(By.id("signup_button")).click();
    }

}

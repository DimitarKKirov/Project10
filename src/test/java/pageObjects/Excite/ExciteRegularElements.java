package pageObjects.Excite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import paths.DriverSwitchBrowser;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public abstract class ExciteRegularElements implements DriverSwitchBrowser {


    private String nextTab;
    public static WebDriver driver;
    private JavascriptExecutor scroll = (JavascriptExecutor) driver;
    private static String browserName;
    private static String browserDriverPath;
    private static String browserProperty;
    private Set<Cookie> allCookies;

    /*instantiation of singleton page classes, inheritance of methods of:
    1:MainMenu method for selecting from all products menu
    2:Wait method for all inheriting classes
    3:searching and returning current page title
    4:close tab and close browser methods
     */

    //setting the driver
    private static void setDriver(WebDriver driver) {
        ExciteRegularElements.driver = driver;
    }

    //method for loading the driver based on the name given to the previous method
    public static WebDriver getDriver() {
        return driver;
    }

    public void changeBrowser(String s) {
        String path;
        try {
            if (s.equalsIgnoreCase("Chrome")) {
                path = chrome;
            } else if (s.equalsIgnoreCase("FireFox")) {
                path = fireFox;
            } else {
                path = chrome;
            }
            Properties tempProp = new Properties();
            tempProp.load(new FileInputStream(path));
            browserName = tempProp.getProperty("browserName");
            browserDriverPath = tempProp.getProperty("browserDriverPath");
            browserProperty = tempProp.getProperty("browserProps");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // method for creating the , taking parameters for URL to be opened and driver name
    // , the type of the driver is depending on the entered browser name
    public WebDriver startBrowser(String url, String browserName) {

        changeBrowser(browserName);

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty(browserProperty, browserDriverPath);
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("Headless")) {
            System.setProperty(browserProperty, browserDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);

        }
        driver.manage().window().maximize();
        driver.get(url);
        setDriver(driver);
        return driver;

    }

    //method for creating driver wait
    public WebDriverWait createWait(int timeOut) {
        return new WebDriverWait(driver, timeOut);
    }


    //finding the title using the driver function
    public String getPageTitle() {

        return driver.getTitle();
    }

    //method for selenium actions
    public Actions createAction (){
        return new Actions(driver);
    }

    //method for finding element true xpath
    public WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    //closing current browser tab
    public void closeBrowserTab(){
        driver.close();
    }
    //method for quiting the browser
    public void quitBrowser() {
        driver.quit();
    }

    //creating a file that contains the cookies of the session when the method is used
    public void saveCookies() {
        try {
            File emagCookie = new File("/cookies/emagCookie.data");

            FileWriter write = new FileWriter(emagCookie);
            BufferedWriter bWriter = new BufferedWriter(write);
            for (Cookie cK : driver.manage().getCookies()) {
                bWriter.write((cK.getName() + ";" + cK.getValue() + ";" + cK.getDomain() + ";" + cK.getPath() + ";" + cK.getExpiry() + ";" + cK.isSecure()));
                bWriter.newLine();
            }
            bWriter.close();

            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String switchToNextTab() {
        //getting all windows
        Set handler = driver.getWindowHandles();

        //getting the current window name
        String currentTab = driver.getWindowHandle();

        //removing the current window from the Set
        handler.remove(currentTab);

        Object secondTab = handler.iterator().next();

        if (currentTab != secondTab) {
            nextTab = (String) secondTab;

        }
        return nextTab;
    }
    public void switchToTab(String tab){
        driver.switchTo().window(tab);
    }
}

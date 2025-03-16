package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends PageBase {

    @Override
    public WebDriver getDriver() {
        return super.getDriver();
    }

    private By usernameXpath = By.xpath("//*[@type = 'email']");
    private By passwordXpath = By.xpath("//*[@type = 'password']");
    private By loginButtonId = By.id("kt_login_signin_submit");
    private By dashboardXpath = By.xpath("//*[contains(text(),'Welcome,')]");
    private By dashboardLCRWidgetXpath = By.xpath("//*[@id='myChart40398']");
    private By invalidcCredentialsErrorXpath = By.xpath("//*[contains(text(), 'The Email or password you have entered is incorrect. Please try again.')]");
    private By navBarXpath = By.xpath("//*[@id='navbarSupportedContent']/ul/li");
    private By logOutButtonXpath = By.xpath("//*[contains(text(), 'Logout')]");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterUsernameAndPassword(String username, String password) {

        if (elementExists(navBarXpath)) {
            driver.findElement(navBarXpath).click();
            waitUntilElementIsVisible(logOutButtonXpath);
            driver.findElement(logOutButtonXpath).click();
        }
        waitUntilElementIsVisible(usernameXpath);
        if(!elementExists(usernameXpath))
        {
            System.out.println("Login Page not accessible");
        }
        driver.findElement(usernameXpath);
        driver.findElement(usernameXpath).sendKeys(username);
        driver.findElement(passwordXpath).sendKeys(password);
    }


    public void clickOnLogin() {
        driver.findElement(loginButtonId).click();
    }

    public void login(String username, String password) throws InterruptedException {
        if (elementExists(dashboardXpath)) {
            waitSeconds(3);
        } else {
            waitUntilElementIsVisible(usernameXpath);
            driver.findElement(usernameXpath);
            driver.findElement(usernameXpath).sendKeys(username);
            driver.findElement(passwordXpath).sendKeys(password);
            driver.findElement(loginButtonId).click();
        }
    }


    public boolean getInvalidCredentialsXpath() {
        waitUntilElementIsVisible(invalidcCredentialsErrorXpath);
        return elementIsVisible(invalidcCredentialsErrorXpath);
    }

    public boolean getDashboardXpath() {
        return driver.findElement(dashboardXpath).isDisplayed() & driver.findElement(dashboardLCRWidgetXpath).isDisplayed();
    }


}

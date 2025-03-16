package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserManager {

    private static WebDriver webDriver;

    public static WebDriver getDriver() throws InterruptedException {
        return webDriver;
    }

    public static void setDriver(WebDriver driver) {
        webDriver = driver;
    }

    public static void setupDriver(String URL) throws InterruptedException {
        if (webDriver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds((1500)));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get(URL);
        } else {
            webDriver.get(URL);
        }
    }

    public static void closeDriver() {
        if (webDriver != null) {
            webDriver.quit();  // Use quit() to close the session fully when needed.
            webDriver = null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        // Set up ChromeDriver path
//        // Set up ChromeDriver path
//        WebDriver driver;
//
//        // Username and password
//        String username = "Regulatory.demo@focusync.local.uk";
//        String password = "vBnfghRTY7^5";
//
//        // Initialize the WebDriver
//        driver = new ChromeDriver();
//
//        // Navigate to the login page
//        driver.get("http://51.68.195.149/Tarramis.MIS.V3.Demo");
//
//        // Wait for the page to load
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
//
////        // Create cookies for username and password
////        Cookie usernameCookie = new Cookie("username", username);
////        Cookie passwordCookie = new Cookie("password", password);
////
////        // Add the cookies to the browser
////        driver.manage().addCookie(usernameCookie);
////        driver.manage().addCookie(passwordCookie);
////
////        // Navigate to the correct URL first
////        driver.get("https://example.com");
//
//// Create a cookie
//        Cookie username1 = new Cookie.Builder("username", "Regulatory.demo@focusync.local.uk")
//                .domain("51.68.195.149/Tarramis.MIS.V3.Demo")  // Ensure the domain matches the current URL
//                .path("51.68.195.149/Tarramis.MIS.V3.Demo")
//                .build();
//
//        Cookie username2 = new Cookie.Builder("username", "Regulatory.demo@focusync.local.uk")
//                .domain("51.68.195.149/Tarramis.MIS.V3.Demo")  // Ensure the domain matches the current URL
//                .path("51.68.195.149/Tarramis.MIS.V3.Demo")
//                .build();
//
//
//// Add the cookie
//        driver.manage().addCookie(username1);
//        driver.manage().addCookie(username2);
//
//        driver.get("51.68.195.149/Tarramis.MIS.V3.Demo");
//
//
//        // Refresh the page to apply the cookies
//        driver.navigate().refresh();
//
//        // Find the login button and press Enter
//        driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
//
//        // Now, you are logged in and can interact with the site as an authenticated user.
//
//        // Do your test actions here
//
//        // Close the browser
//        driver.quit();
    }
}

package pages.helpers;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public interface Waitable extends Findable {


    default void waitUntilElementIsVisible(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(InvalidArgumentException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    default void waitUntilElementIsClicked(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(webDriver -> webDriver.findElement(locator).isDisplayed());
        getDriver().findElement(locator).click();
    }

    default void waitUntilElementIsNotVisible(By locator)  {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    default void waitUntilElementIsClickable(By locator)  {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    default void waitUntilElementIsPresence(By locator)  {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    default void waitUntilElementAttributeIsNotEmpty(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(webDriver -> !webDriver.findElement(locator).getAttribute("value").isEmpty());
    }

    default void waitUntilAttributeIsNotDisabled(By locator) {
        WebElement element = getDriver().findElement(locator);
        while (element.getAttribute("disabled") != null && !element.getAttribute("disabled").equals("true")) ;
    }

    default void waitUntilElementIsWellFilled(String value, By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(a -> getDriver().findElement(locator).getAttribute("value").equals(value.toUpperCase()));
    }

    default void waitUntilElementIsFilled(String value, By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(a -> {
            getDriver().findElement(locator).sendKeys(value);
            return getDriver().findElement(locator).getAttribute("value").equals(value);
        });
    }

    default void waitSeconds(int seconds)  {
        try {
            SECONDS.sleep(seconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    default void waitSeconds() {
        try {
            SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}

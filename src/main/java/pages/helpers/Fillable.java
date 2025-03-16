package pages.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public interface Fillable extends Waitable {

    default void fillElement(String value, By locator) {
        if (!value.isEmpty()) {
            WebElement element = findElement(locator);
            element.clear();
            element.sendKeys(value);
        }
    }

    default void fillElement(String value, WebElement element) {
        if (!value.isEmpty()) {
            element.clear();
            element.sendKeys(value);
        }
    }

    default void fillDateElement(String value, By locator)  {
        waitSeconds();
        WebElement element = findElement(locator);
        Actions act = new Actions(getDriver());
        do {
            element.clear();
            act.moveToElement(element).moveByOffset(0, 0).click().perform();
            act.moveToElement(element).moveByOffset(0, 0).sendKeys(value).perform();
        } while (!element.getAttribute("value").replace("/", "").equals(value));
    }

    default void fillElementAndPressEnter(String value, By locator) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    default void fillSelectFieldByVisibleText(String fieldValue, By locator) {
        if (!fieldValue.isEmpty()) {
            Select element = new Select(findElement(locator));
            element.selectByVisibleText(fieldValue);
        }
    }

    default void fillSelectFieldByValue(String fieldValue, By locator) {
        if (!fieldValue.isEmpty()) {
            Select element = new Select(findElement(locator));
            element.selectByValue(fieldValue);
        }
    }

    default void fillSelectFieldByContainVisibleText(String fieldValue, By locator) {
        if (!fieldValue.isEmpty()) {
            Select element = new Select(findElement(locator));
            for (WebElement option : element.getOptions()) {
                if (option.getText().contains(fieldValue)) {
                    element.selectByVisibleText(option.getText());
                    break;
                }
            }
        }
    }

    default void cleanSelectField(By locator) {
        Select element = new Select(findElement(locator));
        element.selectByIndex(0);
    }

}

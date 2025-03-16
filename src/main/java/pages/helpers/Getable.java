package pages.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface Getable extends Findable {

    default String getTextElement(By locator) {
        return findElement(locator).getText();
    }

    default String getTextElement(WebElement element) {
        return element.getText();
    }

    default String getAttributeElement(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute);
    }

    default String getAttributeElement(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    default String getAttributeStyleElement(By locator) {
        return findElement(locator).getAttribute("style");
    }

    default String getAttributeDisabledElement(By locator) {
        return findElement(locator).getAttribute("disabled");
    }

    default String getAttributeClassElement(By locator) {
        return findElement(locator).getAttribute("class");
    }

    default String getAttributeValueElement(By locator) {
        return getAttributeElement(locator, "value");
    }

    default String getAttributeValueElementForCalculation(By locator) {
        String value = getAttributeValueElement(locator).replace(",", "");
        if (value.isEmpty()) {
            value = "0";
        }
        return value;
    }

    default String getAttributeValueElement(WebElement element) {
        return getAttributeElement(element, "value");
    }

    default String getTextSelectedDropDownElement(By locator) {
        Select select = new Select(findElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    default boolean getElementIsChecked(By locator) {
        return getAttributeElement(locator, "checked") == null;
    }

    default boolean getElementIsRequired(By locator) {
        return getAttributeClassElement(locator).contains("input--required");
    }

    default boolean getElementIsMandatory(By locator) {
        return getAttributeClassElement(locator).contains("mandatory");
    }

}

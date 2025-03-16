package pages.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.ArrayList;
import java.util.List;

public interface Conditionable extends Waitable {

    default boolean elementIsVisible(By locator) {
        return findElement(locator).isDisplayed();
    }

    default boolean elementExists(By locator) {
        return !findElements(locator).isEmpty();
    }

    default boolean isElementDisabled(By locator){
        waitSeconds();
        WebElement element;
        try {
            element = findElement(locator);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return element.getAttribute("disabled") != null && element.getAttribute("disabled").equals("true");
    }

    default boolean dropDownIsEmpty(By locator) {
        Select element;
        try {
            element = new Select(findElement(locator));
        } catch (UnexpectedTagNameException e) {
            return true;
        }
        List<WebElement> options = element.getOptions();
        return options.isEmpty();
    }

    default boolean dropDownHasValue(String fieldValue, By locator) {
        Select element = new Select(findElement(locator));
        for (WebElement option : element.getOptions()) {
            if (option.getText().equals(fieldValue)) {
                return true;
            }
        }
        return false;
    }
//
//    default boolean dropDownHasValueList(ArrayList<String> companyList, By locator) throws OmnexException {
//        Select element = new Select(findElement(locator));
//        List<String> companiesDropDown = new ArrayList<>();
//        for (WebElement dropDownElement : element.getOptions()) {
//            companiesDropDown.add(dropDownElement.getText());
//        }
//        for (String company : companyList) {
//            if (companiesDropDown.contains(company)) {
//                throw new OmnexException("Company : " + company + " is not found");
//            }
//        }
//        return true;
//    }

//    default boolean dropDownHasList(ArrayList<String> valueList, By locator) throws OmnexException {
//        Select element = new Select(findElement(locator));
//        List<String> languagesDropDown = new ArrayList<>();
//        for (WebElement dropDownElement : element.getOptions()) {
//            languagesDropDown.add(dropDownElement.getText());
//        }
//        for (String value : valueList) {
//            if (!languagesDropDown.contains(value)) {
//                throw new OmnexException("Value : " + value + " is not found");
//            }
//        }
//        return true;
//    }

    default boolean checkPrefixesExistInDropdown(String prefixes, By locator) {
        Select dropdown = new Select(findElement(locator));
        String[] prefixesArray = prefixes.split(",");

        for (String prefix : prefixesArray) {
            boolean prefixExists = false;

            for (WebElement option : dropdown.getOptions()) {
                if (option.getText().contains(prefix.trim())) {
                    prefixExists = true;
                    break;
                }
            }

            if (!prefixExists) {
                return false; // Prefix not found for one of the values
            }
        }

        return true; // All prefixes found in the dropdown options
    }


    default boolean isAlertPresent(WebDriver driver) {
        boolean presentAlert;
        try {
            driver.switchTo().alert();
            presentAlert = true;
        } catch (NoAlertPresentException ex) {
            presentAlert = false;
        }
        return presentAlert;
    }
//
//    default void checkDropDownIsFilled(By locator) throws OmnexException {
//        WebElement selectElement = findElement(locator);
//        Select select = new Select(selectElement);
//        String textValue = select.getFirstSelectedOption().getText();
//        if (textValue.isEmpty() || textValue.equalsIgnoreCase("All") || textValue.contains("[-")) {
//            throw new OmnexException("Select" + locator + "expected other value");
//        }
    }


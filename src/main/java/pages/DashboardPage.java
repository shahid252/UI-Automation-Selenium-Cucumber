package pages;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends PageBase {
    private final By dashboardXpath = By.xpath("//*[contains(text(),'Welcome,')]");
    private final By menuBarXpath = By.xpath("//*[@id='header-container']/div/nav/button/i");
    private final By reportsXpath = By.xpath("//a[@class='nav-link dropdown-toggle' and span[text()='Reports']]");

    private final By batchProcessingSummaryXpath = By.xpath("//*[@id='myChart41080']/app-widget-custom-grid-row-group/div/app-widget-header/div/div/div[1]/p");
    private final By batchProcessingSummaryGridXpath = By.xpath("//*[@id='CustomGrid41080']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/ng-component/a");
    private final By exceptionSummaryXpath = By.xpath("//*[@id='myChart41103']/app-widget-custom-grid-row-group/div/app-widget-header/div/div/div[1]/p");
    private final By kpisXpath = By.xpath("//*[@id='myChart41145']/app-widget-custom-grid-row-group/div/app-widget-header/div/div/div[1]");
    private final By kpisGridXpath = By.xpath("//*[@id='CustomGrid41145']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/ng-component/a");

    private final By financialSettlementSummaryXpath = By.xpath("//*[@id='myChart41116']/app-widget-custom-grid-row-group/div/app-widget-header/div/div/div[1]");
    private final By exceptionSummaryGridXpath = By.xpath("//*[@id='CustomGrid41103']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/ng-component/a");

    private final By financialSettlementGridXpath = By.xpath("//*[@id='CustomGrid41116']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/ng-component/a");
    private final By reportingVarianceTrendXpath = By.xpath("//*[@id='myChart41115']/app-widget-fscustom-charts/div/app-widget-header/div");

    private final By collateralManagementXpath = By.xpath("//*[@id='myChart41113']/app-widget-custom-grid-row-group/div/app-widget-header/div/div/div[1]/p");

    private final By reportingVarianceTrendGridXpath = By.xpath("//*[@id='CustomGrid41115']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/ng-component/a");
    private final By collateralManagementGridXpath = By.xpath("//*[@id='CustomGrid41113']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/ng-component/a");

    private final By editButtonXpath = By.xpath("//*[@id='submenu-container']/form/div/nav/ul[2]/li[4]");
    private final By addWidgetXpath = By.xpath("//*[@id='submenu-container']/form/div/nav/ul[2]/li[5]/button/span");
    private final By treasuryWidgetXpath = By.xpath("//div[contains(text(),'Treasury')]");
    //    private final By liquidityWidgetXpath = By.xpath("//*[contains(text(),'Liquidity')]");
    private final By liabilitiesWidgetXpath = By.xpath("//div[contains(text(),'Liabilities')]");
    private final By assetWidgetXpath = By.xpath("//div[contains(@title, 'Assets')]");
    private final By CRMWidgetXpath = By.xpath("//div[contains(@title, 'CRM')]");
    private final By expenseWidgetXpath = By.xpath("//div[contains(@title, 'Expense')]");
    private final By widgetAddButtonXpath = By.xpath("//*[@id='mat-tab-content-2-0']/div/div/div/div[1]/div/div/div/div[1]/button/i");

    private final By BatchProcessingTableDataLocatorXpath = By.xpath("//*[@id='DataGrid']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]");
    private final By FinancialStatementTableDataLocatorXpath = By.xpath("//*[@id='ReportData']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/ng-component/a");
    private final By KPIsTableDataLocatorXpath = By.xpath("//*[@id='CustomGrid41054']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/ng-component/a");
    private final By ExceptionSummaryTableDataLocatorXpath = By.xpath("//*[@id='ReportData']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/div[3]");

    private final By editCancel = By.xpath("//*[@id='submenu-container']/form/div/nav/ul[2]/li[7]/button/span");
    private final By imageNotFound = By.xpath("//img[@src='assets/images/notfound.png']");
    private final By linkDataXpath = By.xpath("//*[@id='ReportData']/div/div[2]/div[1]/div[3]/div[2]/div/div/div[1]/div[3]");
    private final By linkExcelDataXpath = By.xpath("//*[@id='fm-pivot-view']/div[2]/div/div[3]/div/div[2]/div[3]");

    private final By backLinkXpath = By.xpath("//*[@id='submenu-container']/form/div/nav/ul/li/app-bread-crumb/div/p-breadcrumb/div/ul/li[3]/a/span");
    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

   private SoftAssert softAssert = new SoftAssert();

    SoftAssert softAssert1 = softAssert;


    public boolean getDashboardXpath() throws InterruptedException {
        Thread.sleep(5000);
        waitUntilElementIsVisible(dashboardXpath);
        return elementIsVisible(dashboardXpath);
    }

    public void goToReports() throws InterruptedException {
        driver.switchTo().window(driver.getWindowHandle());
        waitSeconds(5);
        if(!elementIsVisible(reportsXpath)){
            WebElement element = driver.findElement(menuBarXpath);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
        driver.findElement(reportsXpath).click();
        waitSeconds(4);
    }

    public String getBatchProcessingSummaryXpath() {
        waitUntilElementIsPresence(batchProcessingSummaryXpath);
        return getTextElement(batchProcessingSummaryXpath);
    }

    public String getExceptionSummaryXpath() {
        waitUntilElementIsPresence(exceptionSummaryXpath);
        return getTextElement(exceptionSummaryXpath);
    }

    public String getKPISXpath() {
        waitUntilElementIsPresence(kpisXpath);
        return getTextElement(kpisXpath);
    }

    public String getFinancialSettlementSummaryXpath() {
        waitUntilElementIsPresence(financialSettlementSummaryXpath);
        return getTextElement(financialSettlementSummaryXpath);
    }

    public String getCollateralManagementXpath() {
        waitUntilElementIsPresence(collateralManagementXpath);
        return getTextElement(collateralManagementXpath);
    }
    public String getReportingVarianceTrendXpath() {
        waitUntilElementIsPresence(reportingVarianceTrendXpath);
        return getTextElement(reportingVarianceTrendXpath);
    }
    private By getWidgetModuleXpath(String widgetModule) {
        String widgetModuleXpath = String.format(
                "//div[contains(@title, '%s')]",
                widgetModule
        );
        return By.xpath(widgetModuleXpath);
    }

    private By getLinkModuleXpath(String module) {
        String linkModuleXpath = String.format(
                "//*[@class='nav-link' and span[text()='%s']]",
                module
        );
        return By.xpath(linkModuleXpath);
    }

    private By getWidgetButtonXpath(String widgetTitle) {
        String widgetButtonXpath = String.format(
                "//div[div/h6[contains(@title, '%s')]]//button/i[contains(@class, 'material-icons md-18')]",
                widgetTitle
        );
        return By.xpath(widgetButtonXpath);
    }

    private By getWidgetXpath(String widgetTitle) {
        String widgetButtonXpath = String.format(
                "//span[@ref='eText' and @class='ag-header-cell-text' and text()='%s']",
                widgetTitle
        );
        return By.xpath(widgetButtonXpath);
    }
    public boolean verifyWidgetTitle(String widgetTitle) throws InterruptedException {
        String widgetTitleXpath = String.format(
                "//*[contains(@title, '%s')]",
                widgetTitle
        );

        waitSeconds(5);
        By widgetTitleLocator = By.xpath(widgetTitleXpath);

        if (elementExists(imageNotFound))
        {
            return false;
        }
        return elementIsVisible(widgetTitleLocator);
    }

    public boolean addWidget(String widgetTitle, String widgetModule ) throws InterruptedException {
        waitSeconds(13);
        if (elementExists(editCancel))
        {
            driver.findElement(editCancel).click();
        }
        waitUntilElementIsClickable(editButtonXpath);
        waitUntilElementIsPresence(editButtonXpath);
        driver.findElement(editButtonXpath).click();
        waitUntilElementIsVisible(addWidgetXpath);
        clickOnClickableElement(addWidgetXpath);
        By widgetModuleLocator = getWidgetModuleXpath(widgetModule);
        waitUntilElementIsVisible(widgetModuleLocator);
        driver.findElement(widgetModuleLocator).click();
        By widgetButtonLocator = getWidgetButtonXpath(widgetTitle);
        waitSeconds(10);
        if (elementExists(widgetButtonLocator)) {
            driver.findElement(widgetButtonLocator).click();
            return true;
        } else {
            throw new RuntimeException(widgetTitle + " widget not visible");
        }

    }

    public List<String> getAllReportModules() {
        waitSeconds(5);
        List<WebElement> moduleElements = driver.findElements(By.xpath("/html/body/app-root/app-layout/app-sidebar/div/ul[5]/li/div/div/ul"));
        List<String> modules = new ArrayList<>();
        for (WebElement moduleElement : moduleElements) {
            modules.add(moduleElement.getText().trim());
        }
        return modules;
    }

    public void goToReportModule(String module)
    {
        By linkModuleLocator = getLinkModuleXpath(module);
        waitUntilElementIsVisible(linkModuleLocator);

        // Click the module if the element exists
        if (elementExists(linkModuleLocator)) {
            driver.findElement(linkModuleLocator).click();
        }
    }

        public void verifyTableLinks() {
            List<String> modules = getAllReportModules();
            String module1 = modules.get(0);
            String result = module1.replaceAll("^[^A-Z]*", "");

            goToReportModule(result);

            waitUntilTableIsLoaded(); // Dynamic wait for table loading
            boolean hasNextPage = true;
            int currentPage = 1; // Start from the first page

            while (hasNextPage) {
                waitSeconds(10);
                List<WebElement> links = driver.findElements(By.cssSelector(".ag-center-cols-container a"));
                int totalLinks = links.size();
                Allure.step("Total links found on current page: " + totalLinks);

                for (int i = 0; i < totalLinks; i++) {
                    try {
                        // Refresh the links list to avoid stale elements
                        waitSeconds(8);
                        links = driver.findElements(By.cssSelector(".ag-center-cols-container a"));
                        WebElement link = links.get(i);
                        String linkText = link.getText();
                        Allure.step("Clicking link: " + linkText);

                        if (!linkText.equals("Custom Report(report set)") && !linkText.equals("Currency Wise Balance (C22)") && !linkText.equals("Test by anas") && !linkText.equals("Test Report for Asif")) {
                            // Click the link with retry logic
                            clickWithRetry(link);

                            Allure.step("Navigated to the link: " + linkText);

                            waitUntilPageLoadComplete(); // Wait for page to load after clicking the link

                            // Verify data for the clicked link
                            String data = getDataForLink(linkText);
                            if (!data.isEmpty()) {
                                Allure.step(linkText + " has data: " + data);
                            } else {
                                Allure.step(linkText + " no data found");
                            }

                            // Navigate back to the correct page in the module
                            navigateBackToModule(currentPage);
                            waitSeconds(5);
                            navigateToPage(currentPage); // Ensures the correct page is reached
                        } else {
                            Allure.step(linkText + ": not working");
                        }

                    } catch (Exception e) {
                        Allure.step("Error interacting with link index " + i + ": " + e.getMessage());
                    }
                }

                // Navigate to the next page if "Next" button exists and is enabled
                hasNextPage = navigateToNextPage(currentPage);
                currentPage++;
            }
        }

        // Wait dynamically for links to load
        private List<WebElement> waitForLinksToLoad() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".ag-center-cols-container a")));
        }

        // Wait dynamically for the table to load
        private void waitUntilTableIsLoaded() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ag-center-cols-container")));
        }

        // Wait dynamically until the page load is complete
        private void waitUntilPageLoadComplete() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }

        // Navigate to the next page
        private boolean navigateToNextPage(int currentPage) {
            By nextButtonXpath = By.xpath("//button[text()='Next']");
            try {
                if (elementExists(nextButtonXpath) && driver.findElement(nextButtonXpath).isEnabled()) {
                    Allure.step("Navigating to the next page.");
                    driver.findElement(nextButtonXpath).click();
                    waitUntilPageLoadComplete();
                    return true; // Next page exists
                } else {
                    Allure.step("No more pages to navigate.");
                    return false; // No next page
                }
            } catch (Exception e) {
                Allure.step("Error interacting with 'Next' button on page " + currentPage + ": ");
                return false; // Stop pagination on error
            }
        }

        // Retry logic for clicking an element
        private void clickWithRetry(WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            waitSeconds(2);
            int retries = 3;
            while (retries > 0) {
                try {
                    element.click();
                    return;
                } catch (Exception e) {
                    retries--;
                    waitSeconds(3); // Small delay before retry
                }
            }
            throw new RuntimeException("Failed to click element after retries.");
        }

        // Navigate to the correct page
        private void navigateToPage(int targetPage) {
            for (int i = 1; i < targetPage; i++) {
                if (!navigateToNextPage(i)) {
                    break; // Stop if navigation to next page fails
                }
            }
        }
        private void navigateBackToModule(int currentPage) {
            try {
                // Check and click the "Back" link to return to the module
                if (elementExists(backLinkXpath)) {
                    driver.findElement(backLinkXpath).click();
                    driver.findElement(backLinkXpath).click();
                    waitSeconds(4);// Wait until the module table is loaded
                } else {
                    Allure.step("Back link not found. Waiting as fallback.");
                }

                // Navigate to the correct page if it reset to the first page
                for (int i = 1; i < currentPage; i++) {
                    By nextButtonXpath = By.xpath("//button[text()='Next']");
                    if (elementExists(nextButtonXpath) && driver.findElement(nextButtonXpath).isEnabled()) {
                        driver.findElement(nextButtonXpath).click();
                        waitSeconds(3); // Wait for each page to load
                        Allure.step("Navigated forward to page " + (i + 1));
                    } else {
                        Allure.step("Failed to navigate back to page " + currentPage + ". 'Next' button is not available.");
                        break;
                    }
                }
            } catch (Exception e) {
                Allure.step("Error navigating back to the module or to page " + currentPage + ": " + e);
                throw new RuntimeException("Failed to navigate back to the module and page " + currentPage);
            }
        }

        private String getDataForLink(String linkText) {
            if (elementExists(linkDataXpath)) {
                return driver.findElement(linkDataXpath).getText();
            } else if (elementExists(linkExcelDataXpath)) {
                return driver.findElement(linkExcelDataXpath).getText();
            }
            return "";
        }

    int expectedWidgetCount = 15;
    int currentGridItemCount;

    public void validateCountOfGrids() throws Exception {
        System.out.println("Expected Grid Item Count: " + expectedWidgetCount);
        Allure.step("Expected Grid Item Count: " + expectedWidgetCount);

        try {
            // Locate grid container
            WebElement gridContainer = driver.findElement(By.xpath("//*[@id='main-container']/app-misdashboard/app-base-dashboard/div/gridster"));

            // Count grid items dynamically from the DOM
            List<WebElement> gridItems = gridContainer.findElements(By.tagName("gridster-item"));
            currentGridItemCount = gridItems.size();

            System.out.println("Current Grid Item Count from DOM: " + currentGridItemCount);
            Allure.step("Current Grid Item Count from DOM: " + currentGridItemCount);


            if (currentGridItemCount > expectedWidgetCount) {
                int extraItems = currentGridItemCount - expectedWidgetCount;
                System.out.println("New grid items have been added. Extra items: " + extraItems);
                Allure.step("New grid items have been added. Extra items: " + extraItems);
            } else if (currentGridItemCount < expectedWidgetCount) {
                int missingItems = expectedWidgetCount - currentGridItemCount;
                System.out.println("Some grid items are missing. Missing items: " + missingItems);
                Allure.step("Some grid items are missing. Missing items: " + missingItems);
            } else {
                System.out.println("Grid item count matches the expected count.");
            }

        } catch (NoSuchElementException e) {
            Allure.step("Error locating grid container or grid items: " + e.getMessage());
            System.out.println("Error locating grid container or grid items: " + e.getMessage());
            throw new Exception("Error locating grid container or grid items: " + e.getMessage());
        }

        // Assert all to report any failures
//        softAssert.assertAll();
    }

    public void validateGridItemsData() {

        // Soft assertion to validate grid count
        softAssert1.assertEquals(
                currentGridItemCount,
                expectedWidgetCount,
                "Mismatch in grid item count!"
        );

        try {
            WebElement gridContainer = driver.findElement(By.xpath("//*[@id='main-container']/app-misdashboard/app-base-dashboard/div/gridster"));

            // Locate all grid items dynamically
            List<WebElement> gridItems = gridContainer.findElements(By.tagName("gridster-item"));

            System.out.println("Logging details of all grid items:");
            for (WebElement item : gridItems) {
                try {
                    WebElement widget = item.findElement(By.tagName("widget-placeholder"));
                    String widgetId = widget.getAttribute("id");
                    String widgetData = widget.getText().trim();

                    System.out.println("Widget ID: " + widgetId + " Data: " + widgetData);
                    Allure.step("Widget ID: " + widgetId + " Data: " + widgetData);

                    // Example validation logic
                    softAssert1.assertNotNull(widgetId, "Widget ID should not be null for widget.");
                    softAssert1.assertFalse(widgetData.isEmpty(), "Widget data should not be empty for widget ID: " + widgetId);

                } catch (NoSuchElementException e) {
                    Allure.step("Error locating widget inside grid item: " + e.getMessage());
                    System.out.println("Error locating widget inside grid item: " + e.getMessage());
                    softAssert1.fail("Failed to locate widget in grid item. Exception: " + e.getMessage());
                }
            }

        } catch (NoSuchElementException e) {
            Allure.step("Error locating grid container or grid items: " + e.getMessage());
            System.out.println("Error locating grid container or grid items: " + e.getMessage());
            throw new RuntimeException("Error locating grid container or grid items: " + e.getMessage());
        }

        // Assert all to report any failures
        softAssert1.assertAll();
    }


//    public void validateCountOfGrids() throws Exception {
//        int expectedWidgetCount = 15;
//        System.out.println(expectedWidgetCount);
//        Allure.step(String.valueOf(expectedWidgetCount));
//
//        try {
//            // Locate grid container
//            WebElement gridContainer = driver.findElement(By.xpath("//*[@id='main-container']/app-misdashboard/app-base-dashboard/div/gridster"));
//
//            // Count grid items dynamically from the DOM
//            List<WebElement> gridItems = gridContainer.findElements(By.tagName("gridster-item"));
//            int currentGridItemCount = gridItems.size();
//
//            System.out.println("Current Grid Item Count from DOM: " + currentGridItemCount);
//            Allure.step("Current Grid Item Count from DOM: " + currentGridItemCount);
//
//
//            // Validation
//            if (currentGridItemCount == expectedWidgetCount) {
//                System.out.println("Grid item count matches the expected count.");
//            } else if (currentGridItemCount > expectedWidgetCount) {
//                System.out.println("New grid items have been added. Extra items: " + (currentGridItemCount - expectedWidgetCount));
//                Allure.step("New grid items have been added. Extra items: " + (currentGridItemCount - expectedWidgetCount));
//
//            } else {
//                System.out.println("Some grid items are missing. Missing items: " + (expectedWidgetCount - currentGridItemCount));
//                Allure.step("Some grid items are missing. Missing items: " + (expectedWidgetCount - currentGridItemCount));
//
//            }
//
//        } catch (NoSuchElementException e) {
//            Allure.step("Error locating grid container or grid items: " + e.getMessage());
//            System.out.println("Error locating grid container or grid items: " + e.getMessage());
//            throw new Exception("Error locating grid container or grid items: " + e.getMessage());
//
//
//        }
//    }
//
//    public void validateGridItemsData() {
//
//
//        try {
//            WebElement gridContainer = driver.findElement(By.xpath("//*[@id='main-container']/app-misdashboard/app-base-dashboard/div/gridster"));
//
//            // Locate all grid items dynamically
//            List<WebElement> gridItems = gridContainer.findElements(By.tagName("gridster-item"));
//
//            System.out.println("Logging details of all grid items:");
//            for (WebElement item : gridItems) {
//                WebElement widget = item.findElement(By.tagName("widget-placeholder"));
//                String widgetId = widget.getAttribute("id");
//                String widgetData = widget.getText().trim();
//                Allure.step("Widget ID: " + widgetId + " Data: " + widgetData);
//                System.out.println("Widget ID: " + widgetId + " Data: " + widgetData);
//            }
//
//        } catch (NoSuchElementException e) {
//            Allure.step("Error locating grid container or grid items: " + e.getMessage());
//            System.out.println("Error locating grid container or grid items: " + e.getMessage());
//            throw new RuntimeException("Error locating grid container or grid items: " + e.getMessage());
//        }
//    }




//    public void verifyTableLinks(String module) {
//        By linkModuleLocator = getLinkModuleXpath(module);
//        waitUntilElementIsVisible(linkModuleLocator);
//
//        // Click the module if the element exists
//        if (elementExists(linkModuleLocator)) {
//            driver.findElement(linkModuleLocator).click();
//        }
//
//           waitSeconds(10);
//
//        boolean hasNextPage = true;
//
//        while (hasNextPage) {
//            // Find all links within the table on the current page
//            List<WebElement> links = driver.findElements(By.cssSelector(".ag-center-cols-container a"));
//            int totalLinks = links.size();
//            Allure.step("Total links found on current page: " + totalLinks);
//
//            for (int i = 0; i < totalLinks; i++) {
//                try {
//
//                    waitSeconds(10);
//                    links = driver.findElements(By.cssSelector(".ag-center-cols-container a")); // Refresh links list
//                    WebElement link = links.get(i); // Get the current link
//
//                    waitSeconds(3);
//                    String linkText = link.getText();
//                    Allure.step("Clicking link: " + linkText);
//
//                    if (!linkText.equals("Custom Report(report set)")) {
//                        link.click();
//                        Allure.step("Navigated to the link: " + linkText);
//                        waitSeconds(5);
//
//                        // Verify data for the clicked link
//                        if (elementExists(linkDataXpath)) {
//                            String data = driver.findElement(linkDataXpath).getText();
//                            if (!data.isEmpty()) {
//                                Allure.step(linkText + " has data: " + data);
//                            } else {
//                                Allure.step(linkText + " no data found");
//                            }
//                        } else if (elementExists(linkExcelDataXpath)) {
//                            String data = driver.findElement(linkExcelDataXpath).getText();
//                            if (!data.isEmpty()) {
//                                Allure.step(linkText + " has data: " + data);
//                            } else {
//                                Allure.step(linkText + " no data found");
//                            }
//                        } else {
//                            Allure.step(linkText + " no data found");
//                        }
//
//                    } else {
//
//                        Allure.step(linkText + ": not working");
//                    }
//                        // Navigate back to the table
//                        if (elementExists(backLinkXpath)) {
//                            driver.findElement(backLinkXpath).click();
//                            waitUntilElementIsClicked(By.xpath("//button[text()='Next']"));
//                        } else {
//                            waitSeconds(5);
//                        }
//
//
//                } catch (StaleElementReferenceException e) {
//                    Allure.step("Stale element encountered for link index " + i + ": " + e.getMessage());
//                } catch (ElementClickInterceptedException e) {
//                    Allure.step("Element click was intercepted for link index " + i + ": " + e.getMessage());
//                } catch (Exception e) {
//                    Allure.step("Error interacting with link index " + i + ": " + e.getMessage());
//                }
//
//            }
//
//
//            if (elementExists(backLinkXpath) && driver.findElement(backLinkXpath).isEnabled()) {
//                driver.findElement(backLinkXpath).click();}
//            waitSeconds(3);
//                // Check for the "Next" button and navigate to the next page
//                By nextButtonXpath = By.xpath("//button[text()='Next']");
//                if (elementExists(nextButtonXpath) && driver.findElement(nextButtonXpath).isEnabled()) {
//                    Allure.step("Navigating to the next page.");
//                    driver.findElement(nextButtonXpath).click();
//                    waitSeconds(4); // Wait for the next page to load
//                } else {
//                    hasNextPage = false; // No more pages to navigate
//                    Allure.step("No more pages to navigate.");
//                }
//
//        }
//    }



//    public void verifyTableLinks(String module) {
//        By linkModuleLocator = getLinkModuleXpath(module);
//        waitUntilElementIsVisible(linkModuleLocator);
//
//        // Click the module if the element exists
//        if (elementExists(linkModuleLocator)) {
//            driver.findElement(linkModuleLocator).click();
//        }
//
//        waitSeconds(15);
//
//        // Find all links within the table
//        List<WebElement> links = driver.findElements(By.cssSelector(".ag-center-cols-container a"));
//        int totalLinks = links.size();
//        Allure.step("Total links found: " + totalLinks);
//
//        for (int i = 0; i < totalLinks; i++) {
//            try {
//                waitSeconds(10);
//                links = driver.findElements(By.cssSelector(".ag-center-cols-container a"));
//                WebElement link = links.get(i); // Get the current link
//
//                waitSeconds(3);
//                driver.findElement(backLinkXpath).click();
//                String linkText = link.getText();
//                Allure.step("Clicking link: " + linkText);
//
//                if (linkText.equals("Custom Report(report set)")) {
//                    Allure.step(linkText + ": not working");
//                } else {
//                    link.click();
//                    Allure.step("Navigated to the link: " + linkText);
//                    waitSeconds(5);
//                    if (!elementExists(linkDataXpath)) {
//                        waitSeconds(2);
//                    }
//                    if (elementExists(linkDataXpath)) {
//                        Allure.step("Navigated to the link: " + linkText);
//                        String a = driver.findElement(linkDataXpath).getText();
//                        if (!a.isEmpty()) {
//                            Allure.step(linkText + " has data: " + a);
//                            driver.findElement(backLinkXpath).click();
//                        } else {
//                            Allure.step(linkText + " no data found");
//                            driver.findElement(backLinkXpath).click();
//                        }
//                    } else if (elementExists(linkExcelDataXpath)) {
//                        String b = driver.findElement(linkExcelDataXpath).getText();
//                        if (!b.isEmpty()) {
//                            Allure.step(linkText + " has data: " + b);
//                            driver.findElement(backLinkXpath).click();
//                        } else {
//                            Allure.step(linkText + " no data found");
//                            driver.findElement(backLinkXpath).click();
//                        }
//                    } else {
//                        Allure.step(linkText + " no data found");
//                        driver.findElement(backLinkXpath).click();
//                    }
//
//                }
//            }catch (StaleElementReferenceException e) {
//                Allure.step("Stale element encountered for link index " + i + ": " + e.getMessage());
//
//            } catch (ElementClickInterceptedException e) {
//                Allure.step("Element click was intercepted: " + i + e.getMessage());
//            }
//                }
//
//        }


    public void verifyWidgetDrillDown(String widgetTitle, By widgetLocator) {
        waitSeconds(8);
        if (elementExists(widgetLocator)) {
            driver.findElement(widgetLocator).click();
            System.out.println(widgetTitle + " widget clicked successfully.");
        } else {
            System.out.println(widgetTitle + " widget not visible.");
        }
    }

    public void verifyAllWidgets(String widgetTitle) {
        waitSeconds(10);
        switch (widgetTitle) {
            case "Batch Processing Summary":
                verifyWidgetDrillDown("Batch Processing Summary", batchProcessingSummaryGridXpath);
                break;
            case "Exception Summary":
                verifyWidgetDrillDown("Exception Summary", exceptionSummaryGridXpath);
                break;
            case "Financial Settlement":
                verifyWidgetDrillDown("Financial Settlement", financialSettlementGridXpath);
                break;
            case "Reporting Variance Trend":
                verifyWidgetDrillDown("Reporting Variance Trend", reportingVarianceTrendGridXpath);
                break;
            case "Collateral Management":
                verifyWidgetDrillDown("Collateral Management", collateralManagementGridXpath);
                break;
            case "KPIs":
                verifyWidgetDrillDown("KPIs", kpisGridXpath);
                break;
            default:
                System.out.println("Widget title '" + widgetTitle + "' Not found Widget");
        }
    }

    public void getWidgetDataText(String widgetTitle)
    {
        waitSeconds(10);
        switch (widgetTitle) {
            case "Batch Processing Summary":
                String a = driver.findElement(batchProcessingSummaryGridXpath).getText();
                System.out.println("widget has data :" + a);
                Allure.step("widget has data :" + a);
                break;
            case "Exception Summary":
                String b = driver.findElement(exceptionSummaryGridXpath).getText();
                System.out.println("widget has data :" + b);
                Allure.step("widget has data :" + b);
                break;
            case "Financial Settlement":
                String c = driver.findElement(financialSettlementGridXpath).getText();
                System.out.println("widget has data :" + c);
                Allure.step("widget has data :" + c);
                break;
            case "Reporting Variance Trend":
                String d = driver.findElement(reportingVarianceTrendGridXpath).getText();
                System.out.println("widget has data :" + d);
                Allure.step("widget has data :" + d);
                break;
            case "Collateral Management":
                String e = driver.findElement(collateralManagementGridXpath).getText();
                System.out.println("widget has data :" + e);
                Allure.step("widget has data :" + e);
                break;
            case "KPIs":
                String f = driver.findElement(kpisGridXpath).getText();
                System.out.println("widget has data :" + f);
                Allure.step("widget has data :" + f);
                break;
            default:
                System.out.println("Widget title '" + widgetTitle + "' Not found Widget");
        }

    }

    public void verifyBatchProcessingSummaryTableHasData() {
        try {
            waitUntilElementIsVisible(BatchProcessingTableDataLocatorXpath);
            WebElement dataElement = driver.findElement(BatchProcessingTableDataLocatorXpath);
            String dataText = dataElement.getText();

            if (dataText != null && !dataText.trim().isEmpty()) {
                System.out.println("Table data is present: " + dataText);
                Allure.step("Table data is present: " + dataText);
            } else {
                throw new RuntimeException("Table data is null or empty.");
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Table data element not found.",e);
        }
        waitSeconds(5);
        clickOnClickableElement(By.xpath("//*[@id='submenu-container']/form/div/nav/ul/li/app-bread-crumb/div/p-breadcrumb/div/ul/li[1]/a/span"));
    }

    public void verifyExceptionSummaryTableHasData() {
        try {
            WebElement dataElement = driver.findElement(ExceptionSummaryTableDataLocatorXpath);
            String dataText = dataElement.getText();

            if (dataText != null && !dataText.trim().isEmpty()) {
                Allure.step("Table data is present: " + dataText);
                System.out.println("Table data is present: " + dataText);
            } else {
                throw new RuntimeException("Table data is null or empty.");
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Table data element not found.",e);
        }
        waitSeconds(5);
        clickOnClickableElement(By.xpath("//*[@id='submenu-container']/form/div/nav/ul/li/app-bread-crumb/div/p-breadcrumb/div/ul/li[1]/a/span"));
    }

    public void verifyKPIsSummaryTableHasData() {
        try {
            WebElement dataElement = driver.findElement(KPIsTableDataLocatorXpath);
            String dataText = dataElement.getText();

            if (dataText != null && !dataText.trim().isEmpty()) {
                Allure.step("Table data is present: " + dataText);
                System.out.println("Table data is present: " + dataText);
            } else {
                throw new RuntimeException("Table data is null or empty.");
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Table data element not found.",e);

        }
        waitSeconds(5);
        clickOnClickableElement(By.xpath("//*[@id='submenu-container']/form/div/nav/ul/li/app-bread-crumb/div/p-breadcrumb/div/ul/li[1]/a/span"));
    }

    public void verifyFinancialStatementSummaryTableHasData() {
        try {
            WebElement dataElement = driver.findElement(FinancialStatementTableDataLocatorXpath);
            String dataText = dataElement.getText();

            if (dataText != null && !dataText.trim().isEmpty()) {
                Allure.step("Table data is present: " + dataText);
                System.out.println("Table data is present: " + dataText);
            } else {
                throw new RuntimeException("Table data is null or empty.");
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Table data element not found.",e);
        }
        waitSeconds(5);
        clickOnClickableElement(By.xpath("//*[@id='submenu-container']/form/div/nav/ul/li/app-bread-crumb/div/p-breadcrumb/div/ul/li[1]/a/span"));
    }

    public boolean verifyWidgetFromExcel(String title, String module) throws InterruptedException {
        String widgetXpath = String.format("//*[contains(@title, '%s') and contains(@title, '%s')]", title, module);
        By widgetLocator = By.xpath(widgetXpath);

        // Wait until widget is visible and check if it is displayed
        waitUntilElementIsVisible(widgetLocator);
        clickOnClickableElement(By.xpath("//*[@id='submenu-container']/form/div/nav/ul[2]/li[7]/button/span"));
        return elementIsVisible(widgetLocator);
    }

    public void VerifyWidgetAndHisData(String widget) {
        // Construct the dynamic XPath for the widget
        String xpath = "//p" + "[contains(@class, 'top-head') and text()='" + widget + "']/ancestor::div[contains(@class, 'col-custom')][1]//h4[contains(@class, 'card-amount')]//span";

        waitSeconds(3);
        waitUntilElementIsVisible(By.xpath(xpath));
        // Find the widget element
        WebElement widgetElement = driver.findElement(By.xpath(xpath));

        // Fetch the data (text) from the widget
        String widgetData = widgetElement.getText();

        if (!widgetData.isEmpty()) {
            Allure.step(widget + " has Data: " + widgetData);
        }
        else {
            Allure.step(widget + " has no Data: " );
        }

    }



}

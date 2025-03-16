package StepDefinitions;

import Utility.BrowserManager;
import Utility.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

public class LoginStepDefinition {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private Object[][] excelData;


    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        BrowserManager.setupDriver("http://51.68.195.149/Tarramis.MIS.V3.Demo/mis/dashboard");
        loginPage = new LoginPage(BrowserManager.getDriver());
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
    }

    @When("^I enter username (.*) and password (.*)$")
    public void iEnterUserNameAndPassword(String username, String password) {
        loginPage.enterUsernameAndPassword(username, password);
    }

    @When("^I login with username (.*) and password (.*)$")
    public void iLoginWihUserNameAndPassword(String username, String password) throws InterruptedException {
        loginPage.login(username, password);
    }

    @When("^I click on the login button$")
    public void iClickOnTheLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("I am logged in and on the dashboard page")
    public void iAmLoggedInAndOnTHeDashboardPage() throws InterruptedException {
        Assert.assertTrue(dashboardPage.getDashboardXpath());
    }

    @Then("^I add widget (.*) from (.*)$")
    public void iAddWidget(String widgetTitle, String widgetModule) throws InterruptedException {
        dashboardPage.addWidget(widgetTitle, widgetModule);
    }

    @Then("^I verify the widget on the dashboard page (.*)$")
    public void iVerifyTheWidgetTitle(String widgetTitle) throws InterruptedException {
        boolean isTitleVisible = dashboardPage.verifyWidgetTitle(widgetTitle);
        assertTrue("Widget title '" + widgetTitle + "' is not visible.", isTitleVisible);
    }

//    @Then("I verify asset on the dashboard page")
//    public void iVerifyAssetOnTheDashboardPage() throws InterruptedException {
//        dashboardPage.addAnAsset();
//    }

    @Then("Invalid credentials error should be shown")
    public void invalidCredentialsErrorShouldBeVisible() {
        Assert.assertTrue(loginPage.getInvalidCredentialsXpath());
    }

    @When("^I read the Excel data from excel sheet (.*)$")
    public void whenIReadExcelData(String excelPath) throws IOException {
        // Read data from the Excel file and store it in the class variable
        excelData = ExcelReader.getExcelData(excelPath);
    }


    @When("^I add widgets from the Excel data and verify on dashboard page$")
    public void whenIAddWidgetsFromExcel() throws InterruptedException {
        for (Object[] row : excelData) {
            String title = (String) row[3]; // Module in second column
            String module = (String) row[2];  // Title in first column
            boolean widgetAdded = dashboardPage.addWidget(title, module);
            if (!widgetAdded) {
                throw new RuntimeException("Failed to add widget with title: " + title + " and module: " + module);}
            boolean isTitleVisible = dashboardPage.verifyWidgetTitle(title);
            assertTrue("Widget title '" + title + "' is not visible.", isTitleVisible);
        }
    }


    @Then("^I should see the widgets from the Excel data$")
    public void thenIShouldVerifyWidgets() throws InterruptedException {
        // Loop through the Excel data to verify each widget
        for (Object[] row : excelData) {
            String title = (String) row[0];  // Title in first column
            String module = (String) row[1]; // Module in second column

            // Verify if the widget is visible on the page
            boolean isWidgetVisible = dashboardPage.verifyWidgetFromExcel(title, module);

            // Assert that the widget is visible
            Assert.assertTrue(isWidgetVisible, "Widget with title '" + title + "' and module '" + module + "' not found!");
        }
    }

    @Then("^I read the Excel data and test each widget$")
    public void readExcelAndTestEachWidget() throws IOException, InterruptedException {
        // Read data from the Excel file
        Object[][] excelData = ExcelReader.getExcelData("Excel/Excel.xlsx");

        for (Object[] row : excelData) {
            String title = (String) row[3]; // Title from Excel
            String module = (String) row[2]; // Module from Excel

            // Test each widget separately
            try {
                boolean widgetAdded = dashboardPage.addWidget(title, module);
                assertTrue("Failed to add widget with title: " + title + " and module: " + module, widgetAdded);

                boolean isTitleVisible = dashboardPage.verifyWidgetTitle(title);
                assertTrue("Widget title '" + title + "' is not visible.", isTitleVisible);

                System.out.println("Test passed for widget: " + title + " and module: " + module);
            } catch (Exception e) {
                // Log failure and move to the next widget
                System.err.println("Test failed for widget: " + title + " and module: " + module);
                e.printStackTrace();

                // Attach failure details to Allure if configured
                Allure.addAttachment("Failure Screenshot",
                        new ByteArrayInputStream(((TakesScreenshot) BrowserManager.getDriver()).getScreenshotAs(OutputType.BYTES)));
                Allure.addAttachment("Error Message", e.getMessage());
            }
        }
    }

}

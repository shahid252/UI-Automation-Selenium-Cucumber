package StepDefinitions;

import Utility.BrowserManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DashboardPage;

import static org.junit.Assert.assertTrue;

public class DashboardStepDefinition {
    private DashboardPage dashboardPage;

    @Then("^I verify widgets (.*) are displayed$")
    public void iVerifyWidgetAreDisplayed(String widgets) throws InterruptedException {
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
        String[] widgetList = widgets.split(",\\s*");
        Assert.assertEquals(dashboardPage.getBatchProcessingSummaryXpath(), widgetList[0]);
        Assert.assertEquals(dashboardPage.getExceptionSummaryXpath(), widgetList[1]);
        Assert.assertEquals(dashboardPage.getKPISXpath(), widgetList[2]);
        Assert.assertEquals(dashboardPage.getFinancialSettlementSummaryXpath(), widgetList[3]);
        Assert.assertEquals(dashboardPage.getReportingVarianceTrendXpath(), widgetList[4]);


    }

    @Then("^I verify widgets (.*) and his Data$")
    public void iVerifyWidgetAndHisData(String widget) throws InterruptedException {
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
        switch (widget) {
            case "LCR":
            case "Loans to Total Assets":
            case "NSFR":
            case "Liquid assets to deposit-borrowing ratio":
                dashboardPage.VerifyWidgetAndHisData(widget);
                break;
            case "Batch Processing Summary":
            case "Exception Summary":
            case "Financial Settlement":
            case "KPIs":
            case "Collateral Management":
                String[] widgets = widget.split(",");
                for (String widgetTitle : widgets) {
                    widgetTitle = widgetTitle.trim();
                    if (!widgetTitle.isEmpty()) {
                        dashboardPage.getWidgetDataText(widgetTitle);
                    }
                }
                break;
            case "Deposit by Counterparty Type":
            case "Reporting Variance Trend":
            case "Asset By Counterparty Type":
            case "Loan and Advances - Analysis":
            case "Loan & Advances by Collateral":
            case "Predictive Liquidity Coverage Ratio (PLCR)":
                boolean isTitleVisible = dashboardPage.verifyWidgetTitle(widget);
                assertTrue("Widget title '" + widget + "' is not visible.", isTitleVisible);
                break;
            default:
                System.out.println("No handling defined for widget: " + widget);
                break;
        }
    }


    @Then("^I go to reports$")
    public void iGoToReports() throws InterruptedException {
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
        dashboardPage.goToReports();
    }

    @Then("^I verify links of module$")
    public void iVerifyLinksOfModule() throws InterruptedException {
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
        dashboardPage.verifyTableLinks();
    }

    @Then("^I validate the count of grid items on the dashboard and Verify details of widgets$")
    public void validateGridItemCount() throws Exception {
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
        dashboardPage.validateCountOfGrids();
        dashboardPage.validateGridItemsData();

    }

    @And("^I verify details for all widget items$")
    public void verifyDetailsForGridItems() throws InterruptedException {
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
        dashboardPage.validateGridItemsData();

    }

    @Then("^I verify widget (.*) drill down functionality and verify it has Data$")
    public void iVerifyWidgetsDrillDownFunctionality(String widgetDrill) throws InterruptedException {
        dashboardPage = new DashboardPage(BrowserManager.getDriver());
        String[] widgets = widgetDrill.split(",");
        for (String widget : widgets) {
            String widgetTitle = widget.trim();
            if (!widgetTitle.isEmpty()) {
                dashboardPage.verifyAllWidgets(widgetTitle);
                switch (widgetDrill) {
                    case "Batch Processing Summary":
                        dashboardPage.verifyBatchProcessingSummaryTableHasData();
                        break;
                    case "Exception Summary":
                        dashboardPage.verifyExceptionSummaryTableHasData();
                        break;
                    case "Financial Settlement":
                        dashboardPage.verifyFinancialStatementSummaryTableHasData();
                        break;
                    case "KPIs":
                        dashboardPage.verifyKPIsSummaryTableHasData();
                        break;
                    default:
                        System.out.println("No specific verification for " + widgetDrill);
                        break;
                }
            }
        }
    }
}
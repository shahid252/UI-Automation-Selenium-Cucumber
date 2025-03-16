Feature: Verify Login And Widgets on dashboardPage

  Background: login
    Given I am on the login page
    When I enter username  regulatoryreporting@focusync.com and password $Admin#1
    And I click on the login button
    Then I am logged in and on the dashboard page

  @Verify_Widgets @Regression
  Scenario: 02_Verifying Widgetss on dashboard Page
    Then I validate the count of grid items on the dashboard and Verify details of widgets

  @DrillDown @Regression
  Scenario Outline: 03_Verifying Widgets Drill Down Data
    Then I verify widget <widgetDrill> drill down functionality and verify it has Data
    Examples:
      | widgetDrill              |
      | Batch Processing Summary |
      | Financial Settlement     |
      | Exception Summary        |
      | KPIs                     |


  @ReportLinks @Regression
  Scenario: 04_Verifying Links
    And I go to reports
    Then I verify links of module


#    Then I verify details for all widget items

#  Scenario Outline: Login With Invalid Credentials
#    Given I am on the login page
#    When I enter username  <username> and password <password>
#    And I click on the login button
#    Then Invalid credentials error should be shown
#
#    Examples:
#      | username          | password |
#      | abcd@focusync.com | $rTmin#1 |

# xpath for top widget //p[contains(@class, 'top-head') and text()='NSFR']/ancestor::div[contains(@class, 'col-custom')][1]//h4[contains(@class, 'card-amount')]//span
#
#
#  Scenario Outline: Verify KPI widgets addition
#    Given I am on the login page
#    When I login with username regulatoryreporting@focusync.com and password $Admin#1
#    And I add widget <widgetTitle> from <widgetModule>
#    Then I verify the widget on the dashboard page <widgetTitle>
#
#    Examples:
#      | widgetTitle                                     | widgetModule |
#      | Account Summary Last 12 Month Opened/Close      | KPI          |
#      | Actual Vs Budget                                | KPI          |
#      | Average Transaction by Users                    | KPI          |
#      | Average Transaction Count                       | KPI          |
#      | Branch wise Performance Target vs Actual (Loan) | KPI          |
#      | Customer Summary                                | KPI          |
#
#  Scenario Outline: Verify Liabilities widgets addition
#    Given I am on the login page
#    When I login with username regulatoryreporting@focusync.com and password $Admin#1
#    And I add widget <widgetTitle> from <widgetModule>
#    Then I verify the widget on the dashboard page <widgetTitle>
#
#    Examples:
#      | widgetTitle                    | widgetModule |
#      | Collateral Limit               | Liabilities  |
#      | Country Limit                  | Liabilities  |
#      | Customer Balance               | Liabilities  |
#      | Customer Detail                | Liabilities  |
#      | Customer Relationship          | Liabilities  |
#      | Customer with Deposit above 5M | Liabilities  |
#
#  Scenario Outline: Verify Liquidity widgets addition
#    Given I am on the login page
#    When I login with username regulatoryreporting@focusync.com and password $Admin#1
#    And I add widget <widgetTitle> from <widgetModule>
#    Then I verify the widget on the dashboard page <widgetTitle>
#
#    Examples:
#      | widgetTitle                                             | widgetModule |
#      | Consolidated Throughput                                 | Liquidity    |
#      | Total Outlfow by Type                                   | Liquidity    |
#      | Consolidated Throughput (Major Currency)                | Liquidity    |
#      | Cumulated net funding gap vs Cumulated Counterbalancing | Liquidity    |
#      | Intraday Consolidated                                   | Liquidity    |
#      | LCR C76                                                 | Liquidity    |
#


#  Scenario: Add and verify widgets from Excel data
#    Given I am on the login page
#    And I login with username regulatoryreporting@focusync.com and password $Admin#1
#    Then I read the Excel data and test each widget
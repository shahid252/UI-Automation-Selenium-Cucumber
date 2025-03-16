# UI Automation Project

## Project Overview
This project is a UI automation framework developed using **Selenium** with **Java** and **Cucumber**, following the **Page Object Model (POM)** design pattern. It uses **TestNG** for test execution, **Allure** for reporting, and **Maven** for build management.

The test scenarios are tagged appropriately, with `@Regression` being used to execute all test scenarios.

## Tech Stack
- **Programming Language:** Java
- **Automation Framework:** Selenium
- **BDD Framework:** Cucumber
- **Test Runner:** TestNG
- **Reporting:** Allure
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)

## Project Structure
```
UI-Automation-Project/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- pages/          # Page Object Model classes
|   |   |   |-- utils/          # Utility classes
|   |-- test/
|   |   |-- java/
|   |   |   |-- stepDefinitions/ # Step definitions for Cucumber
|   |   |   |-- runners/         # Test runners
|   |   |   |-- hooks/           # Hooks for setup and teardown
|   |   |   |-- tests/           # Test execution scripts
|-- features/                    # Cucumber feature files
|-- pom.xml                       # Maven dependencies
|-- testng.xml                    # TestNG configuration
|-- README.md                     # Project documentation
```

## Installation & Setup
### Prerequisites
- Install **Java** (JDK 11 or later)
- Install **Maven**
- Install **Allure** for reporting
- Install **IntelliJ IDEA** or **Eclipse** (Recommended IDEs)
- Configure **WebDriver** (ChromeDriver, GeckoDriver, etc.)

### Clone the Repository
```sh
git clone <https://github.com/shahid252/UI-Automation-Selenium-Cucumber.git>
```

### Install Dependencies
```sh
mvn clean install
```

## Running the Tests
### Run all scenarios with TestNG
```sh
mvn test
```

### Run specific scenarios using Cucumber tags
To run only `@Regression` scenarios:
```sh
mvn test -Dcucumber.options="--tags @Regression"
```

### Generate Allure Reports
```sh
mvn allure:report
```
To view the report:
```sh
allure serve target/allure-results
```

## Reporting
- **Allure Reports**: Generates interactive HTML reports



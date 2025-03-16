package Hooks;


import Utility.BrowserManager;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;

public class Hooks {

    @BeforeAll
    public static void setup() throws InterruptedException {
        BrowserManager.setupDriver("http://51.68.195.149/Tarramis.MIS.V3.Demo/mis/dashboard");
//        BrowserManager.setupDriver("http://54.38.75.50/TARRAMIS.MIS.Partitioning/auth/login");

    }

    @After
    public void takeScreenshot(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) BrowserManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
    }

    @AfterAll
    public static void cleanUp() {
        BrowserManager.closeDriver();
    }
}

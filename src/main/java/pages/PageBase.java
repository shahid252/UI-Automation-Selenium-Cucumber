package pages;

import org.openqa.selenium.WebDriver;
import pages.helpers.*;

import java.util.logging.Logger;

public class PageBase implements WebDriverContainer, Clickable, Conditionable, Fillable, Findable, Getable, Waitable {

    protected static Logger logger = Logger.getLogger(PageBase.class.getName());

    protected WebDriver driver;

    protected PageBase(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }



}


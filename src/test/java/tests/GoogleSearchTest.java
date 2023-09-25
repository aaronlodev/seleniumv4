package tests;

import com.hexaware.framework.DriverBuilder;
import com.hexaware.framework.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.google.GoogleHomePage;

public class GoogleSearchTest {

    WebDriver driver;
    GoogleHomePage homePage;


    @BeforeClass
    public void initWebDriver() throws Exception {
        driver = new DriverBuilder(DriverType.SauceLabsMobileWeb).build();
        homePage = new GoogleHomePage(driver);
    }

    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");
        homePage.search("Hexaware", Keys.ENTER);
        homePage.clickOnLink();
        Assert.assertEquals(homePage.getCurrentURL(), "https://hexaware.com/");


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

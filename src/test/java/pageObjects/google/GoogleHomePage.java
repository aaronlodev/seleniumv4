package pageObjects.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleHomePage {

    WebDriver driver;
    WebDriverWait wait;
    By searchInput = By.name("q");
    By hexawareLink = By.partialLinkText("Hexaware Technologies |");


    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void search(CharSequence... text) {
        driver.findElement(searchInput).sendKeys(text);
    }

    public void clickOnLink() {
        wait.until(ExpectedConditions.elementToBeClickable(hexawareLink)).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }


}

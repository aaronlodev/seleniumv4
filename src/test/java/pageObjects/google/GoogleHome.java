package pageObjects.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHome {

    WebDriver driver;

    By searchInput = By.name("q");

    public GoogleHome(WebDriver driver){
        this.driver = driver;
    }

    public void search(String text){
        driver.findElement(searchInput).sendKeys(text);
    }



}

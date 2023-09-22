package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptTests {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeClass
    public void initDriver() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void selectDateTimePickerTest() {
        driver.get("https://demoqa.com/date-picker");

        WebElement datePicker = driver.findElement(By.id("dateAndTimePickerInput"));
        wait.until(ExpectedConditions.visibilityOf(datePicker)).click();

        WebElement selectedDay = driver.findElement(By.xpath("//div[@role=\"option\" and text()=\"22\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectedDay)).click();

        WebElement selectedHour = driver.findElement(By.xpath("//li[text()=\"19:30\"]"));

        WebElement timePicker = driver.findElement(By.className("react-datepicker__time-list"));
        js.executeScript("arguments[0].scrollBy(0," + selectedHour.getLocation().x + "); arguments[1].click()", timePicker, selectedHour);
        //selectedHour.click();

    }

    @Test
    public void scrollBrowserWindow() throws Exception {
        try{
            driver.get("https://demoqa.com/date-picker");
            js.executeScript("window.scrollBy(0, 500)");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }




}

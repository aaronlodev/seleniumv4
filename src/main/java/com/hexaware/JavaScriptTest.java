package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptTest {

    WebDriver driver;
    JavascriptExecutor js;

    WebDriverWait wait;
    @BeforeClass
    public void initDriver(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void scrollUsingJSTest(){
        driver.get("https://www.hexaware.com");
        js.executeScript("window.scrollBy(0, 1000)");
    }

    @Test
    public void dateTimePickerUsingJSTest() throws InterruptedException {
        driver.get("https://demoqa.com/date-picker");

        WebElement datetimePicker = driver.findElement(By.id("dateAndTimePickerInput"));
        wait.until(ExpectedConditions.visibilityOf(datetimePicker)).click();

        WebElement month = driver.findElement(By.xpath("//button[@aria-label=\"Next Month\"]"));
        wait.until(ExpectedConditions.visibilityOf(month)).click();

        WebElement day = driver.findElement(By.xpath("//*[@role=\"option\" and text()=\"25\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(day)).click();

        WebElement time = driver.findElement(By.xpath("//li[text()=\"08:00\"]"));
        //wait.until(ExpectedConditions.visibilityOf(time)).click();

        WebElement timePicker = driver.findElement(By.className("react-datepicker__time-list"));
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollBy(0," + time.getLocation().x + "); arguments[1].click()", timePicker, time);

        Thread.sleep(20000);

    }

    @AfterClass
    public void tearDown(){
        if (driver != null)
            driver.quit();
    }


}

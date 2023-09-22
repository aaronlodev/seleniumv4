package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsTest {

    WebDriver driver;
    @BeforeClass
    public void initDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearchUsingActions(){
        driver.get("https://www.google.com");

        WebElement searchInput = driver.findElement(By.name("q"));
        Actions action = new Actions(driver);
        action.sendKeys(searchInput, "Selenium", Keys.ENTER).perform();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(draggable, droppable).perform();

        Thread.sleep(10000);

    }


    @Test
    public void wheelActionTest() throws InterruptedException {
        driver.get("https://www.hexaware.com");

        WebElement footer = driver.findElement(By.tagName("footer"));
        int y  = footer.getRect().y;

        new Actions(driver)
                .scrollByAmount(0, y).perform();

        Thread.sleep(5000);

    }




    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}

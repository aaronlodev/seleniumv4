package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsAPI {

    WebDriver driver;
    @BeforeClass
    public void initDriver(){
        driver = new ChromeDriver();
    }


    @Test
    public void sendKeys(){


        driver.get("https://www.google.com");

        WebElement searchInput = driver.findElement(By.name("q"));

        Actions action = new Actions(driver);
        action.sendKeys(searchInput, "Hexaware", Keys.ENTER)
                .perform();

    }

    @Test
    public void dragAndDrop(){
        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
    }

    public void clickAndHold(){

    }



}

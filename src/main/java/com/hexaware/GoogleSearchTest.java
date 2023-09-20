package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleSearchTest {


    static WebDriver driver;
    static String BASE_URL = "https://www.google.com";

    public static void main(String[] args) throws Exception {


        try {


            driver = new ChromeDriver();

            // 1. Navigate to google.com website
            // driver.navigate().to(BASE_URL);
            // driver.get(BASE_URL);

            driver.navigate().to(BASE_URL);

            //WebElement textarea_search = driver.findElement(By.name("q"));
            //textarea_search.sendKeys("Selenium", Keys.ENTER);

            /*Thread.sleep(5000);
            driver.navigate().back();
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(5000);
            driver.navigate().forward();
            System.out.println(driver.getCurrentUrl());
            //driver.navigate().refresh();
            System.out.println(driver.getTitle());*/

            // Clear the input search

            WebElement search = driver.findElement(By.name("q"));
            //search.clear();
            search.sendKeys("Hexaware", Keys.ENTER);
            driver.findElement(By.partialLinkText("Hexaware Technologies | IT Services")).click();

            // driver.close()
            // close the window
            Assert.assertEquals(driver.getCurrentUrl(), "https://hexaware.com");


            // close the windows and remove or stop the driver process
            driver.quit();


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

}

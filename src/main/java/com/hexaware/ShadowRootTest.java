package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class ShadowRootTest {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeClass
    public void initDriver(){
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void shadowRootTest(){
        driver.get("http://watir.com/examples/shadow_dom.html");
        WebElement root = driver.findElement(By.id("shadow_host"));
        WebElement span_text = root.getShadowRoot().findElement(By.cssSelector("#shadow_content span"));
        System.out.println(span_text.getText());

        WebElement nested_host = root.getShadowRoot().findElement(By.cssSelector("#nested_shadow_host"));
        WebElement nested_content = nested_host.getShadowRoot().findElement(By.cssSelector("#nested_shadow_content div"));
        System.out.println(nested_content.getText());


    }

    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}

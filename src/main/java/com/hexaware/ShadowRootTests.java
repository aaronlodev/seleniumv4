package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShadowRootTests {

    WebDriver driver;
    @BeforeClass
    public void initDriver(){

        // Browser Options

        driver = new ChromeDriver();
    }

    @Test
    public void shadowRootTest(){
        driver.get("http://watir.com/examples/shadow_dom.html");

        WebElement root = driver.findElement(By.id("shadow_host"));
        WebElement  shadow_content = root.getShadowRoot().findElement(By.cssSelector("#shadow_content span"));
        System.out.println(shadow_content.getText());

        WebElement nested_host = root.getShadowRoot().findElement(By.cssSelector("#nested_shadow_host"));
        WebElement nested_content = nested_host.getShadowRoot().findElement(By.cssSelector("#nested_shadow_content div"));
        System.out.println(nested_content.getText());


    }

}

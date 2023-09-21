package com.hexaware;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationPracticeTest {

    WebDriver driver;
    @BeforeClass
    public void initDriver() throws Exception {
        try{

            /*ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized", "incognito");*/

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://automationexercise.com");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Test(enabled = false, priority = 1)
    public void registerUserTest() throws InterruptedException {

        // Click on the sign up login button => xpath => //a[text()=" Signup / Login"]
        driver.findElement(By.xpath("//a[text()=\" Signup / Login\"]")).click();

        // verify text is visible => xpath => //*[@id="form"]/div/div/div[3]/div/h2
        WebElement new_user_label = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        if(new_user_label.isDisplayed()){
            driver.findElement(By.name("name")).sendKeys("Joe Doe");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[type=email]:nth-child(3)")).sendKeys("joe.doe@email.com");
            driver.findElement(By.xpath("//button[@type=\"submit\" and text()=\"Signup\"]")).click();

            // type password
            driver.findElement(By.id("password")).sendKeys("Password@1");


            // Contact Information Page
            Select s;
            WebElement days = driver.findElement(By.id("days"));
            s = new Select(days);
            s.selectByVisibleText("20");

            WebElement months = driver.findElement(By.id("months"));
            s = new Select(months);
            s.selectByVisibleText("July");

            WebElement years = driver.findElement(By.id("years"));
            s = new Select(years);
            s.selectByVisibleText("2000");


            // first_name
            driver.findElement(By.id("first_name")).sendKeys("Joe");

            // last_name
            driver.findElement(By.id("last_name")).sendKeys("Doe");

            // address1
            driver.findElement(By.id("address1")).sendKeys("Random Address");

            // country
            WebElement country = driver.findElement(By.id("country"));
            s = new Select(days);
            s.selectByIndex(1);

            // state
            driver.findElement(By.id("state")).sendKeys("Texas");

            // city
            driver.findElement(By.id("city")).sendKeys("Colony");

            // zipcode
            driver.findElement(By.id("zipcode")).sendKeys("75056");

            // mobile number
            driver.findElement(By.id("mobile_number")).sendKeys("1234567891");

            // button
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

            // verify Account Created message is visible => xpath - //b[text()="Account Created!"]
            WebElement accountCreatedMsg = driver.findElement(By.xpath("//b[text()=\"Account Created!\"]"));

            Assert.assertEquals(accountCreatedMsg.getText(), "ACCOUNT CREATED!");

            // click on continue button
            WebElement continueBtn = driver.findElement(By.xpath("/html/body/section/div/div/div/div/a"));
            if(continueBtn.isEnabled()){
                continueBtn.click();

                driver.switchTo().frame("aswift_1");
                driver.findElement(By.id("dismiss-button")).click();


                String userName = driver.findElement(By.cssSelector(".nav li:last-child a b")).getText();
                Assert.assertEquals(userName, "Joe Doe");

                driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();


                // Delete Account btn
                //driver.findElement(By.cssSelector("a[href=\"/delete_account\"]")).click();

                //WebElement deleteMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p[1]"));

                //Assert.assertEquals(deleteMsg.getText(), "Your account has been permanently deleted!");

                //click on continue button
                //driver.findElement(By.xpath("/html/body/section/div/div/div/div/a")).click();


                //System.out.println("HomePage title: " + driver.getTitle());
                //System.out.println("Current Url: " + driver.getCurrentUrl());

            }


        }else {
            System.out.println("Element is not visible");
        }

        // type user => name => name

        // type email => name => email

        // click on the sign up button => xpath => //button[@type="submit" and text()="Signup"]

    }


    @Test(enabled = false)
    public void loginValidUser() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()=\" Signup / Login\"]")).click();

        driver.findElement(By.xpath("//*[@data-qa=\"login-email\"]")).sendKeys("joe.doe@email.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-qa=\"login-password\"]")).sendKeys("Password@1");
        driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();

        String userName = driver.findElement(By.cssSelector(".nav li:last-child a b")).getText();
        Assert.assertEquals(userName, "Joe Doe");
    }

    @Test
    public void loginInvalidUser() {
        driver.findElement(By.xpath("//a[text()=\" Signup / Login\"]")).click();

        driver.findElement(By.xpath("//*[@data-qa=\"login-email\"]")).sendKeys("joe.doe@email.com");
        driver.findElement(By.xpath("//*[@data-qa=\"login-password\"]")).sendKeys("Password@123123");
        driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));

        if (errorMsg.isDisplayed())
            Assert.assertEquals(errorMsg.getText(), "Your email or password is incorrect!");


    }


    @AfterClass
    public void tearDown(){
        if (driver != null){
            System.out.println("Exit browser");
            driver.quit();
        }
    }

}

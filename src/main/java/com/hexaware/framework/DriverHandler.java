package com.hexaware.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverHandler {

    public WebDriver driver;
    public WebDriverWait wait;

    public JavascriptExecutor js;


    public DriverHandler(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }


    protected void PerformAction(SeleniumAction action, WebElement element, String value) throws Exception {

        try {

            Highlight(element);

            switch (action) {

                case SelectByIndex:
                    selectByIndex(element, Integer.parseInt(value));
                    break;

                case SelectByText:
                    selectByText(element, value);
                    break;

                case SelectByValue:
                    selectByValue(element, value);
                    break;

                case Type:
                    Type(element, value);
                    break;

                case Click:
                    Click(element);
                    break;

                case SwitchToFrame:
                    SwitchToFrameByIdOrName(value);
                    break;
                case SwitchToFrameByIndex:
                    SwitchToFrameByIdex(Integer.parseInt(value));
                    break;

                case Quit:
                    Quit();
                    break;


            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    private void selectByIndex(WebElement element, int value) throws Exception {

        try {
            Select s = new Select(element);
            s.selectByIndex(value);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }finally {
            clearHighlight(element);
        }
    }

    private void selectByText(WebElement element, String value) throws Exception {

        try {
            Select s = new Select(element);
            s.selectByVisibleText(value);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }finally {
            clearHighlight(element);
        }
    }

    private void selectByValue(WebElement element, String value) throws Exception {

        try {
            Select s = new Select(element);
            s.selectByValue(value);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }finally {
            clearHighlight(element);
        }
    }


    private void Type(WebElement element, String value) {
        try {

            scrollIntoView(element);
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            clearHighlight(element);
        }
    }

    private void SwitchToFrameByIdOrName(String idOrName) throws Exception {
        try {


            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName)).switchTo().frame(idOrName);

            //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(idOrName))).switchTo().frame(idOrName);
        } catch (NoSuchFrameException e) {
            throw new Exception(e.getMessage());
        }
    }

    private void SwitchToFrameByIdex(int index) throws Exception {
        try {

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index)).switchTo().frame(index);

        } catch (NoSuchFrameException e) {
            throw new Exception(e.getMessage());
        }
    }


    private void Click(WebElement element) throws Exception {
        try {
            clearHighlight(element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void Quit() throws Exception {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void Highlight(WebElement element) {
        //JavascriptExecutor js = (JavascriptExecutor) this.driver;
        String border = "#f00 solid 5px";
        js.executeScript("arguments[0].style.outline = '" + border + "'; ", element);
    }

    private void clearHighlight(WebElement element) {
        //JavascriptExecutor js = (JavascriptExecutor) this.driver;
        String border = "#f00 solid 0px";
        js.executeScript("arguments[0].style.outline = '" + border + "'; ", element);
    }

    private void scrollIntoView(WebElement element) {
        //JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


}

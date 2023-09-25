package pageObjects.automationPractice;

import com.hexaware.framework.DriverHandler;
import com.hexaware.framework.SeleniumAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends DriverHandler {


    @FindBy(css = ".nav li:last-child a b")
    public WebElement loggedUser;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    public WebElement deleteAccountLink;

    @FindBy(xpath = "//*[@data-qa=\"continue-button\"]")
    public WebElement deleteAccountBtn;

    WebDriver driver;
    //WebDriverWait wait;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void closeFrameIfExists() {


        if (driver.findElement(By.name("aswift_1")).isDisplayed()) {
            driver.switchTo().frame("aswift_1");

            driver.switchTo().frame(0);
            driver.findElement(By.xpath("//*[text()=\"Close\"]")).click();

            /*if (driver.findElement(By.cssSelector("#dismiss-button svg")).isDisplayed()) {
                driver.findElement(By.cssSelector("#dismiss-button svg")).click();

            } else {
                driver.switchTo().frame(0);
                driver.findElement(By.xpath("//*[text()=\"Close\"]")).click();
            }*/

            driver.switchTo().defaultContent();
        }
    }

    public String getLoggerUser() throws Exception {
        try {
            return loggedUser.getText();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public void deleteAccount() throws Exception {

        PerformAction(SeleniumAction.Click, deleteAccountLink, null);
        Thread.sleep(10000);
        PerformAction(SeleniumAction.Click, deleteAccountBtn, null);

    }


}

package pageObjects.automationPractice;

import com.hexaware.framework.DriverHandler;
import com.hexaware.framework.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationHomePage extends DriverHandler {

    @FindBy(xpath = "//a[text()=\" Signup / Login\"]")
    public WebElement signUpBtn;

    public AutomationHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}

package pageObjects.automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationHomePage {

    @FindBy(xpath = "//a[text()=\" Signup / Login\"]")
    public WebElement signUpBtn;

    public AutomationHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}

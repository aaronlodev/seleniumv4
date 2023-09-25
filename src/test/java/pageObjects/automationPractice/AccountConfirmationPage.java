package pageObjects.automationPractice;

import com.hexaware.framework.DriverHandler;
import com.hexaware.framework.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountConfirmationPage extends DriverHandler {


    @FindBy(xpath = "//b[text()=\"Account Created!\"]")
    public WebElement successConfirmationMsg;

    @FindBy(xpath = "/html/body/section/div/div/div/div/a")
    public WebElement continueBtn;


    public String getConfirmationMessage() {
        return successConfirmationMsg.getText();
    }

    public void clickOnContinue() throws Exception {
        PerformAction(SeleniumAction.Click, continueBtn, null);
    }

    public AccountConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}

package pageObjects.automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(css = ".signup-form h2")
    public WebElement userSingUpLabel;

    @FindBy(name = "name")
    public WebElement userNameInput;

    @FindBy(css = "input[type=email]:nth-child(3)")
    public WebElement userEmailInput;

    @FindBy(xpath = "//button[@type=\"submit\" and text()=\"Signup\"]")
    public WebElement signUpBtn;



    public void signUp(String username, String email){
        userNameInput.sendKeys(username);
        userEmailInput.sendKeys(email);
        signUpBtn.click();
    }

    public boolean isSignUpDisplayed(){
        return userSingUpLabel.isDisplayed();
    }

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



}

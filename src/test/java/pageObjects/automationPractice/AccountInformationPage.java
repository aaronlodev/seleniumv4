package pageObjects.automationPractice;

import com.hexaware.framework.DriverHandler;
import com.hexaware.framework.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountInformationPage extends DriverHandler {


    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "days")
    public WebElement selectDay;

    @FindBy(id = "months")
    public WebElement selectMonth;

    @FindBy(id = "years")
    public WebElement selectYear;

    @FindBy(id = "first_name")
    public WebElement firstNameInput;

    @FindBy(id = "last_name")
    public WebElement lastNameInput;

    @FindBy(id = "address1")
    public WebElement addressInput;

    @FindBy(id = "country")
    public WebElement selectCountry;

    @FindBy(id = "state")
    public WebElement stateInput;

    @FindBy(id = "city")
    public WebElement cityInput;


    @FindBy(id = "zipcode")
    public WebElement zipCodeInput;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitBtn;


    public void fillAccountForm(String password, String day, String month, String year, String firstName,
                                String lastName, String address, String country, String state, String city, String zipCode,
                                String mobilePhone) throws Exception {

        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        PerformAction(SeleniumAction.SelectByText, selectDay, day);
        PerformAction(SeleniumAction.SelectByText, selectMonth, month);
        PerformAction(SeleniumAction.SelectByText, selectYear, year);
        PerformAction(SeleniumAction.Type, firstNameInput, firstName);
        PerformAction(SeleniumAction.Type, lastNameInput, lastName);
        PerformAction(SeleniumAction.Type, addressInput, address);
        PerformAction(SeleniumAction.SelectByIndex, selectCountry, country);
        PerformAction(SeleniumAction.Type, stateInput, state);
        PerformAction(SeleniumAction.Type, cityInput, city);
        PerformAction(SeleniumAction.Type, zipCodeInput, zipCode);
        PerformAction(SeleniumAction.Type, mobileNumberInput, mobilePhone);
        PerformAction(SeleniumAction.Click, submitBtn, null);


    }


    WebDriverWait wait;

    public AccountInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


}

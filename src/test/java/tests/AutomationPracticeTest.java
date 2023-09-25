package tests;

import com.hexaware.framework.DriverBuilder;
import com.hexaware.framework.DriverHandler;
import com.hexaware.framework.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.automationPractice.*;

public class AutomationPracticeTest {

    WebDriver driver;
    AutomationHomePage homePage;
    LoginPage loginPage;

    AccountInformationPage accountPage;
    AccountConfirmationPage confirmationPage;

    UserPage userPage;


    @BeforeClass
    public void initDriver() throws Exception {
        driver = new DriverBuilder(DriverType.Chrome).withDefaultOptions().build();
        homePage = new AutomationHomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountInformationPage(driver);
        confirmationPage = new AccountConfirmationPage(driver);
        userPage = new UserPage(driver);
    }

    @Test
    public void signUpNewUser() throws Exception {
        driver.get("http://automationexercise.com");
        homePage.signUpBtn.click();
        Assert.assertTrue(loginPage.isSignUpDisplayed());

        loginPage.signUp("Joe Doe", "joe.doe2@email.com");
        accountPage.fillAccountForm("Password@1", "8", "July", "1994",
                "Joe", "Doe", "Random Address", "1", "Texas", "Colony",
                "75056", "1234567891");

        Assert.assertEquals(confirmationPage.getConfirmationMessage(), "ACCOUNT CREATED!");
        confirmationPage.clickOnContinue();

        userPage.closeFrameIfExists();

        Assert.assertEquals(userPage.getLoggerUser(), "Joe Doe");

        userPage.deleteAccount();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

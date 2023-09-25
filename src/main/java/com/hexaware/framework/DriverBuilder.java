package com.hexaware.framework;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverBuilder {


    private DriverType driverType;
    private String[] defaultOptions;

    public DriverBuilder(DriverType driverType) {
        this.driverType = driverType;
    }

    public DriverBuilder withDefaultOptions() {

        switch (driverType) {
            case Chrome:
                defaultOptions = new String[]{"--disable-notifications", "--start-maximized", "disable-popup-blocking"};
                break;
            case FireFox:
                defaultOptions = new String[]{"marionette"};
                break;

            default:
                break;
        }

        return this;
    }

    public WebDriver build() throws Exception {
        try {


            WebDriver driver = null;
            switch (driverType) {
                case Chrome:
                    ChromeOptions options = (ChromeOptions) getOptions(defaultOptions);
                    driver = new ChromeDriver(options);
                    break;
                case FireFox:
                    FirefoxOptions fx_options = (FirefoxOptions) getOptions(defaultOptions);
                    driver = new FirefoxDriver(fx_options);
                    break;

                case SauceLabs:
                    ChromeOptions browserOptions = getChromeOptions();

                    URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    driver = new RemoteWebDriver(url, browserOptions);
                    break;

                case SauceLabsMobileWeb:
                    MutableCapabilities caps = getMutableCapabilities();
                    URL url2 = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    driver = new AndroidDriver(url2, caps);
                    break;


            }


            return driver;


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static MutableCapabilities getMutableCapabilities() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:deviceName", "Samsung.*");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-aaronlopez.dev-843c8");
        sauceOptions.setCapability("accessKey", "81db1735-3692-46be-b15b-a75ebb7cf090");
        sauceOptions.setCapability("build", "1.0");
        sauceOptions.setCapability("name", "Google Search");
        caps.setCapability("sauce:options", sauceOptions);
        return caps;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-aaronlopez.dev-843c8");
        sauceOptions.put("accessKey", "81db1735-3692-46be-b15b-a75ebb7cf090");
        sauceOptions.put("build", "selenium-build-ZBM0L");
        sauceOptions.put("name", "Aaron Lopez");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }

    /*
     *
     *
     * */


    private Object getOptions(String... opts) {

        switch (driverType) {


            case Chrome:
                ChromeOptions options = new ChromeOptions();
                return options.addArguments(opts);
            case FireFox:
                FirefoxOptions fx_options = new FirefoxOptions();
                return fx_options.addArguments(opts);

            default:
                break;
        }

        return null;
    }


}

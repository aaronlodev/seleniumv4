package com.hexaware.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

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
            }


            return driver;


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

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

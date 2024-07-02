package com.pretty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Objects;

import static com.pretty.constants.Constants.CHROME;
import static com.pretty.constants.Constants.FIREFOX;

public class DriverFactory {

    static WebDriver  driver;

    public static WebDriver getDriver(String browserType) {
        if (Objects.isNull(driver)) {
            switch (browserType) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException(browserType + "is not a valid one");
            }
        }
        return driver;

    }

    public static void quitDriver() {
        if(Objects.nonNull(driver)) {
            driver.quit();
        }
    }

}

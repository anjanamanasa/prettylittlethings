package com.pretty.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pretty.config.ConfigProperties;
import com.pretty.DriverFactory;
import com.pretty.utils.PLTUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.pretty.constants.Constants.BROWSER;
import static com.pretty.constants.Constants.URL;

public class BaseTest {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static WebDriver driver;
    public static ConfigProperties configProperties;

    @BeforeSuite
    public void setUpReport() {
        configProperties = new ConfigProperties();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver(configProperties.getProperty(BROWSER));
        driver.get(configProperties.getProperty(URL));
        driver.manage().window().maximize();
        PLTUtil.setWait(driver);

    }

    @AfterTest
    public void tearDown() {
        DriverFactory.quitDriver();
    }


    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}

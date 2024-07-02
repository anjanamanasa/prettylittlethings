package com.pretty.pages;

import com.pretty.utils.PLTUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PLTSpinnerPage {
    WebDriver driver;
    private Wait<WebDriver> wait;
    @FindBy(className="app-loading-spinner")
    WebElement pltSpinner;
    public  PLTSpinnerPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean isSpinnerShowing() {
        PLTUtil.waitForVisibilityOf(pltSpinner);
        return pltSpinner.isDisplayed();
    }
}

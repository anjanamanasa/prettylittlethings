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

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement cookie;

    @FindBy(id="clothing")
    WebElement cloth;
    public HomePage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }


    public void selectCategory() {
        PLTUtil.waitForInvisibilityOf(cookie);
        cloth.click();
    }

    public void acceptCookies() {
        PLTUtil.waitForVisibilityOf(cookie);
        cookie.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

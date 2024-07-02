package com.pretty.pages;

import com.pretty.utils.PLTUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PaymentPage {

    private WebDriver driver;

    @FindBy(xpath="//span[text() ='Pay with card']")
    WebElement payment;
    public PaymentPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        PLTUtil.waitForVisibilityOf(payment);
    }
    public void selectPaymentOption(){
        PLTUtil.waitForVisibilityOf(payment);
        payment.click();
    }
}

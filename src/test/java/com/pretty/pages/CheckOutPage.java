package com.pretty.pages;

import com.pretty.utils.PLTUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    private WebDriver driver;

    @FindBy(id="customer-email")
    WebElement email;

    @FindBy(xpath="//span[text()='Continue']")
    WebElement continueButton;

    @FindBy(id="customer-password")
    WebElement customerPassword;


    public CheckOutPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public void enterUserName(String userName) {
        PLTUtil.waitForVisibilityOf(email);
        email.sendKeys(userName);
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }
    public void enterPassword(String password){
        PLTUtil.waitForVisibilityOf(customerPassword);
        customerPassword.sendKeys(password);
    }
}

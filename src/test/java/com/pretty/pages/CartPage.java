package com.pretty.pages;

import com.pretty.utils.PLTUtil;
import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;

    @FindBy(id="checkout-button-bottom-sticky")
    WebElement checkoutButton;

    @FindBy(xpath = "//div[@id ='cart-table-header']//..//ul//li//div//a")
    WebElement productName;

    @FindBy(xpath="//span[contains(., 'Clothes Size')]")
    WebElement productSize;

    @FindBy(xpath = "//div[@id='cart-subtotal']//*[text()[contains(., '£')]]")
    WebElement subTotal;

    public CartPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void proceedToCheckout() {
        PLTUtil.waitForVisibilityOf(checkoutButton);
        checkoutButton.click();
    }

    public String getProductSize() {
        PLTUtil.waitForVisibilityOf(productSize);
        return PLTUtil.stripProductSize(productSize.getText());
    }

    public String getProductName() {
        PLTUtil.waitForVisibilityOf(productName);
        return productName.getText();
    }

    public String getSubTotal() {
        PLTUtil.waitForVisibilityOf(subTotal);
        return subTotal.getText();
    }
}

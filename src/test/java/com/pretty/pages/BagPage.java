package com.pretty.pages;

import com.pretty.utils.PLTUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BagPage {

    private WebDriver driver;

    @FindBy(className = "bag-item__name")
    WebElement productName;

    @FindBy(xpath = "//ul[@class = 'bag-item__details-list']//li[contains(., 'Clothes Size')]")
    WebElement productSize;

    @FindBy(xpath = "//li[@class = 'bag__totals-item subtotal']//span[contains(., '£')]")
    WebElement subTotal;

    @FindBy(xpath = "//li[@class = 'bag__totals-item']//span[contains(., '£')]")
    WebElement saverDelivery;

    @FindBy(xpath = "//li[@class = 'bag__totals-item grand-total']//span[contains(., '£')]")
    WebElement grandTotal;

    public BagPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public String getProductName() {
        PLTUtil.waitForVisibilityOf(productName);
        return productName.getText();
    }
    public String getProductSize() {
        PLTUtil.waitForVisibilityOf(productSize);
        return PLTUtil.stripProductSize(productSize.getText());
    }
    public String getSubTotal() {
        return subTotal.getText();
    }
    public String getDeliveryTotal() {
        PLTUtil.waitForVisibilityOf(saverDelivery);
        return saverDelivery.getText();
    }
    public String getGrandTotal() {
        return grandTotal.getText();
    }
}

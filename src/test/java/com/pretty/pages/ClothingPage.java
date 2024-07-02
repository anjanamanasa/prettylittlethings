package com.pretty.pages;

import com.pretty.utils.PLTUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class ClothingPage {

    private WebDriver driver;
    private ProductPage productPage;

    @FindBy(xpath = "//div[@id='plp-product-list']//div[@role='listitem']//a")
    List<WebElement> products;
    public ClothingPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void selectProduct(int position){
        products.get(position).findElement(By.xpath("..//a")).click();
    }

    public int getProductsCount() {
        return products.size();
    }
}

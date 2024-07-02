package com.pretty.pages;

import com.pretty.utils.PLTUtil;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.collections.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static com.pretty.constants.Constants.SIZE_GUIDE;

public class ProductPage {

    private WebDriver driver;

    private WebElement chosenSize;

    @FindBy(xpath="//div[@data-testid='breadcrumbs-and-main-container']//*[contains(text(), 'Size:')]//..//button")
    List<WebElement> productSizes;

    @FindBy(id="pdp-name")
    WebElement productName;

    @FindBy(id="add-to-bag-button")
    WebElement addToBag;

    @FindBy(xpath="//span[@data-testid = 'cartCount']")
    WebElement cart;

    @FindBy(id="minibag-viewbag-button")
    WebElement miniBagButton;

    public ProductPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void addToBag() {
        addToBag.click();
    }
    public void clickCart() {
        PLTUtil.waitForVisibilityOf(cart);
        cart.click();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String selectFirstAvailableSize() {
        PLTUtil.waitForVisibilityOfAll(productSizes);
        WebElement item  = findFirstAvailableItem();
        if(Objects.nonNull(item)) {
            item.click();
            return item.getText();
        }
        return "";
    }

    public int getCartCount() {
        try {
            PLTUtil.waitForVisibilityOf(miniBagButton);
            PLTUtil.waitForInvisibilityOf(miniBagButton);
            return  Integer.parseInt(cart.getText());
        } catch (TimeoutException e) {
            return 0;
        }
    }

    public WebElement findFirstAvailableItem() {
        PLTUtil.waitForVisibilityOfAll(productSizes);
        if (CollectionUtils.hasElements(productSizes)) {
            productSizes.forEach(element -> {
                String classes = element.getAttribute("class");
                if(!classes.contains("isOutOfStock") &&
                        !SIZE_GUIDE.equals(element.getText())) {
                    chosenSize=  element;
                }
            });
        }
        return chosenSize;
    }
}

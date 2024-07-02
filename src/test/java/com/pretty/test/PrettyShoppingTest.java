package com.pretty.test;

import com.pretty.model.PurchaseData;
import com.pretty.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.pretty.constants.Constants.PASSWORD;
import static com.pretty.constants.Constants.USERNAME;

public class PrettyShoppingTest extends BaseTest {

    HomePage homePage;
    ClothingPage clothingPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;
    PLTSpinnerPage pltSpinnerPage;
    BagPage bagPage;
    PurchaseData purchaseData;

    @Test(priority = 0)
    public void purchaseTest() throws InterruptedException {
        test = extent.createTest("Purchase an Item", "Open up a web browser navigate to plt website, selected an item and go to checkout");

        initializePages();
        purchaseData = new PurchaseData();
        homePage.acceptCookies();
        Assert.assertEquals(homePage.getTitle(), "Women's Fashion Clothing & Dresses | PrettyLittleThing");
        test.pass("PLT website is now displayed");
        homePage.selectCategory();

        clothingPage.selectProduct(0);
        purchaseData.setSize(productPage.selectFirstAvailableSize());
        purchaseData.setProductName(productPage.getProductName());
        purchaseData.setInitialCartCount(productPage.getCartCount());
        test.info("Initial cart size is: "+purchaseData.getInitialCartCount());
        productPage.addToBag();
        purchaseData.setCartCount(productPage.getCartCount());
        productPage.clickCart();
        Assert.assertEquals(purchaseData.getCartCount(), purchaseData.getInitialCartCount()+1);
        test.pass("Cart count has been increased by 1 and current value is :" +purchaseData.getCartCount());

        validateProductName(cartPage.getProductName());
        Assert.assertEquals(cartPage.getProductName(), purchaseData.getProductName());
        validateProductSize(cartPage.getProductSize());
        Assert.assertEquals(cartPage.getProductSize(), purchaseData.getSize());

        purchaseData.setSubTotal(cartPage.getSubTotal());
        test.info("Sub total is showing in the cart :" +purchaseData.getCartCount());
        cartPage.proceedToCheckout();

        Assert.assertTrue(pltSpinnerPage.isSpinnerShowing());

        checkOutPage.enterUserName(configProperties.getProperty(USERNAME));
        checkOutPage.clickOnContinueButton();
        checkOutPage.enterPassword(configProperties.getProperty(PASSWORD));
        checkOutPage.clickOnContinueButton();

        validateProductName(bagPage.getProductName());
        Assert.assertEquals(bagPage.getProductName(), purchaseData.getProductName());
        validateProductSize(bagPage.getProductSize());
        Assert.assertEquals(bagPage.getProductSize(), purchaseData.getSize());
        validateSubTotal();
        Assert.assertEquals(bagPage.getSubTotal(), purchaseData.getSubTotal());
        Assert.assertNotNull(bagPage.getDeliveryTotal());
        Assert.assertNotNull(bagPage.getGrandTotal());

        paymentPage.scrollDown();
        paymentPage.selectPaymentOption();
    }

    private void validateProductSize(String productSize) {
        if(purchaseData.getSize().equals(productSize)) {
            test.pass("Selected Item size is same as in the cart :"+ productSize);
        } else {
            test.warning("Selected Item size not available in the cart");
        }
    }

    private void validateProductName(String productName) {
        if(purchaseData.getProductName().equals(productName)) {
            test.pass("Selected Item is same as in the cart:"+productName);
        } else {
            test.warning("Selected Item is not available in the cart");
        }
    }

    private void validateSubTotal() {
        if(purchaseData.getSubTotal().equals(bagPage.getSubTotal())) {
            test.pass("The Sub total is same as in the listed in the cart: "+purchaseData.getSubTotal());
        } else {
            test.warning("The sub total is not same as listed in cart");
        }
    }


    private void initializePages() {
        homePage = new HomePage(driver);
        clothingPage =new ClothingPage(driver);
        productPage =new ProductPage(driver);
        cartPage =new CartPage(driver);
        pltSpinnerPage = new PLTSpinnerPage(driver);
        checkOutPage = new CheckOutPage(driver);
        bagPage = new BagPage(driver);
        paymentPage = new PaymentPage(driver);
    }

}

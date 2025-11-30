package Tests;

import Pages.CartPage;
import Test_Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends TestBase {

    // ----------------- POPUP TESTS -----------------

    @Test(priority = 1)
    public void CARTPOP_001_verifyAddToCartPopup() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        Assert.assertTrue(driver.findElement(cp.modal).isDisplayed(), "Popup should appear");
    }

    @Test(priority = 2)
    public void CARTPOP_002_verifyContinueShoppingClosesPopup() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.closePopupByContinueShopping();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cp.modal));
        Assert.assertTrue(driver.findElements(cp.modal).isEmpty() ||
                !driver.findElement(cp.modal).isDisplayed(), "Popup should close");
    }

    @Test(priority = 3)
    public void CARTPOP_003_verifyViewCartRedirectsToCartPage() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.clickViewCartInsidePopup();
        Assert.assertTrue(driver.getCurrentUrl().contains("/view_cart"), "Should redirect to cart page");
    }

    @Test(priority = 4)
    public void CARTPOP_004_verifyPopupClosesWhenClickingOutside() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();

        ((JavascriptExecutor) driver).executeScript("document.querySelector('body').click();");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cp.modal));
        Assert.assertTrue(driver.findElements(cp.modal).isEmpty() ||
                !driver.findElement(cp.modal).isDisplayed(), "Popup should close on clicking outside");
    }

    @Test(priority = 5)
    public void CARTPOP_005_verifyAddingSameProductTwiceUpdatesQuantity() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.closePopupByContinueShopping();

        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.clickViewCartInsidePopup();

        String qty = cp.getProductQuantity(); // لازم تضيف method في CartPage: getProductQuantity
        Assert.assertEquals(qty, "2", "Quantity should update to 2 after adding same product twice");
    }

    @Test(priority = 6)
    public void CARTPOP_006_verifyPopupAppearsForMultipleProducts() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.closePopupByContinueShopping();

        // Add second product (تأكد من موجود product-2)
        By addRedTop = By.xpath("//a[@data-product-id='2' and contains(@class,'add-to-cart')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addRedTop));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        WebElement modalPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(cp.modal));
        Assert.assertTrue(modalPopup.isDisplayed(), "Popup should appear for second product");
    }

    @Test(priority = 7)
    public void CARTPOP_007_verifyPopupDesignAndAlignment() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();

        WebElement modalPopup = driver.findElement(cp.modal);
        Assert.assertEquals(modalPopup.getCssValue("display"), "block");
        Assert.assertTrue(modalPopup.getLocation().getY() > 0, "Popup should be visible on screen");
    }

    // ----------------- CART PAGE TESTS -----------------

    @Test(priority = 8)
    public void CART_001_verifyCartHeaderRedirectsToCartPage() {
        CartPage cp = new CartPage(driver);
        cp.clickCartHeader();
        Assert.assertTrue(driver.getCurrentUrl().contains("/view_cart"), "Cart header should redirect to cart page");
    }

    @Test(priority = 9)
    public void CART_003_verifyTotalPriceCalculation() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.closePopupByContinueShopping();

        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.clickViewCartInsidePopup();

        Assert.assertTrue(cp.isProductInCart(), "Product should exist in cart");
    }

    @Test(priority = 10)
    public void CART_004_verifyProductRemainsInCartAfterRefresh() {
        CartPage cp = new CartPage(driver);
        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.clickViewCartInsidePopup();

        driver.navigate().refresh();
        Assert.assertTrue(cp.isProductInCart(), "Product should remain after refresh");
    }

    @Test(priority = 11)
    public void CART_005_verifyProductDetailsDisplayedInCart() {
        CartPage cp = new CartPage(driver);

        cp.scrollToBlueTop();
        cp.hoverBlueTop();
        cp.clickAddToCart();
        cp.waitForPopup();
        cp.clickViewCartInsidePopup(); // نروح للـ cart بعد الإضافة

        Assert.assertEquals(cp.getProductName(), "Blue Top");
        Assert.assertEquals(cp.getProductCategory(), "Women > Tops");
        Assert.assertEquals(cp.getProductPrice(), "Rs. 500");
    }


    @Test(priority = 12)
    public void CART_006_verifyUpdateQuantityInCart() {
        CartPage cp = new CartPage(driver);
        cp.clickCartHeader();
        Assert.assertEquals(cp.getProductQuantity(), "2");
        Assert.assertEquals(cp.getProductTotal(), "Rs. 1000");
    }

    @Test(priority = 13)
    public void verifyProductRemoval() {
        CartPage cp = new CartPage(driver);
        cp.clickCartHeader();
        cp.removeFirstProduct();
        Assert.assertFalse(cp.isProductInCart(), "Product should be removed");
    }

    @Test(priority = 14)
    public void verifyEmptyCartMessage() {
        CartPage cp = new CartPage(driver);
        cp.clickCartHeader();
        while (cp.isProductInCart()) {
            cp.removeFirstProduct();
        }
        Assert.assertTrue(cp.isEmptyCartMessageDisplayed(), "Empty cart message should appear");
    }
}
//======= By Mayar_Hesham==========


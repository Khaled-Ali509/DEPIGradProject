package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // -----------------------------------
    // LOCATORS
    // -----------------------------------
    By cartHeaderBtn = By.cssSelector("a[href='/view_cart']");
    By productBlueTop = By.xpath("//p[text()='Blue Top']/ancestor::div[@class='productinfo text-center']");
    By hoverOverlay = By.xpath("//p[text()='Blue Top']/ancestor::div[@class='single-products']//div[@class='product-overlay']");
    By addToCartBlueTop = By.xpath("//a[@data-product-id='1' and contains(@class,'add-to-cart')]");
    public By modal = By.id("cartModal");
    By continueShoppingBtn = By.cssSelector(".btn.btn-success.close-modal");
    By viewCartBtnInsideModal = By.cssSelector("#cartModal a[href='/view_cart']");
    By removeItemBtn = By.cssSelector("a.cart_quantity_delete");
    By emptyCartMsg = By.id("empty_cart");
    By productInCart = By.cssSelector("tr#product-1");
    By productName = By.cssSelector("tr#product-1 h4 a");
    By productCategory = By.cssSelector("tr#product-1 td.cart_description p");
    By productPrice = By.cssSelector("tr#product-1 td.cart_price p");
    By productQty = By.cssSelector("tr#product-1 td.cart_quantity button");
    By productTotal = By.cssSelector("tr#product-1 td.cart_total p.cart_total_price");

    // -----------------------------------
    // METHODS
    // -----------------------------------

    public void scrollToBlueTop() {
        WebElement p = wait.until(ExpectedConditions.visibilityOfElementLocated(productBlueTop));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", p);
    }

    public void hoverBlueTop() {
        WebElement p = wait.until(ExpectedConditions.visibilityOfElementLocated(productBlueTop));
        new Actions(driver).moveToElement(p).perform();
    }

    public void clickAddToCart() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBlueTop));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void waitForPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
    }

    public void closePopupByContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }

    public void clickViewCartInsidePopup() {
        WebElement vc = wait.until(ExpectedConditions.elementToBeClickable(viewCartBtnInsideModal));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", vc);
    }

    public void clickCartHeader() {
        WebElement cartHeader = wait.until(ExpectedConditions.elementToBeClickable(cartHeaderBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartHeader);
        cartHeader.click();
    }

    public boolean isProductInCart() {
        try {
            return driver.findElement(productInCart).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void removeFirstProduct() {
        try {
            WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(removeItemBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
            deleteBtn.click();
            wait.until(ExpectedConditions.stalenessOf(deleteBtn));
        } catch (TimeoutException e) {
            System.out.println("Delete button not clickable or not present.");
        }
    }


    public boolean isEmptyCartMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg)).isDisplayed();
    }

    // ------------------ GETTERS FOR PRODUCT DETAILS ------------------

    public String getProductName() {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(productName));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        return el.getText();
    }

    public String getProductCategory() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productCategory)).getText();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
    }

    public String getProductQuantity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productQty)).getText();
    }

    public String getProductTotal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTotal)).getText();
    }

    // ------------------ METHODS FOR CARTPOP_005 ------------------

    public void addProductToCart() {
        scrollToBlueTop();
        hoverBlueTop();
        clickAddToCart();
        waitForPopup();
    }

    public void clickContinueShopping() {
        closePopupByContinueShopping();
    }

    public void clickViewCart() {
        clickViewCartInsidePopup();
    }
}
//======= By Mayar_Hesham==========

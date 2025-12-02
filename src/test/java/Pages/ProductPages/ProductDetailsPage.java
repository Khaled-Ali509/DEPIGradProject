
package Pages.ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class ProductDetailsPage extends BasePage {

    private final By productInfo = By.cssSelector(".product-information");
    private final By quantityField = By.id("quantity");
    private final By addToCartBtn = By.xpath("//button[contains(text(),'Add to cart')]");
    private final By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private final By reviewForm = By.id("review-form");
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By reviewField = By.id("review");
    private final By reviewSubmit = By.id("button-review");
    private final By reviewSuccessMsg = By.xpath("//span[contains(text(),'Thank you for your review.')]");
    private final By emptyFieldsError = By.xpath("//*[contains(text(),'Please fill in all required fields')]");
    private final By invalidEmailError = By.xpath("//*[contains(text(),'valid email')]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean infoDisplayed() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(productInfo))).isDisplayed();
    }

    public void setQuantity(String qty) {
        WebElement q = driver.findElement(quantityField);
        q.clear();
        q.sendKeys(qty);
    }

    public String getQuantity() {
        return driver.findElement(quantityField).getAttribute("value");
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void continueShopping() {
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingBtn))).click();
    }

    public boolean reviewSectionVisible() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(reviewForm))).isDisplayed();
    }

    public void submitReview(String name, String email, String review) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(reviewField).sendKeys(review);
        driver.findElement(reviewSubmit).click();
    }

    public boolean successReviewShown() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(reviewSuccessMsg))).isDisplayed();
    }

    public boolean emptyFieldsErrorShown() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(emptyFieldsError))).isDisplayed();
    }

    public boolean invalidEmailErrorShown() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailError))).isDisplayed();
    }
}

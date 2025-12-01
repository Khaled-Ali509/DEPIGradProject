package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class ProductDetailsHomePage {

    WebDriver driver;

    public ProductDetailsHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators of elements
    By productDetailsSection = By.xpath("//div[contains(@class, 'product-details')]");
    By productName = By.xpath("//div[contains(@class, 'product-information')]//h2");
    By productCategory = By.xpath("//div[contains(@class, 'product-information')]//p[contains(text(), 'Category:')]");
    By productPrice = By.xpath("//div[contains(@class, 'product-information')]//span//span");
    By productAvailability = By.xpath("//div[@class='product-information']//b[contains(text(),'Availability')]/following-sibling::text()");
    By quantityInput = By.xpath("//input[@id='quantity']");
    By addToCartButton = By.xpath("//button[@class=\"btn btn-default cart\"]");
    By productImage = By.xpath("//div[@class=\"view-product\"]");
    By backToHomeButton = By.xpath("//a[contains(@href, '/') and contains(text(), 'Home')]");


    //Actions
    public void navigateBackToHome() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(backToHomeButton));
        assert homeBtn != null;
        homeBtn.click();
    }

    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        assert productNameElement != null;
        return productNameElement.getText();
    }

    public String getProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        assert priceElement != null;
        return priceElement.getText();
    }

    public String getProductCategory() {
        try {
            WebElement categoryElement = driver.findElement(productCategory);
            return categoryElement.getText();
        } catch (Exception e) {
            return "Category not available";
        }
    }

    public String getProductAvailability() {
        try {
            WebElement availabilityElement = driver.findElement(productAvailability);
            return availabilityElement.getText();
        } catch (Exception e) {
            return "Availability not available";
        }
    }


    //Assertions
    public void assertProductDetailsPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailsSection));
        assert productDetails != null;
        Assert.assertTrue(productDetails.isDisplayed());
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/product_details/"));
        System.out.println("✅ Product details page loaded successfully");
    }

    public void assertProductInformationIsComplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        assert productNameElement != null;
        Assert.assertTrue(productNameElement.isDisplayed());
        Assert.assertFalse(productNameElement.getText().trim().isEmpty());
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        assert priceElement != null;
        Assert.assertTrue(priceElement.isDisplayed());
        Assert.assertFalse(priceElement.getText().trim().isEmpty());
        WebElement imageElement = driver.findElement(productImage);
        Assert.assertTrue(imageElement.isDisplayed());
        WebElement quantityElement = driver.findElement(quantityInput);
        Assert.assertTrue(quantityElement.isDisplayed());
        WebElement addToCartBtn = driver.findElement(addToCartButton);
        Assert.assertTrue(addToCartBtn.isDisplayed());
        String productNameText = productNameElement.getText();
        String productPriceText = priceElement.getText();
        System.out.println("✅ Product Details Verified - Name: " + productNameText + " | Price: " + productPriceText);
    }

    public void assertProductDetailsMatch(String expectedProductName, String expectedProductPrice) {
        String actualProductName = getProductName();
        String actualProductPrice = getProductPrice();
        Assert.assertEquals(actualProductName, expectedProductName);
        Assert.assertEquals(actualProductPrice, expectedProductPrice);
        System.out.println("✅ Product details match - Name: " + actualProductName + " | Price: " + actualProductPrice);
    }

    public void printProductDetails() {
        System.out.println("=== PRODUCT DETAILS ===");
        System.out.println("Name: " + getProductName());
        System.out.println("Price: " + getProductPrice());
        System.out.println("Category: " + getProductCategory());
        System.out.println("Availability: " + getProductAvailability());
        System.out.println("=======================");
    }
}
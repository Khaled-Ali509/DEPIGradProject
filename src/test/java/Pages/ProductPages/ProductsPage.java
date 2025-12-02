
package Pages.ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class ProductsPage extends BasePage {

    private final By productsGrid = By.cssSelector(".features_items");
    private final By productWrappers = By.cssSelector(".product-image-wrapper");
    private final By viewFirstProduct = By.xpath("//a[contains(text(),'View Product')][1]");
    private final By searchInput = By.id("search_product");
    private final By searchBtn = By.id("submit_search");
    private final By searchResultsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");
    private final By invalidSearchMsg = By.xpath("//p[contains(text(),'not found')]");
    private final By categorySidebar = By.cssSelector(".left-sidebar .panel-group");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllProducts() {
        WebElement grid = wait.until(ExpectedConditions.visibilityOfElementLocated(productsGrid));
        assert grid != null;
        return grid.findElements(productWrappers);
    }

    public void clickViewFirstProduct() {
        driver.findElement(viewFirstProduct).click();
    }

    public void searchFor(String key) {
        driver.findElement(searchInput).sendKeys(key);
        driver.findElement(searchBtn).click();
    }

    public boolean searchedProductsVisible() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsTitle))).isDisplayed();
    }

    public boolean invalidSearchVisible() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(invalidSearchMsg))).isDisplayed();
    }

    public boolean categorySidebarVisible() {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(categorySidebar))).isDisplayed();
    }

    public void selectCategory(String main, String sub) {
        driver.findElement(By.linkText(main)).click();
        driver.findElement(By.linkText(sub)).click();
    }
}

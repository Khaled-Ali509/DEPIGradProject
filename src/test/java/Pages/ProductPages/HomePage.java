
package Pages.ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By productsBtn = By.xpath("//a[@href=\"/products\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openProducts() {
        driver.findElement(productsBtn).click();
    }
}

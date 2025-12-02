
package Tests;

import Pages.ProductPages.HomePage;
import Pages.ProductPages.ProductDetailsPage;
import Pages.ProductPages.ProductsPage;
import Test_Base.PTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class productssuite extends PTestBase {

    // PROD_001
    @Test
    public void PROD_001_verifyProductsPageDisplaysAllProducts() {
        driver.get("https://automationexercise.com");
        HomePage home = new HomePage(driver);
        home.openProducts();
        ProductsPage pp = new ProductsPage(driver);
        Assert.assertFalse(pp.getAllProducts().isEmpty());
    }

    // PROD_002
    @Test
    public void PROD_002_verifyViewProductOpensDetailsPage() {
        driver.get("https://automationexercise.com/products");
        ProductsPage pp = new ProductsPage(driver);
        pp.clickViewFirstProduct();
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        Assert.assertTrue(pd.infoDisplayed());
    }

    // PROD_003
    @Test
    public void PROD_003_verifyProductDetailsInformationDisplayedCorrectly() {
        driver.get("https://automationexercise.com/product_details/2");
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        Assert.assertTrue(pd.infoDisplayed());
    }

    // PROD_004
    @Test
    public void PROD_004_verifySearchBarFunctional() {
        driver.get("https://automationexercise.com/products");
        ProductsPage pp = new ProductsPage(driver);
        pp.searchFor("Dress");
        Assert.assertTrue(pp.searchedProductsVisible());
    }

    // PROD_005
    @Test
    public void PROD_005_verifySearchingInvalidProductShowsNoResults() {
        driver.get("https://automationexercise.com/products");
        ProductsPage pp = new ProductsPage(driver);
        pp.searchFor("XYZ");
        Assert.assertTrue(pp.invalidSearchVisible());
    }

    // PROD_006
    @Test
    public void PROD_006_verifyCategoryListDisplayed() {
        driver.get("https://automationexercise.com/products");
        ProductsPage pp = new ProductsPage(driver);
        Assert.assertTrue(pp.categorySidebarVisible());
    }

    // PROD_007
    @Test
    public void PROD_007_verifyFilteringByCategory() {
        driver.get("https://automationexercise.com/products");
        ProductsPage pp = new ProductsPage(driver);
        pp.selectCategory("Women", "Dress");
        Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).toLowerCase().contains("dress"));
    }

    // PROD_008
    @Test
    public void PROD_008_verifySubcategoryNavigationWorks() {
        driver.get("https://automationexercise.com/products");
        ProductsPage pp = new ProductsPage(driver);
        pp.selectCategory("Women", "Dress");
        Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("Women - Dress"));
    }

    // PROD_009
    @Test
    public void PROD_009_verifyQuantityField() {
        driver.get("https://automationexercise.com/product_details/1");
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        pd.setQuantity("3");
        Assert.assertEquals(pd.getQuantity(), "3");
    }

    // PROD_010
    @Test
    public void PROD_010_verifyProductPriceCurrency() {
        driver.get("https://automationexercise.com/products");
        Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("Rs."));
    }

    // PROD_011
    @Test
    public void PROD_011_verifyContinueShoppingRedirectsToProducts() {
        driver.get("https://automationexercise.com/product_details/1");
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        pd.addToCart();
        pd.continueShopping();
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("products"));
    }

    // PROD_012
    @Test
    public void PROD_012_verifyAddReviewSectionVisible() {
        driver.get("https://automationexercise.com/product_details/1");
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        Assert.assertTrue(pd.reviewSectionVisible());
    }

    // PROD_013
    @Test
    public void PROD_013_verifySubmitReviewValidData() {
        driver.get("https://automationexercise.com/product_details/1");
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        pd.submitReview("Khaled Ali", "khaled.test@example.com", "Good quality product!");
        Assert.assertTrue(pd.successReviewShown());
    }

    // PROD_014
    @Test
    public void PROD_014_verifyErrorOnEmptyReviewSubmission() {
        driver.get("https://automationexercise.com/product_details/1");
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        pd.submitReview("", "", "");
        Assert.assertTrue(pd.emptyFieldsErrorShown());
    }

    // PROD_016
    @Test
    public void PROD_016_verifyInvalidEmailBlockedInReview() {
        driver.get("https://automationexercise.com/product_details/1");
        ProductDetailsPage pd = new ProductDetailsPage(driver);
        pd.submitReview("Khaled Ali", "khaled.test", "Good quality product!");
        Assert.assertTrue(pd.invalidEmailErrorShown());
    }
}

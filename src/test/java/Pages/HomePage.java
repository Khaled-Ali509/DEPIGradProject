package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators of elements
    By companyLogo = By.xpath("//img[@alt='Website for automation practice']");
    By homeMenu = By.xpath("//a[@href=\"/\"]");
    By productsMenu = By.xpath("//a[@href=\"/products\"]");
    By cartMenu = By.xpath("//a[@href=\"/products\"]");
    By signupLoginMenu = By.xpath("//a[@href=\"/login\"]");
    By testCasesMenu = By.xpath("//a[@href=\"/test_cases\"]");
    By apiTestingMenu = By.xpath("//a[@href=\"/api_list\"]");
    By videoTutorialsMenu = By.xpath("//a[@href=\"https://www.youtube.com/c/AutomationExercise\"]");
    By contactUsMenu = By.xpath("//a[@href=\"/contact_us\"]");
    By nextCarouselBtn = By.xpath("//a[@data-slide=\"next\"]");
    By prevCarouselBtn = By.xpath("//a[@data-slide=\"prev\"]");
    By initialImageCarousel = By.xpath("//img[@src=\"/static/images/home/girl2.jpg\"]");
    By secondImageCarousel = By.xpath("//img[@src=\"/static/images/home/girl1.jpg\"]");
    By thirdImageCarousel = By.xpath("//img[@src=\"/static/images/home/girl3.jpg\"]");
    By featuredItemsSection = By.className("features_items");
    By productCards = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'product-image-wrapper')]");
    By productNames = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'productinfo')]//p");
    By productPrices = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'productinfo')]//h2");
    By productImages = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'productinfo')]//img");
    By addToCartButtons = By.xpath("//div[contains(@class, 'features_items')]//div[contains(@class, 'productinfo')]//a[contains(@class, 'add-to-cart')]");
    By successModalContent = By.xpath("//div[contains(@class, 'modal-content')]");
    By successMessage = By.xpath("//div[contains(@class, 'modal-body')]//p[contains(text(), 'Your product has been added to cart.')]");
    By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue Shopping')]");
    By viewCartButton = By.xpath("//p[@class=\"text-center\"]//a[@href=\"/view_cart\"]");
    By viewProductButtons = By.xpath("//a[contains(@href, '/product_details/')]");
    By categorySection = By.xpath("//div[contains(@class, 'left-sidebar')]//h2[contains(text(), 'Category')]");
    By womenCategory = By.xpath("//a[@href=\"#Women\"]");
    By menCategory = By.xpath("//a[@href=\"#Men\"]");
    By kidsCategory = By.xpath("//a[@href=\"#Kids\"]");
    By womenSubCategory = By.xpath("//div[@id='Women']//a");
    By dressSubCategory = By.xpath("//a[@href=\"/category_products/1\"]");
    By topsSubCategory = By.xpath("//a[@href=\"/category_products/2\"]");
    By sareeSubCategory = By.xpath("//a[@href=\"/category_products/7\"]");
    By menSubCategory = By.xpath("//div[@id='Men']//a");
    By t_shirtsSubCategory = By.xpath("//a[@href=\"/category_products/3\"]");
    By jeansSubCategory = By.xpath("//a[@href=\"/category_products/6\"]");
    By kidsSubCategory = By.xpath("//div[@id='Kids']//a");
    By dressKidsSubCategory = By.xpath("//a[@href=\"/category_products/4\"]");
    By topsKidsSubCategory = By.xpath("//a[@href=\"/category_products/5\"]");
    By brandsSection = By.xpath("//div[contains(@class, 'brands_products')]//h2[contains(text(), 'Brands')]");
    By poloBrand = By.xpath("//a[@href=\"/brand_products/Polo\"]");
    By hmBrand = By.xpath("//a[@href=\"/brand_products/H&M\"]");
    By madameBrand = By.xpath("//a[@href=\"/brand_products/Madame\"]");
    By mastHarbourBrand = By.xpath("//a[@href=\"/brand_products/Mast & Harbour\"]");
    By babyHugBrand = By.xpath("//a[@href=\"/brand_products/Babyhug\"]");
    By allenSollyBrand = By.xpath("//a[@href=\"/brand_products/Allen Solly Junior\"]");
    By kookieKidsBrand = By.xpath("//a[@href=\"/brand_products/Kookie Kids\"]");
    By bibaBrand = By.xpath("//a[@href=\"/brand_products/Biba\"]");
    By allBrands = By.xpath("//div[contains(@class, 'brands-name')]//a");
    By recommendedItemsSection = By.xpath("//h2[contains(text(), 'recommended items')]");
    By recommendedItemsCards = By.xpath("//div[@id='recommended-item-carousel']//div[contains(@class, 'product-image-wrapper')]");
    By recommendedItemNames = By.xpath("//div[@id='recommended-item-carousel']//div[@class='productinfo text-center']//p");
    By recommendedItemPrices = By.xpath("//div[@id='recommended-item-carousel']//div[contains(@class, 'productinfo')]//h2");
    By recommendedItemsAddToCartButtons = By.xpath("//div[@id='recommended-item-carousel']//div[contains(@class, 'productinfo')]//a[contains(@class, 'add-to-cart')]");
    By recommendedItemsNextButton = By.xpath("//div[@id='recommended-item-carousel']//a[contains(@class, 'right')]");
    By recommendedItemsPrevButton = By.xpath("//div[@id='recommended-item-carousel']//a[contains(@class, 'left')]");
    By successModalForRecommendedItems = By.xpath("//div[@class='modal-content']");
    By successMessageForRecommendedItems = By.xpath("//div[@class='modal-body']//p");
    By continueShoppingBtnForRecommendedItems = By.xpath("//button[contains(text(), 'Continue Shopping')]");
    By subscriptionSection = By.xpath("//h2[contains(text(), 'Subscription')]");
    By subscriptionEmailInput = By.xpath("//input[@id='susbscribe_email']");
    By subscribeButton = By.xpath("//button[@id='subscribe']");
    By successMessageForSubscriptionSection = By.xpath("//div[@id=\"success-subscribe\"]");
    By footerSection = By.xpath("//footer[@id='footer']");
    By copyrightText = By.xpath("//footer//p[@class=\"pull-left\"]");



    //Actions
    public void navigateToHomepage() {
        driver.navigate().to("https://automationexercise.com/");
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html")));
    }

    public void scrollToFeaturedItemsSection() {
        WebElement featuredSection = driver.findElement(featuredItemsSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", featuredSection);
    }

    public void clickNextCarouselBtn() {
        driver.findElement(nextCarouselBtn).click();
    }

    public void clickPrevCarouselBtn() {
        driver.findElement(prevCarouselBtn).click();
    }

    public void clickAddToCartButton(int productIndex) {
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartButtons);
        if (productIndex >= 0 && productIndex < addToCartButtonsList.size()) {
            WebElement button = addToCartButtonsList.get(productIndex);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        } else {
            throw new IllegalArgumentException("Invalid product index: " + productIndex);
        }
    }

    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        assert continueBtn != null;
        continueBtn.click();
    }

    public String getProductName(int productIndex) {
        List<WebElement> productNamesList = driver.findElements(productNames);
        if (productIndex >= 0 && productIndex < productNamesList.size()) {
            return productNamesList.get(productIndex).getText();
        }
        return "Unknown Product";
    }

    public String getProductPrice(int productIndex) {
        List<WebElement> productPricesList = driver.findElements(productPrices);
        if (productIndex >= 0 && productIndex < productPricesList.size()) {
            return productPricesList.get(productIndex).getText();
        }
        return "Unknown Price";
    }

    public void clickViewProductButton(int productIndex) {
        List<WebElement> viewProductButtonsList = driver.findElements(viewProductButtons);
        if (productIndex >= 0 && productIndex < viewProductButtonsList.size()) {
            WebElement button = viewProductButtonsList.get(productIndex);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            String productName = getProductName(productIndex);
            String productPrice = getProductPrice(productIndex);
            button.click();
            System.out.println("Clicked View Product for: " + productName + " | Price: " + productPrice);
        } else {
            throw new IllegalArgumentException("Invalid product index: " + productIndex);
        }
    }

    public ProductDetailsHomePage clickViewProductAndReturnDetailsPage(int productIndex) {
        clickViewProductButton(productIndex);
        return new ProductDetailsHomePage(driver);
    }

    public void clickAllViewProductButtons() {
        List<WebElement> viewProductButtonsList = driver.findElements(viewProductButtons);
        System.out.println("Found " + viewProductButtonsList.size() + " View Product buttons to test...");

        for (int i = 0; i < viewProductButtonsList.size(); i++) {
            String productName = getProductName(i);
            String productPrice = getProductPrice(i);
            System.out.println("Testing View Product for product " + (i + 1) + ": " + productName);
            ProductDetailsHomePage productDetailsHomePage = clickViewProductAndReturnDetailsPage(i);
            productDetailsHomePage.assertProductDetailsPageLoaded();
            productDetailsHomePage.assertProductInformationIsComplete();
            productDetailsHomePage.assertProductDetailsMatch(productName, productPrice);
            productDetailsHomePage.printProductDetails();
            productDetailsHomePage.navigateBackToHome();
            waitForPageToLoad();
            scrollToFeaturedItemsSection();
            System.out.println("✅ Successfully viewed details for '" + productName + "'");
        }
        System.out.println("✅ All " + viewProductButtonsList.size() + " View Product buttons working correctly!");
    }

    public void clickWomenCategory() {
        driver.findElement(womenCategory).click();
    }

    public void clickMenCategory() {
        driver.findElement(menCategory).click();
    }

    public void clickKidsCategory() {
        driver.findElement(kidsCategory).click();
    }

    public void clickWomenDressSubCategory() {
        driver.findElement(dressSubCategory).click();
    }

    public void clickWomenTopsSubCategory() {
        driver.findElement(topsSubCategory).click();
    }

    public void clickWomenSareeSubCategory() {
        driver.findElement(sareeSubCategory).click();
    }

    public void clickMenT_shirtsSubCategory() {
        driver.findElement(t_shirtsSubCategory).click();
    }

    public void clickMenJeansSubCategory() {
        driver.findElement(jeansSubCategory).click();
    }

    public void clickKidsDressSubCategory() {
        driver.findElement(dressKidsSubCategory).click();
    }

    public void clickKidsTopsSubCategory() {
        driver.findElement(topsKidsSubCategory).click();
    }

    public void scrollToBrandsSection() {
        WebElement brandsSectionElement = driver.findElement(brandsSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandsSectionElement);
    }

    public void clickAllBrands() {
        List<WebElement> brands = driver.findElements(allBrands);
        System.out.println("Found " + brands.size() + " brands to test...");
        for (int i = 0; i < brands.size(); i++) {
            String brandName = brands.get(i).getText();
            System.out.println("Testing brand: " + brandName);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brands.get(i));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement brand = wait.until(ExpectedConditions.elementToBeClickable(brands.get(i)));
            assert brand != null;
            brand.click();
            navigateToHomepage();
            waitForPageToLoad();
            scrollToBrandsSection();
            brands = driver.findElements(allBrands);
            System.out.println("✅ Successfully tested brand: " + brandName);
        }
        System.out.println("✅ All " + brands.size() + " brands working correctly!");
    }

    public void scrollToRecommendedItemsSection() {
        WebElement section = driver.findElement(recommendedItemsSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", section);
    }

    private void clickContinueShoppingForRecommendedItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtnForRecommendedItems));
        assert continueButton != null;
        continueButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successModalForRecommendedItems));
    }

    public void scrollToSubscriptionSection() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmailInput).sendKeys(email);
        System.out.println("📧 Entered email: " + email);
    }

    public void clickSubscribeButton() {
        driver.findElement(subscribeButton).click();
        System.out.println("✅ Clicked Subscribe button");
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }



    //Assertions
    public void assertHomePageLoadsSuccessfully() {
        Assert.assertTrue(driver.findElement(companyLogo).isDisplayed());
        Assert.assertTrue(driver.findElement(companyLogo).isEnabled());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        System.out.println("✅ Home Page Loaded Successfully");

    }

    public void assertAllMenuItemsArePresent() {
        Assert.assertTrue(driver.findElement(homeMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(homeMenu).isEnabled());
        Assert.assertTrue(driver.findElement(productsMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(productsMenu).isEnabled());
        Assert.assertTrue(driver.findElement(cartMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(cartMenu).isEnabled());
        Assert.assertTrue(driver.findElement(signupLoginMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(signupLoginMenu).isEnabled());
        Assert.assertTrue(driver.findElement(testCasesMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(testCasesMenu).isEnabled());
        Assert.assertTrue(driver.findElement(apiTestingMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(apiTestingMenu).isEnabled());
        Assert.assertTrue(driver.findElement(videoTutorialsMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(videoTutorialsMenu).isEnabled());
        Assert.assertTrue(driver.findElement(contactUsMenu).isDisplayed());
        Assert.assertTrue(driver.findElement(contactUsMenu).isEnabled());
        System.out.println("✅ All Menu Items are Present");
    }

    public void assertInitialImageCarousel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(initialImageCarousel));
        System.out.println("✅ Initial carousel image is present");
    }

    public void assertSecondImageCarousel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondImageCarousel));
        System.out.println("✅ Second carousel image is present");
    }

    public void assertThirdImageCarousel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdImageCarousel));
        System.out.println("✅ Third carousel image is present");

    }

    public void assertFeaturedItemsSectionVisible() {
        Assert.assertTrue(driver.findElement(featuredItemsSection).isDisplayed());
        System.out.println("✅ Featured Items Section is Visible");

    }

    public void assertProductCardsAreDisplayed() {
        List<WebElement> cards = driver.findElements(productCards);
        Assert.assertFalse(cards.isEmpty());

        for (WebElement card : cards) {
            Assert.assertTrue(card.isDisplayed());
        }
        System.out.println("✅ Product Cards are Visible");

    }

    public void assertProductInformationCompleteness() {
        List<WebElement> names = driver.findElements(productNames);
        List<WebElement> prices = driver.findElements(productPrices);
        for (int i = 0; i < names.size(); i++) {
            Assert.assertTrue(names.get(i).isDisplayed());
            Assert.assertFalse(names.get(i).getText().trim().isEmpty());
            Assert.assertTrue(prices.get(i).isDisplayed());
            Assert.assertFalse(prices.get(i).getText().trim().isEmpty());
            System.out.println("Product " + (i + 1) + ": " + names.get(i).getText() + " | Price: " + prices.get(i).getText());
        }
    }

    public void assertProductImagesLoadProperly() {
        List<WebElement> images = driver.findElements(productImages);
        Assert.assertFalse(images.isEmpty());
        for (WebElement image : images) {
            Assert.assertTrue(image.isDisplayed());
            String naturalWidth = image.getAttribute("naturalWidth");
            Assert.assertNotEquals(naturalWidth, "0");
        }
    }

    public void assertAddToCartButtonsArePresent() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        Assert.assertFalse(buttons.isEmpty());

        for (WebElement button : buttons) {
            Assert.assertTrue(button.isDisplayed());
            String buttonText = button.getText();
            Assert.assertEquals(buttonText, "Add to cart");
        }
    }

    public void assertSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(successModalContent));
        assert modal != null;
        Assert.assertTrue(modal.isDisplayed());
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        assert message != null;
        Assert.assertTrue(message.isDisplayed());
        Assert.assertTrue(message.getText().contains("Your product has been added to cart"));
        WebElement continueBtn = driver.findElement(continueShoppingButton);
        WebElement viewCartBtn = driver.findElement(viewCartButton);
        Assert.assertTrue(continueBtn.isDisplayed());
        Assert.assertTrue(viewCartBtn.isDisplayed());
        System.out.println("✅ Success message displayed: " + message.getText());
    }

    public void assertAllAddToCartButtonsWork() {
        List<WebElement> addToCartButtonsList = driver.findElements(addToCartButtons);
        int totalProducts = addToCartButtonsList.size();
        System.out.println("Testing " + totalProducts + " Add to Cart buttons...");
        for (int i = 0; i < totalProducts; i++) {
            String productName = getProductName(i);
            System.out.println("Testing Add to Cart for product: " + productName);
            clickAddToCartButton(i);
            assertSuccessMessageDisplayed();
            clickContinueShopping();
            System.out.println("✅ Successfully added '" + productName + "' to cart");
        }
        System.out.println("✅ All " + totalProducts + " Add to Cart buttons working correctly!");
    }

    public void assertViewProductButtonsArePresent() {
        List<WebElement> buttons = driver.findElements(viewProductButtons);
        Assert.assertFalse(buttons.isEmpty());
        for (WebElement button : buttons) {
            Assert.assertTrue(button.isDisplayed());
            String buttonText = button.getText().toLowerCase();
            Assert.assertTrue(buttonText.contains("view product"));
        }
        System.out.println("✅ Found " + buttons.size() + " View Product buttons");
    }

    public void assertCategorySectionIsVisible() {
        Assert.assertTrue(driver.findElement(categorySection).isDisplayed());
    }

    public void assertMainCategoriesArePresent() {
        Assert.assertTrue(driver.findElement(womenCategory).isDisplayed());
        Assert.assertTrue(driver.findElement(menCategory).isDisplayed());
        Assert.assertTrue(driver.findElement(kidsCategory).isDisplayed());
    }

    public void assertWomenSubCategoriesAreVisible() {
        clickWomenCategory();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> womenSubCategories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(womenSubCategory));
        assert womenSubCategories != null;
        Assert.assertFalse(womenSubCategories.isEmpty());

        for (WebElement subCategory : womenSubCategories) {
            Assert.assertTrue(subCategory.isDisplayed());
        }
        System.out.println("✅ Women sub-categories are visible. Found " + womenSubCategories.size() + " sub-categories");
        for (WebElement subCategory : womenSubCategories) {
            System.out.println("   - " + subCategory.getText());
        }
    }

    public void assertMenSubCategoriesAreVisible() {
        clickMenCategory();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> menSubCategories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menSubCategory));
        assert menSubCategories != null;
        Assert.assertFalse(menSubCategories.isEmpty());

        for (WebElement subCategory : menSubCategories) {
            Assert.assertTrue(subCategory.isDisplayed());
        }
        System.out.println("✅ Men sub-categories are visible. Found " + menSubCategories.size() + " sub-categories");
        for (WebElement subCategory : menSubCategories) {
            System.out.println("   - " + subCategory.getText());
        }
    }

    public void assertKidsSubCategoriesAreVisible() {
        clickKidsCategory();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> kidsSubCategories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(kidsSubCategory));
        assert kidsSubCategories != null;
        Assert.assertFalse(kidsSubCategories.isEmpty());

        for (WebElement subCategory : kidsSubCategories) {
            Assert.assertTrue(subCategory.isDisplayed());
        }
        System.out.println("✅ Kids sub-categories are visible. Found " + kidsSubCategories.size() + " sub-categories");
        for (WebElement subCategory : kidsSubCategories) {
            System.out.println("   - " + subCategory.getText());
        }
    }

    public void assertSubCategoryPageLoaded(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/category_products/"));
        System.out.println("✅ Sub-category page loaded: " + expectedTitle);
    }

    public void assertAllSubCategoryFunctionalityAndNavigation() {
        clickWomenCategory();
        clickWomenDressSubCategory();
        assertSubCategoryPageLoaded("Dress");
        navigateToHomepage();
        clickWomenCategory();
        clickWomenTopsSubCategory();
        assertSubCategoryPageLoaded("Tops");
        navigateToHomepage();
        clickWomenCategory();
        clickWomenSareeSubCategory();
        assertSubCategoryPageLoaded("Saree");
        navigateToHomepage();
        clickMenCategory();
        clickMenT_shirtsSubCategory();
        assertSubCategoryPageLoaded("Tshirt");
        navigateToHomepage();
        clickMenCategory();
        clickMenJeansSubCategory();
        assertSubCategoryPageLoaded("Jeans");
        navigateToHomepage();
        clickKidsCategory();
        clickKidsDressSubCategory();
        assertSubCategoryPageLoaded("Dress");
        navigateToHomepage();
        clickKidsCategory();
        clickKidsTopsSubCategory();
        assertSubCategoryPageLoaded("Tops");
    }

    public void assertBrandsSectionIsVisible() {
        Assert.assertTrue(driver.findElement(brandsSection).isDisplayed());
        System.out.println("✅ Brands section is visible");
    }

    public void assertAllBrandsArePresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> brands = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allBrands));
        assert brands != null;
        Assert.assertFalse(brands.isEmpty());
        Assert.assertTrue(brands.size() >= 8);
        Assert.assertTrue(driver.findElement(poloBrand).isDisplayed());
        Assert.assertTrue(driver.findElement(hmBrand).isDisplayed());
        Assert.assertTrue(driver.findElement(madameBrand).isDisplayed());
        Assert.assertTrue(driver.findElement(mastHarbourBrand).isDisplayed());
        Assert.assertTrue(driver.findElement(babyHugBrand).isDisplayed());
        Assert.assertTrue(driver.findElement(allenSollyBrand).isDisplayed());
        Assert.assertTrue(driver.findElement(kookieKidsBrand).isDisplayed());
        Assert.assertTrue(driver.findElement(bibaBrand).isDisplayed());
        System.out.println("✅ All brands are present. Found " + brands.size() + " brands:");

        for (WebElement brand : brands) {
            System.out.println("   - " + brand.getText());
        }
    }

    public void assertAllBrandsFunctionalityAndNavigation() {
        assertBrandsSectionIsVisible();
        assertAllBrandsArePresent();
        clickAllBrands();
    }

    public void assertRecommendedItemsSectionIsVisible() {
        Assert.assertTrue(driver.findElement(recommendedItemsSection).isDisplayed());
        System.out.println("✅ Recommended Items section is visible");
    }

    public void assertRecommendedItemsSliderButtonsAreVisibleAndClickable() {
        Assert.assertTrue(driver.findElement(recommendedItemsNextButton).isDisplayed());
        Assert.assertTrue(driver.findElement(recommendedItemsNextButton).isEnabled());
        Assert.assertTrue(driver.findElement(recommendedItemsPrevButton).isDisplayed());
        Assert.assertTrue(driver.findElement(recommendedItemsPrevButton).isEnabled());
    }

    public void assertRecommendedItemsCardsAreDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> cards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(recommendedItemsCards));
        assert cards != null;
        Assert.assertFalse(cards.isEmpty());
        System.out.println("✅ Found " + cards.size() + " recommended items cards in total");

        // Check if AT LEAST ONE card is displayed (since carousel might hide some)
        boolean atLeastOneDisplayed = false;
        for (WebElement card : cards) {
            if (card.isDisplayed()) {
                atLeastOneDisplayed = true;
                break;
            }
        }
        Assert.assertTrue(atLeastOneDisplayed);
        System.out.println("✅ At least one recommended item card is displayed");
    }

    public void assertRecommendedItemsHaveCompleteInformation() {
        List<WebElement> allNames = driver.findElements(recommendedItemNames);
        List<WebElement> allPrices = driver.findElements(recommendedItemPrices);
        Assert.assertFalse(allNames.isEmpty());
        Assert.assertFalse(allPrices.isEmpty());
        System.out.println("📋 Recommended Items Information (displayed items):");

        int displayedCount = 0;

        for (int i = 0; i < allNames.size(); i++) {
            if (allNames.get(i).isDisplayed() && allPrices.get(i).isDisplayed()) {
                Assert.assertFalse(allNames.get(i).getText().isEmpty());
                Assert.assertFalse(allPrices.get(i).getText().isEmpty());
                System.out.println("   " + (displayedCount + 1) + ". " + allNames.get(i).getText() + " - " + allPrices.get(i).getText());
                displayedCount++;
            }
        }
        System.out.println("✅ Found " + displayedCount + " displayed recommended items with complete information");
    }

    public void assertAddToCartButtonsArePresentForRecommendedItems() {
        List<WebElement> allButtons = driver.findElements(recommendedItemsAddToCartButtons);
        Assert.assertFalse(allButtons.isEmpty());

        // Count only displayed buttons
        int displayedButtons = 0;
        for (WebElement button : allButtons) {
            if (button.isDisplayed()) {
                Assert.assertTrue(button.getText().toLowerCase().contains("add to cart"));
                displayedButtons++;
            }
        }
        System.out.println("✅ " + displayedButtons + " Add to Cart buttons are present and displayed");
    }

    public void assertAddToCartFunctionalityForRecommendedItems() {
        List<WebElement> allButtons = driver.findElements(recommendedItemsAddToCartButtons);
        List<WebElement> allNames = driver.findElements(recommendedItemNames);

        int testedCount = 0;

        for (int i = 0; i < allButtons.size(); i++) {
            // Only test displayed buttons
            if (allButtons.get(i).isDisplayed() && allNames.get(i).isDisplayed()) {
                String productName = allNames.get(i).getText();
                System.out.println("   Testing: " + productName);
                WebElement button = allButtons.get(i);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                button.click();
                assertSuccessMessageDisplayedForRecommendedItems();
                clickContinueShoppingForRecommendedItems();
                System.out.println("   ✅ Successfully added " + productName + " to cart");
                testedCount++;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (testedCount >= 3) {
                    System.out.println("   ⏩ Testing only " + testedCount + " items to avoid excessive clicks");
                    break;
                }
            }
        }
    }

    private void assertSuccessMessageDisplayedForRecommendedItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(successModalForRecommendedItems));
        assert modal != null;
        Assert.assertTrue(modal.isDisplayed());
        WebElement message = driver.findElement(successMessageForRecommendedItems);
        Assert.assertTrue(message.getText().contains("Your product has been added to cart"));
        System.out.println("      ✅ Success message displayed");
    }

    public void assertSubscriptionSectionIsVisible() {
        Assert.assertTrue(driver.findElement(subscriptionSection).isDisplayed());
        System.out.println("✅ Subscription section is visible");
    }

    public void assertSubscriptionFormIsPresent() {
        WebElement emailInput = driver.findElement(subscriptionEmailInput);
        WebElement subscribeBtn = driver.findElement(subscribeButton);
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(subscribeBtn.isDisplayed());
        Assert.assertTrue(subscribeBtn.isEnabled());
        Assert.assertEquals(emailInput.getAttribute("placeholder"), "Your email address");
        System.out.println("✅ Subscription form is present with email input and subscribe button");
    }

    public void assertSuccessMessageDisplayedForSubscriptionForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsgForSubscriptionForm = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageForSubscriptionSection));
        assert successMsgForSubscriptionForm != null;
        Assert.assertTrue(successMsgForSubscriptionForm.isDisplayed());
        Assert.assertTrue(successMsgForSubscriptionForm.getText().contains("You have been successfully subscribed!"));
        System.out.println("✅ Success message displayed: " + successMsgForSubscriptionForm.getText());
    }

    public void assertFooterIsVisible() {
        Assert.assertTrue(driver.findElement(footerSection).isDisplayed());
        System.out.println("✅ Footer section is visible");
    }


    public void assertCopyrightInformation() {
        List<WebElement> copyrightElements = driver.findElements(copyrightText);
        Assert.assertFalse(copyrightElements.isEmpty());

        boolean copyrightFound = false;
        for (WebElement element : copyrightElements) {
            if (element.isDisplayed() && element.getText().toLowerCase().contains("right")) {
                System.out.println("©️ Copyright information: " + element.getText());
                copyrightFound = true;
                break;
            }
        }
        Assert.assertTrue(copyrightFound);
        System.out.println("✅ Copyright information is present");
    }
}
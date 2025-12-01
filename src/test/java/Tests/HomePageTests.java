package Tests;

import Pages.HomePage;
import Test_Base.HTestBase;
import org.testng.annotations.Test;

public class HomePageTests extends HTestBase {

    HomePage homePage;


    @Test(priority = 1)
    public void verifyHomepageLoadsSuccessfully() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.assertHomePageLoadsSuccessfully();
    }

    @Test(priority = 2)
    public void verifyHeaderNavigationMenu() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.assertAllMenuItemsArePresent();
    }

    @Test(priority = 3)
    public void verifyCarouselImageChangeOnNext() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.assertInitialImageCarousel();
        homePage.clickNextCarouselBtn();
        homePage.assertSecondImageCarousel();
        homePage.clickNextCarouselBtn();
        homePage.assertThirdImageCarousel();
    }

    @Test(priority = 4)
    public void verifyCarouselImageChangeOnPrev() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.assertInitialImageCarousel();
        homePage.clickPrevCarouselBtn();
        homePage.assertThirdImageCarousel();
        homePage.clickPrevCarouselBtn();
        homePage.assertSecondImageCarousel();
    }

    @Test(priority = 5)
    public void verifyFeaturedProductsDisplayAndInformation() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.assertFeaturedItemsSectionVisible();
        homePage.assertProductCardsAreDisplayed();
        homePage.assertProductInformationCompleteness();
        homePage.assertProductImagesLoadProperly();
        homePage.assertAddToCartButtonsArePresent();
        homePage.assertAllAddToCartButtonsWork();
    }

    @Test(priority = 6)
    public void verifyAllViewProductButtonsWork() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.scrollToFeaturedItemsSection();
        homePage.assertFeaturedItemsSectionVisible();
        homePage.assertProductCardsAreDisplayed();
        homePage.assertViewProductButtonsArePresent();
        homePage.clickAllViewProductButtons();
    }

    @Test(priority = 7)
    public void verifyCategorySectionVisibility() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.assertCategorySectionIsVisible();
        homePage.assertMainCategoriesArePresent();
        homePage.assertWomenSubCategoriesAreVisible();
        homePage.assertMenSubCategoriesAreVisible();
        homePage.assertKidsSubCategoriesAreVisible();
    }

    @Test(priority = 8)
    public void verifyAllSubCategoryFunctionalityAndNavigation() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.assertAllSubCategoryFunctionalityAndNavigation();
    }

    @Test(priority = 9)
    public void verifyBrandsSectionIsVisible() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.scrollToBrandsSection();
        homePage.assertBrandsSectionIsVisible();
        homePage.assertAllBrandsArePresent();
    }

    @Test(priority = 10)
    public void verifyAllBrandsFunctionalityAndNavigation() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.scrollToBrandsSection();
        homePage.assertAllBrandsFunctionalityAndNavigation();
    }

    @Test(priority = 11)
    public void verifyRecommendedItemsSection() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.scrollToRecommendedItemsSection();
        homePage.assertRecommendedItemsSliderButtonsAreVisibleAndClickable();
        homePage.assertRecommendedItemsSectionIsVisible();
        homePage.assertRecommendedItemsCardsAreDisplayed();
        homePage.assertRecommendedItemsHaveCompleteInformation();
        homePage.assertAddToCartButtonsArePresentForRecommendedItems();
        homePage.assertAddToCartFunctionalityForRecommendedItems();
    }

    @Test(priority = 12)
    public void verifySubscriptionFunctionality() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.scrollToSubscriptionSection();
        homePage.assertSubscriptionSectionIsVisible();
        homePage.assertSubscriptionFormIsPresent();
        homePage.enterSubscriptionEmail("Test@email.com");
        homePage.clickSubscribeButton();
        homePage.assertSuccessMessageDisplayedForSubscriptionForm();
    }

    @Test(priority = 13)
    public void verifyFooterInformation() {
        homePage = new HomePage(driver);

        homePage.navigateToHomepage();
        homePage.scrollToFooter();
        homePage.assertFooterIsVisible();
        homePage.assertCopyrightInformation();
    }
}
package Tests;

import Pages.Checkout_Page;
import Test_Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Objects;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void registerDriverInContext(Method method , ITestContext context){
        context.setAttribute("driver" , driver);
    }

    @Test(priority = 1)
    public void testValidCheckoutData ()
    {
        Checkout_Page checkoutPage = new Checkout_Page(driver);
        // Temporary login
        if (!Objects.equals(driver.getCurrentUrl(), "https://automationexercise.com/login")){
            driver.get("https://automationexercise.com/login");
            checkoutPage.temporaryLogin();
        }else {
            checkoutPage.logout();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("https://automationexercise.com/login"));
            checkoutPage.temporaryLogin();
        }

        checkoutPage.lounchPaymentPage();
        checkoutPage.basicPageContentIsDisplayed();
        checkoutPage.clickProceedToCheckout();
        // Valid Data
        checkoutPage.fillPaymentDetails("Ahmed" , 23476859 , 310,"December",25);
//        checkoutPage.moveToPaymentPage();
        checkoutPage.checkPaymentSuccess();
    }

    @Test(priority = 2)
    public void testInValidCheckoutData()
    {
        Checkout_Page checkoutPage = new Checkout_Page(driver);
        // temporary Login
        if (!Objects.equals(driver.getCurrentUrl(), "https://automationexercise.com/login")){
            driver.get("https://automationexercise.com/login");
            checkoutPage.temporaryLogin();
        }else {
            checkoutPage.logout();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("https://automationexercise.com/login"));
            checkoutPage.temporaryLogin();
        }
        checkoutPage.lounchPaymentPage();
        checkoutPage.basicPageContentIsDisplayed();
        // Invalid Data
        checkoutPage.clickProceedToCheckout();
        checkoutPage.fillPaymentDetails("Ahmed" , 1234556 , 000,"",00);
        checkoutPage.checkPaymentWithInvalidData();

    }
    @Test (priority = 3)
    public void testCheckOutResponseToEmptyData()
    {
        Checkout_Page checkoutPage = new Checkout_Page(driver);
        // temporary Login
        if (!Objects.equals(driver.getCurrentUrl(), "https://automationexercise.com/login")){
            driver.get("https://automationexercise.com/login");
            checkoutPage.temporaryLogin();
        }else {
            checkoutPage.logout();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("https://automationexercise.com/login"));
            checkoutPage.temporaryLogin();
        }
        checkoutPage.lounchPaymentPage();
        checkoutPage.basicPageContentIsDisplayed();
        checkoutPage.clickProceedToCheckout();
        // Empty Data
        checkoutPage.fillPaymentDetails("" , 0 , 0,"",0);
        checkoutPage.checkPaymentWithoutMandatoryData();

    }

}
//======= By Ahmed Mostafa==========

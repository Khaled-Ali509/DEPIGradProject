package Tests;

import Pages.Checkout_Page;
import Test_Base.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void registerDriverInContext(Method method , ITestContext context){
        context.setAttribute("driver" , driver);
    }

    @Test
    public void testValidCheckoutData ()
    {

        Checkout_Page checkoutPage = new Checkout_Page(driver);
        checkoutPage.temporaryLogin();
        checkoutPage.lounchPaymentPage();
        checkoutPage.basicPageContentIsDisplayed();
        // Valid Data
        checkoutPage.clickProceedToCheckout();
        checkoutPage.fillPaymentDetails("Ahmed" , 23476859 , 310,"December",25);
        checkoutPage.checkPaymentSuccess();
    }

    @Test
    public void testInValidCheckoutData()
    {
        Checkout_Page checkoutPage = new Checkout_Page(driver);

        // temporary Login
        checkoutPage.temporaryLogin();
        //-------------------------------
        checkoutPage.lounchPaymentPage();
        checkoutPage.basicPageContentIsDisplayed();
        // Invalid Data
        checkoutPage.clickProceedToCheckout();
        checkoutPage.fillPaymentDetails("Ahmed" , 1234556 , 000,"",00);
        checkoutPage.checkPaymentSuccess();
    }
    @Test
    public void testCheckOutResponseToEmptyData()
    {
        Checkout_Page checkoutPage = new Checkout_Page(driver);

        // temporary Login
        checkoutPage.temporaryLogin();
        //-------------------------------------
        checkoutPage.lounchPaymentPage();
        checkoutPage.basicPageContentIsDisplayed();
        // Empty Data
        checkoutPage.clickProceedToCheckout();
        checkoutPage.fillPaymentDetails("" , 0 , 0,"",0);
        checkoutPage.checkPaymentSuccess();
    }

}
//======= By Ahmed Mostafa==========

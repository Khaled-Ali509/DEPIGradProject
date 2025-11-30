package Pages;

import Test_Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class Checkout_Page extends BaseTest {

public Checkout_Page(WebDriver driver) {this.driver = driver;}
    // Locators
    public By payment_heading = By.xpath("//h2[@class='heading']");
    public By customerName = By.name("name_on_card");
    public By cardNumber = By.name("card_number");
    public By cvc = By.name("cvc");
    public By expirationMonth = By.name("expiry_month");
    public By expirationYear  =By.name("expiry_year");
    public By payButton = By.id("submit");
    public By deleteItem = By.xpath("//a[@class='cart_quantity_delete']");
    public By placeOrder_btn =By.xpath("//a[@href='/payment']");
    public By placeOrder_btn2 = By.xpath("//a[@class='btn btn-default check_out']");
    By successMsg = By.xpath("//p[contains(text(), 'Congratulations! Your order has been confirmed!')]");


    // Temporary Login
    public By userEmail = By.name("email");
    public By userPassword = By.name("password");
    public By login_btn = By.xpath("//button[@class='btn btn-default']");
    public By logout_btn = By.xpath("//a[@href='/logout']");

    //Actions
    public void fillPaymentDetails(String name , double number , int cvcNo , String month , int year)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(payButton));

        driver.findElement(customerName).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(Double.toString(number));
        driver.findElement(cvc).sendKeys(Integer.toString(cvcNo));
        driver.findElement(expirationMonth).sendKeys(month);
        driver.findElement(expirationYear).sendKeys(Integer.toString(year));
        driver.findElement(payButton).click();

    }


    public void lounchPaymentPage ()
    {
        driver.get("https://automationexercise.com/checkout");

    }
    public void temporaryLogin()
    {
        driver.get("https://automationexercise.com/login");
        driver.findElement(userEmail).sendKeys("khaled.leedo258@gmail.com");
        driver.findElement(userPassword).sendKeys("ِسيشسي123");
        driver.findElement(login_btn).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated( logout_btn));
        // Check if the login succeeded by moving to the home page and checking the existance of the logout button
        String homePage_url ="https://automationexercise.com/";
        Assert.assertEquals(driver.getCurrentUrl(),homePage_url);
        Assert.assertTrue(driver.findElement(logout_btn).isDisplayed());
    }
    public void clickProceedToCheckout()
    {
        boolean displayed = driver.findElement(placeOrder_btn).isDisplayed();
        boolean second_btn_displayed = driver.findElement(placeOrder_btn2).isDisplayed();

        if (displayed){
            driver.findElement(placeOrder_btn).click();
        }else if (second_btn_displayed){
            driver.findElement(placeOrder_btn2).click();
        }else {
            try {
                throw new IOException("The place order button is not displayed");
            }catch (IOException e){
                throw new RuntimeException(e);
            }

        }

    }
    public void basicPageContentIsDisplayed ()
    {
        boolean headingIsDisplayed = driver.findElement(payment_heading).isDisplayed();

    }
    public void checkPaymentSuccess()
    {

        String actualMsg = driver.findElement(successMsg).getText();
        Assert.assertEquals(actualMsg.trim(),
                "Congratulations! Your order has been confirmed!");

    }

}
//======= By Ahmed Mostafa==========


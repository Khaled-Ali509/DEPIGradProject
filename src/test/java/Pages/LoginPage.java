package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========Locators of elements===========


    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By errorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By logoutBtn = By.xpath("//a[contains(text(),' Logout')]");
    By loginTitle = By.xpath("//h2[text()='Login to your account']");

    // ===============Actions=================

    public void loginWithEmailAndPass(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void logout() {

        driver.findElement(logoutBtn).click();
    }


    // ===============Assertion=================

    public void assertLoggedInAs() {
        Assert.assertTrue(driver.findElement(loggedInText).isDisplayed(), "User should be logged in automatically after registration.");
    }

    public void assertValidationMsgForInvalidCredentials() {
        Assert.assertTrue(driver.findElement(errorMsg).isDisplayed());
        Assert.assertTrue(driver.findElement(errorMsg).getText().contains("Your email or password is incorrect!"));
    }

    public void assertMandatoryFields() {
        boolean isRequired = !driver.findElements(loggedInText).isEmpty();
        Assert.assertFalse(isRequired, "User should NOT be logged in when required fields are empty.");
    }

    public void assertSuccessfulLogout() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "User should stay on login page when password is empty.");
        Assert.assertTrue(driver.findElement(loginTitle).isDisplayed());
        Assert.assertTrue(driver.findElement(loginTitle).getText().contains("Login to your account"));
    }
}

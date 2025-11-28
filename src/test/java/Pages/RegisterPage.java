package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class RegisterPage {


    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========Locators of elements===========
    // ========== Signup (First Step) ==========
    By signupNameField = By.name("name");
    By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    By pageTitle = By.cssSelector("h2.title.text-center");
    By emailExistsMsg = By.xpath("//p[contains(text(), 'Email Address already exist')]");

    // ========== Account Information ==========
    By titleMr = By.id("id_gender1");
    By passwordField = By.id("password");
    By dayDropdown = By.id("days");
    By monthDropdown = By.id("months");
    By yearDropdown = By.id("years");
    By newsletterCheckbox = By.id("newsletter");
    By offersCheckbox = By.id("optin");
    By PassErrorMsg = By.xpath("//*[contains(text(),'8 characters')]");

    // ========== Address Information ==========
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By countryDropdown = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    // ========== Success ==========
    By accountCreatedMsg = By.xpath("//*[@data-qa='account-created']");

    // ========== Continue to home page ==========

    By ContinueToHomePage = By.xpath("//a[@data-qa='continue-button']");
    By loggedInAs = By.xpath("//*[contains(.,'Logged in as')]");


    // ===============Actions=================
    // ========== Signup (First Step) ==========
    public void firstSignup(String name, String email) {
        driver.findElement(signupNameField).sendKeys(name);
        driver.findElement(signupEmailField).sendKeys(email);
        driver.findElement(signupButton).click();
    }

    // ========== Account Information ==========
    public void fillAccountInfo(String password, String day, String month, String year) {
        driver.findElement(titleMr).click();
        driver.findElement(passwordField).sendKeys(password);

        Select select = new Select(driver.findElement(dayDropdown));
        select.selectByVisibleText(day);

        select = new Select(driver.findElement(monthDropdown));
        select.selectByVisibleText(month);

        select = new Select(driver.findElement(yearDropdown));
        select.selectByVisibleText(year);

        driver.findElement(newsletterCheckbox).click();
        driver.findElement(offersCheckbox).click();
    }

    public void fillAddressInfo(String fName, String lName, String comp, String add1, String add2,
                                String country, String st, String cy, String zip, String mobile) {

        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(company).sendKeys(comp);
        driver.findElement(address1).sendKeys(add1);
        driver.findElement(address2).sendKeys(add2);

        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText(country);

        driver.findElement(state).sendKeys(st);
        driver.findElement(city).sendKeys(cy);
        driver.findElement(zipcode).sendKeys(zip);
        driver.findElement(mobileNumber).sendKeys(mobile);

        driver.findElement(createAccountBtn).click();

    }

    // ========== Continue to home page ==========

    public void ContinueToHomePage() {
        driver.findElement(ContinueToHomePage).click();
    }

    // ===============Assertion=================

    public void assertSuccessfulNav() {
        Assert.assertTrue(driver.findElement(pageTitle).isDisplayed());
        Assert.assertTrue(driver.findElement(pageTitle).getText().contains("ENTER ACCOUNT INFORMATION"));
    }

    public void assertValidationMsgForExistEmail() {
        Assert.assertTrue(driver.findElement(emailExistsMsg).isDisplayed());
        Assert.assertTrue(driver.findElement(emailExistsMsg).getText().contains("Email Address already exist!"));
    }

    public void assertAccountCreated() {
        Assert.assertTrue(driver.findElement(accountCreatedMsg).isDisplayed(), "Account Created message should be visible.");
    }


    public void assertAccountShouldNotBeCreated() {
        boolean isAccountCreated = !driver.findElements(accountCreatedMsg).isEmpty();
        Assert.assertFalse(isAccountCreated, "Account should NOT be created when required fields are empty.");
    }

    public void assertWeakPasswordShouldBeRejected() {
        List<WebElement> errors = driver.findElements(PassErrorMsg);
        boolean errorMessageDisplayed = !errors.isEmpty();
        boolean isAccountCreated = !driver.findElements(accountCreatedMsg).isEmpty();
        Assert.assertTrue(errorMessageDisplayed || !isAccountCreated, "Weak password should be rejected (account must NOT be created).");
    }

    public void assertVerifyInvalidEmailFormatOnStep1() {
        boolean isStep2NotVisible = driver.findElements(pageTitle).isEmpty();

        Assert.assertTrue(isStep2NotVisible,
                "User should NOT reach Step 2 when email is invalid.");

    }

    public void assertLoggedInAs() {
        Assert.assertTrue(driver.findElement(loggedInAs).isDisplayed(), "User should be logged in automatically after registration.");
    }

}

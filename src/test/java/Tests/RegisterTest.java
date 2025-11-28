package Tests;


import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class RegisterTest {

    WebDriver driver;
    RegisterPage registerPage;


    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/login");

        registerPage = new RegisterPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyUserCanNavToSignupSuccessfully() {
        String randomEmail = "khalid" + UUID.randomUUID() + "@test.com";

        registerPage.firstSignup("Khaled Ali", randomEmail);
        registerPage.assertSuccessfulNav();
    }


    //======Verify email format validation
    @Test
    public void VerifyEmailFormatValidation() {

        registerPage.firstSignup("Khaled Ali", "khaledexample.com");
        registerPage.assertVerifyInvalidEmailFormatOnStep1();
    }


    //=====Verify registration with existing email shows an error
    @Test
    public void verifyUserCanNotSignupWithRegisteredEmail() {
        registerPage.firstSignup("Khaled Ali", "khaled.leedo258@gmail.com");
        registerPage.assertValidationMsgForExistEmail();
    }


    //========Verify user can register with valid data
    @Test
    public void verifyUserCanSignupSuccessfully() {

        driver.get("https://automationexercise.com/signup");

        String randomEmail = "khalid" + UUID.randomUUID() + "@test.com";

        // Step 1: Enter name & unused email
        registerPage.firstSignup("Khaled Ali", randomEmail);

        // Step 2: Fill account info
        registerPage.fillAccountInfo("12345678", "10", "May", "1999");

        // Step 3: Fill address info
        registerPage.fillAddressInfo(
                "Khaled",
                "Ali",
                "Test Company",
                "Cairo, Egypt",
                "Giza",
                "India",
                "Maharashtra",
                "Mumbai",
                "400001",
                "01000000000"
        );

        registerPage.assertAccountCreated();
    }

    //=====Verify mandatory fields validation in registration form
    @Test
    public void verifyRequiredFieldsValidation() {

        driver.get("https://automationexercise.com/signup");

        String randomEmail = "khalid" + UUID.randomUUID() + "@test.com";

        // Step 1: Enter name & unused email
        registerPage.firstSignup("Khaled Ali", randomEmail);

        // Step 2: Leave all required fields empty

        registerPage.assertAccountShouldNotBeCreated();
    }

//======Verify password length validation during registration

    @Test
    public void verifyPasswordMinLengthValidation() {

        driver.get("https://automationexercise.com/signup");

        String randomEmail = "khalid" + UUID.randomUUID() + "@test.com";

        // Step 1: Enter name & unused email
        registerPage.firstSignup("Khaled Ali", randomEmail);

        // Step 2: Fill account info
        registerPage.fillAccountInfo("123", "10", "May", "1999");

        // Step 3: Fill address info
        registerPage.fillAddressInfo(
                "Khaled",
                "Ali",
                "Test Company",
                "Cairo, Egypt",
                "Giza",
                "India",
                "Maharashtra",
                "Mumbai",
                "400001",
                "01000000000"
        );

        registerPage.assertWeakPasswordShouldBeRejected();
    }

    //======Verify that user is automatically logged in after successful registration
    @Test
    public void verifyUserAutomaticallyLoggedInAfterSuccessfulRegistration() {

        driver.get("https://automationexercise.com/signup");

        String randomEmail = "khalid" + UUID.randomUUID() + "@test.com";

        // Step 1: Enter name & unused email
        registerPage.firstSignup("Khaled Ali", randomEmail);

        // Step 2: Fill account info
        registerPage.fillAccountInfo("12345678", "10", "May", "1999");

        // Step 3: Fill address info
        registerPage.fillAddressInfo(
                "Khaled",
                "Ali",
                "Test Company",
                "Cairo, Egypt",
                "Giza",
                "India",
                "Maharashtra",
                "Mumbai",
                "400001",
                "01000000000"
        );
        // Step 4 : Assert Account Created
        registerPage.assertAccountCreated();

        // Step 5 : Continue To Home Page
        registerPage.ContinueToHomePage();

        // Step 6 : Assert LoggedIn As
        registerPage.assertLoggedInAs();


    }
}

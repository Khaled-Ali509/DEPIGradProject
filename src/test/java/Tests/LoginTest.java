package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/login");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    //===Verify user can log in with valid credentials
    @Test
    public void verifyLoginWithValidCredentials() {
        loginPage.loginWithEmailAndPass("khaled.leedo258@gmail.com", "ِسيشسي123");
        loginPage.assertLoggedInAs();
    }

    //===Verify login fails with invalid password
    @Test
    public void verifyLoginFailsWithInvalidPassword() {
        loginPage.loginWithEmailAndPass("khaled.leedo258@gmail.com", "12");
        loginPage.assertValidationMsgForInvalidCredentials();
    }

    //===Verify login fails with unregistered email
    @Test
    public void verifyLoginFailsWithUnregisteredEmail() {
        loginPage.loginWithEmailAndPass("Khaled96asd@gmail.com", "سيشسي123");
        loginPage.assertValidationMsgForInvalidCredentials();
    }

    //===Verify email and password fields are mandatory
    @Test
    public void verifyEmailAndPasswordFieldsAreMandatory() {
        loginPage.loginWithEmailAndPass("", "");
        loginPage.assertMandatoryFields();
    }

    //===Verify user is redirected to login page after logout
    @Test
    public void VerifyUserIsRedirectedToLoginPageAfterLogout() {
        loginPage.loginWithEmailAndPass("khaled.leedo258@gmail.com", "ِسيشسي123");
        loginPage.logout();
        loginPage.assertSuccessfulLogout();
    }
}
//=============By Khaled Ali==============

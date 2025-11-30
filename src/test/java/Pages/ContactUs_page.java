package Pages;

import Test_Base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class ContactUs_page extends BaseTest {

    public WebDriver driver;

    public ContactUs_page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    public By visitor_name = By.name("name");
    public By visitor_email = By.name("email");
    public By visitor_subject = By.name("subject");
    public By visitor_message = By.id("message");
    public By visitor_submit = By.name("submit");
    public By system_success_message = By.xpath("//div[@class='status alert alert-success']");
//    private By uploadFile_btn = By.name("upload_file");
    public By file_name = By.name("choose file");
    // Actions
    public void contactUs(String visitorName, String visitorEmail, String visitorSubject, String visitorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(visitor_name));

        driver.findElement(visitor_name).clear();
        driver.findElement(visitor_email).clear();
        driver.findElement(visitor_subject).clear();
        driver.findElement(visitor_message).clear();

        driver.findElement(visitor_name).sendKeys(visitorName);
        driver.findElement(visitor_email).sendKeys(visitorEmail);
        driver.findElement(visitor_subject).sendKeys(visitorSubject);
        driver.findElement(visitor_message).sendKeys(visitorMessage);
//        driver.findElement(file_name).sendKeys("D:/targetFile/uploadedFile.pdf");
//        driver.findElement(uploadFile_btn).click();
        driver.findElement(visitor_submit).click();
    }

    // Assertions
    public void validMessaging() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for alert and accept it
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Says: " + alert.getText());
        alert.accept();

        // Wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(system_success_message));
        String actualResponse = driver.findElement(system_success_message).getText();

        Assert.assertTrue(actualResponse.contains("Success! Your details have been submitted successfully."),
                "Expected Success message not found! Actual: " + actualResponse);
    }

    public void missingAllMandatoryFields()
    {
        String actualResponse = driver.findElement(system_success_message).getText();
        Assert.assertFalse(driver.findElement(system_success_message).isDisplayed());
        Assert.assertTrue(actualResponse.contains("You should fill in all fields"),"Expected Error Message is not found! Instead This message: " + actualResponse.toUpperCase() + " is displayed");

    }
    public void missingMandatoryFieldsExceptEmail()
    {
        Assert.assertTrue(driver.findElement(system_success_message).isDisplayed());
        if (driver.findElement(system_success_message).isDisplayed()) {
            String actualResponse = driver.findElement(system_success_message).getText();
            Assert.assertTrue(actualResponse.contains("You should fill in all fields"), "Expected Error Message is not found! Instead This message: " + actualResponse.toUpperCase() + " is displayed");
        }else{
            try {
                throw new IOException("The message response is not displayed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
//    public void validateUploadFile ()
//    {
//        Assert.assertTrue(driver.findElement(uploadFile_btn).isDisplayed());
//        driver.findElement(uploadFile_btn).click();
//        driver.findElement(file_name).sendKeys("D:/targetFile/uploadedFile.pdf");
//        driver.findElement(file_name).getText();
//        if (file_name.equals("uploadedFile.pdf"))
//        {
//            System.out.println("file uploaded successfully");
//        }else {
//            System.out.println("Failed to upload file");
//        }
//    }

}
//======= By Ahmed Mostafa==========

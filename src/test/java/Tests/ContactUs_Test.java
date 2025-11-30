
package Tests;

import Pages.ContactUs_page;
import Test_Base.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ContactUs_Test extends BaseTest {


        @BeforeMethod
        public void registerDriverInContext(Method method, ITestContext context) {
            context.setAttribute("driver", driver);
        }


    @Test
    public void testValidContactUs() {
        driver.get("https://automationexercise.com/contact_us");
        ContactUs_page contactUsPage = new ContactUs_page(driver);

        contactUsPage.contactUs("Ahmed", "ashmaweyahmed7@gmail.com", "Need Help", "I need these products");
        contactUsPage.validMessaging();
    }

    @Test
    public void testMissingAllMandatoryFields(){
        driver.get("https://automationexercise.com/contact_us");
        ContactUs_page contactUsPage;
        contactUsPage = new ContactUs_page(driver);
        contactUsPage.contactUs("","","","");

        contactUsPage.missingAllMandatoryFields();
    }

    @Test
    public void testMissingMandatoryFieldsExceptEmail()
    {
        driver.get("https://automationexercise.com/contact_us");
        ContactUs_page contactUsPage;
        contactUsPage = new ContactUs_page(driver);
        contactUsPage.contactUs("","ashmaweyahmed7@gmail.com","","");

        contactUsPage.missingMandatoryFieldsExceptEmail();
    }
//    @Test
////    public void testValidateUploadFile()
//    {
//        driver.get("https://automationexercise.com/contact_us");
//        ContactUs_page contactUsPage =new ContactUs_page(driver);
//        contactUsPage.contactUs("Ahmed", "ashmaweyahmed7@gmail.com", "Need Help", "I need these products");
////        contactUsPage.validateUploadFile();
//
//    }
}
//======= By Ahmed Mostafa==========


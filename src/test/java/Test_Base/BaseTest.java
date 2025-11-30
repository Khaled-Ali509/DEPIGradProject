package Test_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

@BeforeMethod
public void setUp(){

    EdgeOptions options = new EdgeOptions();
    options.addArguments("--disable-notifications");
    driver = new EdgeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@AfterMethod
    public void tearDown()
{
    if (driver !=null) {
        driver.quit();
    }
}


}

//======= By Ahmed Mostafa==========



package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class softAssert {
    //verify that the login button is anable
    //verify  the use login to the website HMRS perfectly
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(groups = "smoke")
    public void loginTestCase() {
        //locating the username field
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        //locating the password field
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        //locating the submit button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));

        //verify that loginBtn is enable
        boolean statusOfloginBtn = loginBtn.isEnabled();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(statusOfloginBtn);

        //login to website
        loginBtn.click();
        //Locate the welcome Admin
        WebElement actualMsg = driver.findElement(By.id("welcome"));
        String actualMessage = actualMsg.getText();
        //verifying that user has login
        soft.assertEquals(actualMessage, "Welcome Admi");
        soft.assertAll();

    }
        @AfterMethod(alwaysRun = true)
        public void tearDown () {
            driver.quit();
        }
    }


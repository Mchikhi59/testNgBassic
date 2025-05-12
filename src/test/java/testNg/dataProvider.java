package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class dataProvider {

    //decalre the dataprovider
    @DataProvider(name = "credentials")
    public Object[][] data() {
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password is Empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;
    }
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(dataProvider = "credentials",groups = {"smoke"})
    public void loginTest(String usrname,String pass, String ExpectedErrMsg){

        //locating the username field
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys(usrname);
        //locating the password field
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys(pass);
        //locating the submit button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));
        loginBtn.click();
          //verify the error message
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualErrorMsg = errorMsg.getText();

        Assert.assertEquals(actualErrorMsg,ExpectedErrMsg);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}

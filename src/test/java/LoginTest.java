import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    private String UserName = "Admin";
    private String Password = "admin123";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/");
        loginPage = new LoginPage(driver);

    }
    @Test
    public void login (){
        loginPage.login(UserName, Password);
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
    @Test
    public void login_without_username (){
        loginPage.login("", Password);
        Assert.assertTrue(loginPage.usernameReqired());
    }
    @Test
    public void login_without_password (){
        loginPage.login(UserName, "");
        Assert.assertTrue(loginPage.passwordReqired());
    }
    @Test
    public void login_with_Invalid_credentials(){
        loginPage.login("invaildUserName","4387969D");
        Assert.assertTrue(loginPage.IsInvalidCredentials());
    }
@AfterMethod
    public void exit(){
        driver.quit();
}

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SignOutPage;

public class SignOutTest {
    WebDriver driver;
    SignOutPage signOutPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/");
        loginPage = new LoginPage(driver);
        signOutPage = new SignOutPage(driver);
    }

    @Test
    public void testSignOut() {
        loginPage.login("hussein@gmail.com", "12345678");
        signOutPage.clickLogOut();
        Assert.assertTrue(signOutPage.isAtLoginPage(), "User should be redirected to login page after sign out.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

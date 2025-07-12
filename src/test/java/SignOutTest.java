import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        signOutPage = new SignOutPage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void SignOut(){
        loginPage.login("hussein@gmail.com","12345678");
        signOutPage.clickLogOut();
        Assert.assertTrue(signOutPage.IsLoginPage());
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SignInPage;

public class SigninTest {
    WebDriver driver;
    SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/");
        signInPage = new SignInPage(driver);
    }

    @Test
    public void testValidSignUp() {
        signInPage.signUp("hussein2@gmail.com", "Hussein", "Sabry", "12345678");

        String expectedUrl = "http://www.automationpractice.pl/index.php?controller=my-account";
        Assert.assertEquals(signInPage.getCurrentUrl(), expectedUrl, "User should be redirected to account page after successful signup.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

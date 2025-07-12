import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    private final String username = "Admin";
    private final String password = "admin123";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithValidCredentials() {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }

    @Test
    public void testLoginWithoutUsername() {
        loginPage.login("", password);
        Assert.assertTrue(loginPage.isUsernameRequired(), "Username error message should be displayed.");
    }

    @Test
    public void testLoginWithoutPassword() {
        loginPage.login(username, "");
        Assert.assertTrue(loginPage.isPasswordRequired(), "Password error message should be displayed.");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.login("invalidUser", "wrongPass");
        Assert.assertTrue(loginPage.isInvalidCredentials(), "Invalid credentials error message should be displayed.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

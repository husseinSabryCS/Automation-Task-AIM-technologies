import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SigningTest {
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
public void ValidSignUp(){
        signInPage.SignUp("hussein2@gmail.com","hussein","sabry","12345678");

    Assert.assertEquals(signInPage.isSignUpSuccessful(),"http://www.automationpractice.pl/index.php?controller=my-account");

}

//    @AfterMethod
//    public void exit(){
//        driver.quit();
//    }
}

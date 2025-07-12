package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SignOutPage {
    WebDriver driver;
    WebDriverWait wait;

    private final String loginPageUrl = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

    public SignOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By logoutButton = By.className("logout");

    // Actions
    public void clickLogOut() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    // Verification
    public boolean isAtLoginPage() {
        return wait.until(ExpectedConditions.urlToBe(loginPageUrl));
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By loginPageLink = By.className("login");
    private By email = By.id("email");
    private By password = By.id("passwd");
    private By loginButton = By.id("SubmitLogin");
    private By dashboardHeader = By.id("header_logo");
    private By errorMessage = By.xpath("//div[@class='alert alert-danger']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Helper Methods
    private void waitAndType(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    private void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    private boolean isElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).isDisplayed();
    }

    // Actions
    public void goToLoginPage() {
        waitAndClick(loginPageLink);
    }

    public void enterUsername(String username) {
        waitAndType(email, username);
    }

    public void enterPassword(String password) {
        waitAndType(this.password, password);
    }

    public void clickLogin() {
        waitAndClick(loginButton);
    }

    public void login(String username, String password) {
        goToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Verifications
    public boolean isLoginSuccessful() {
        return isElementVisible(dashboardHeader);
    }

    public boolean isUsernameRequired() {
        return isElementVisible(errorMessage);
    }

    public boolean isPasswordRequired() {
        return isElementVisible(errorMessage);
    }

    public boolean isInvalidCredentials() {
        return isElementVisible(errorMessage);
    }
}

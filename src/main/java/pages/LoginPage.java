package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;



    // locators
    private By loginPageLink= By.className("login");
    private By email = By.id("email");
    private By password = By.id("passwd");
    private By loginButton = By.id("SubmitLogin");
    private By dashboardHeader = By.id("header_logo");
    private By usernameErrorMessage = By.xpath("//div[@class='alert alert-danger']");
    private By passwordMessage = By.xpath("//div[@class='alert alert-danger']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
public void  GoToLoginPage(){
        wait.until(ExpectedConditions.elementToBeClickable(loginPageLink));
        driver.findElement(loginPageLink).click();
}
    public void EnterUserName(String UserName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).sendKeys(UserName);
    }

    public void EnterPassword(String Password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys(Password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void login(String UserName,String Password) {
        GoToLoginPage();
        EnterUserName(UserName);
        EnterPassword(Password);
        clickLogin();
    }

    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        return driver.findElement(dashboardHeader).isDisplayed();
    }
    public boolean usernameReqired() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameErrorMessage));
        return driver.findElement(usernameErrorMessage).isDisplayed();
    }
    public boolean passwordReqired() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordMessage));
        return driver.findElement(passwordMessage).isDisplayed();
    }
    public boolean IsInvalidCredentials(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordMessage));
        return driver.findElement(passwordMessage).isDisplayed();

    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SignInPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By signupPageLink = By.className("login");
    private By emailInput = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By genderRadio = By.id("id_gender1");
    private By firstNameInput = By.id("customer_firstname");
    private By lastNameInput = By.id("customer_lastname");
    private By passwordInput = By.id("passwd");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By newsletterCheckbox = By.id("uniform-newsletter");
    private By registerButton = By.id("submitAccount");

    // Helper Methods
    private void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    private void waitAndType(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    private void selectDropdownByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    // Actions
    public void goToSignupPage() {
        waitAndClick(signupPageLink);
    }

    public void typeEmail(String email) {
        waitAndType(emailInput, email);
    }

    public void clickCreateAccount() {
        waitAndClick(createAccountButton);
    }

    public void selectGender() {
        waitAndClick(genderRadio);
    }

    public void enterFirstName(String firstName) {
        waitAndType(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        waitAndType(lastNameInput, lastName);
    }

    public void enterPassword(String password) {
        waitAndType(passwordInput, password);
    }

    public void selectDay(String day) {
        selectDropdownByValue(daysDropdown, day);
    }

    public void selectMonth(String month) {
        selectDropdownByValue(monthsDropdown, month);
    }

    public void selectYear(String year) {
        selectDropdownByValue(yearsDropdown, year);
    }

    public void selectNewsletterCheckbox() {
        waitAndClick(newsletterCheckbox);
    }

    public void clickRegister() {
        waitAndClick(registerButton);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Main sign up function
    public void signUp(String email, String firstName, String lastName, String password) {
        goToSignupPage();
        typeEmail(email);
        clickCreateAccount();
        selectGender();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPassword(password);
        selectDay("1");
        selectMonth("1");
        selectYear("2025");
        selectNewsletterCheckbox();
        clickRegister();
    }
}

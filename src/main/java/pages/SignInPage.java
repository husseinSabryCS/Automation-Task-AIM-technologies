package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
//    locators
    private By signupPageLink= By.className("login");
    private By email = By.id("email_create");
    private By createAccount =By.id("SubmitCreate");
    private By Gender = By.id("id_gender1");
    private By FirstName = By.id("customer_firstname");
    private By LastName = By.id("customer_lastname");
    private By Password = By.id("passwd");
    private By days = By.id("days");
    private By months=By.id("months");
    private By years =By.id("years");
    private By checkbox =By.id("uniform-newsletter");
    private By Register = By.id("submitAccount");




    public void  GoToSignupPage(){
        wait.until(ExpectedConditions.elementToBeClickable(signupPageLink));
        driver.findElement(signupPageLink).click();
    }
    public void typeEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.email));
        driver.findElement(this.email).sendKeys(email);
    }
    public void ClickCreateAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(createAccount));
        driver.findElement(createAccount).click();
    }
    public void  SelectGender(){
        wait.until(ExpectedConditions.elementToBeClickable(Gender));
        driver.findElement(Gender).click();
    }
    public void EnterFristName (String firstName){
        wait.until(ExpectedConditions.elementToBeClickable(FirstName));
        driver.findElement(FirstName).sendKeys(firstName);
    }
    public void EnterLastName(String lastName){
        wait.until(ExpectedConditions.elementToBeClickable(LastName));
        driver.findElement(LastName).sendKeys(lastName);
    }
    public void EnterPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(Password));
        driver.findElement(Password).sendKeys(password);
    }

    public void SelectDay(){
        WebElement dropdown = driver.findElement(days);
        Select select = new Select(dropdown);
        select.selectByValue("1");
    }
    public void Selectmonth(){
        WebElement dropdown = driver.findElement(months);
        Select select = new Select(dropdown);
        select.selectByValue("1");
    }
    public void Selectyear(){
        WebElement dropdown = driver.findElement(years);
        Select select = new Select(dropdown);
        select.selectByValue("2025");
    }
    public void SelectCheckbox(){
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        driver.findElement(checkbox).click();
    }
    public void ClickRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(Register));
        driver.findElement(Register).click();
    }
    public String isSignUpSuccessful() {
        String URL=  driver.getCurrentUrl();

        return URL;
    }
    public void SignUp(String email,String firstName,String lastName ,String password){
        GoToSignupPage();
        typeEmail(email);
        ClickCreateAccount();
        SelectGender();
        EnterFristName (firstName);
        EnterLastName(lastName);
        EnterPassword(password);
        SelectDay();
        Selectmonth();
        Selectyear();
        SelectCheckbox();
        ClickRegister();
    }

}


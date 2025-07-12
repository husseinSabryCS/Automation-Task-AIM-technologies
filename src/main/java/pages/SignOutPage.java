package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignOutPage {
    WebDriver driver;
    WebDriverWait wait;
    public SignOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
//    locators
    private By logout_button  = By.className("logout");



    public  void clickLogOut(){
        wait.until(ExpectedConditions.elementToBeClickable(logout_button));
        driver.findElement(logout_button).click();
    }
    public boolean IsLoginPage(){
      boolean IsSignout = wait.until(ExpectedConditions.urlToBe("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account"));
    return IsSignout;
    }
}

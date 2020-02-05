package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
    @FindBy(id = "username")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "Login")
    WebElement loginButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void isOpen(){
        driver.get("https://seniorlink--staging.cs93.my.salesforce.com/");
        isPageOpened();
        PageFactory.initElements(driver, LogInPage.this);
    }
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Login")));
        } catch (TimeoutException ex) {
            System.out.println("Page is not opened");
            throw new TimeoutException("Page is not opened");
        }
    }
    public void logInUser(String userName, String password){
        emailInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}

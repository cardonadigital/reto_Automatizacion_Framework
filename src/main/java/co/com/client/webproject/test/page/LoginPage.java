package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @CacheLookup
    @FindBy(id = "Email")
    WebElement fieldEmail;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement fieldPassword;

    @CacheLookup
    @FindBy(className = "login-button")
    WebElement sendCredentials;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getFieldEmail() {
        return fieldEmail;
    }

    public WebElement getFieldPassword() {
        return fieldPassword;
    }

    public WebElement getSendCredentials() {
        return sendCredentials;
    }
}

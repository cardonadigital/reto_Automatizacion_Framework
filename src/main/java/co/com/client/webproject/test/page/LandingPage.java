package co.com.client.webproject.test.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @CacheLookup
    @FindBy(className = "ico-register")
    WebElement register;

    @CacheLookup
    @FindBy(className = "ico-login")
    WebElement login;

    @CacheLookup
    @FindBy(className = "cart-label")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(), 'Books')]")
    WebElement booksModule;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(), 'Contact')]")
    WebElement contactModule;


    public WebElement getContactModule() {
        return contactModule;
    }

    public WebElement getRegister(){
        return register;
    }


    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getBooksModule() {
        return booksModule;
    }

    public WebElement getLogin() {
        return login;
    }

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}

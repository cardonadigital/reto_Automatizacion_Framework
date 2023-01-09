package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @CacheLookup
    @FindBy(id = "termsofservice")
    WebElement termsOfService;

    @CacheLookup
    @FindBy(id = "checkout")
    WebElement checkout;


    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getTermsOfService() {
        return termsOfService;
    }

    public WebElement getCheckout() {
        return checkout;
    }
}

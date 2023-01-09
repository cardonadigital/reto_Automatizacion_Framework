package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulCheckoutPage {
    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(), 'order')]")
    WebElement messageOrder;

    public SuccessfulCheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getMessageOrder() {
        return messageOrder;
    }
}

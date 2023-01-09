package co.com.client.webproject.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    private WebDriver driver;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Confirm']")
    WebElement confirmButton;


    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public List<WebElement> getContinueButtons() {
        return driver.findElements(By.xpath("//input[@value='Continue']"));
    }
}

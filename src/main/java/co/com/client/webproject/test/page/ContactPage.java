package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    @CacheLookup
    @FindBy(id = "FullName")
    WebElement fieldName;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement fieldEmail;

    @CacheLookup
    @FindBy(id = "Enquiry")
    WebElement fieldEnquiry;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(), 'Enter enquiry')]")
    WebElement enquiryWarning;

    @CacheLookup
    @FindBy(className = "contact-us-button")
    WebElement submitButton;

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getEnquiryWarning() {
        return enquiryWarning;
    }

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getFieldName() {
        return fieldName;
    }

    public WebElement getFieldEmail() {
        return fieldEmail;
    }

    public WebElement getFieldEnquiry() {
        return fieldEnquiry;
    }
}

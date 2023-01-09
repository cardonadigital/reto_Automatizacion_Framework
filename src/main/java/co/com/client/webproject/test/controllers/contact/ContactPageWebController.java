package co.com.client.webproject.test.controllers.contact;

import co.com.client.webproject.test.controllers.checkout.CheckoutWebController;
import co.com.client.webproject.test.page.ContactPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactPageWebController {
    private WebAction webAction;

    public ContactPageWebController setWebAction(WebAction webAction) {
        this.webAction = webAction;
        return this;
    }

    public ContactPageWebController fillFields(String name, String email){
        try {
            ContactPage contactPage = new ContactPage(webAction.getDriver());
            webAction.sendText(contactPage.getFieldName(), name, true);
            webAction.sendText(contactPage.getFieldEmail(), email, true);
            webAction.click(contactPage.getSubmitButton(), true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrió un error al llenar los campos name y email del modulo de contacto", e);
        }return this;
    }

    public String getEnquiryWarning(){
        String message = "";
        try {
            ContactPage contactPage = new ContactPage(webAction.getDriver());
            message = webAction.getText(contactPage.getEnquiryWarning(), true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la pagina de registro", e);
        }return message;
    }


    public static ContactPageWebController contactPageWebController() {
        return new ContactPageWebController();
    }
}

package co.com.client.webproject.test.controllers.successfulcheckout;

import co.com.client.webproject.test.controllers.shoppingcart.ShoppingCartWebController;
import co.com.client.webproject.test.page.SuccessfulCheckoutPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class SuccessfulCheckoutWebController {

    private WebAction webAction;


    public SuccessfulCheckoutWebController setWebAction(WebAction webAction) {
        this.webAction = webAction;
        return this;
    }

    public String getCheckoutMessage(){
        String message = "";
        try {
            SuccessfulCheckoutPage successfulCheckoutPage = new SuccessfulCheckoutPage(webAction.getDriver());
            message = webAction.getText(successfulCheckoutPage.getMessageOrder(), true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrió al capturar el mensaje de checkout exitoso", e);
        }return message;
    }

    public static SuccessfulCheckoutWebController successfulCheckoutWebController() {
        return new SuccessfulCheckoutWebController();
    }
}

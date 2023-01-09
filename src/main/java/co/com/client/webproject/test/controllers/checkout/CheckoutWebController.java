package co.com.client.webproject.test.controllers.checkout;

import co.com.client.webproject.test.controllers.books.BookPageWebController;
import co.com.client.webproject.test.page.CheckoutPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CheckoutWebController {

    private WebAction webAction;

    public CheckoutWebController setWebAction(WebAction webAction) {
        this.webAction = webAction;
        return this;
    }

    public void doCheckout(){
        try {
            CheckoutPage checkoutPage = new CheckoutPage(webAction.getDriver());
            checkoutPage.getContinueButtons().stream().forEach(
                    element -> {
                        try {
                            webAction.scroll(50);
                            webAction.click(element, true);
                        } catch (WebActionsException e) {
                            Report.reportFailure("Ocurrió al realizar el checkout", e);
                        }
                    }
            );
            webAction.scroll(800);
            webAction.click(checkoutPage.getConfirmButton(), true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la pagina de registro", e);
        }

    }



    public static CheckoutWebController checkoutWebController() {
        return new CheckoutWebController();
    }
}

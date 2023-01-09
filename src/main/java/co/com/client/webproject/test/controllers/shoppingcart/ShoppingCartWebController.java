package co.com.client.webproject.test.controllers.shoppingcart;


import co.com.client.webproject.test.page.LandingPage;
import co.com.client.webproject.test.page.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ShoppingCartWebController {
    private WebAction webAction;


    public ShoppingCartWebController setWebAction(WebAction webAction) {
        this.webAction = webAction;
        return this;
    }

    public ShoppingCartWebController checkoutProducts(){
        try {
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());
            webAction.moveTo(landingPage.getShoppingCart(), false);
            webAction.click(landingPage.getShoppingCart(), true);
            webAction.moveTo(shoppingCartPage.getTermsOfService(), false);
            webAction.click(shoppingCartPage.getTermsOfService(), true);
            webAction.moveTo(shoppingCartPage.getCheckout(), false);
            webAction.click(shoppingCartPage.getCheckout(), true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrió al realizar el checkout",e);
        }return this;

    }


    public static ShoppingCartWebController shoppingCartWebController() {
        return new ShoppingCartWebController();
    }
}

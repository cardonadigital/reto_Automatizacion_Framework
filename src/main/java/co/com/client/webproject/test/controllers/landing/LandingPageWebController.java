package co.com.client.webproject.test.controllers.landing;

import co.com.client.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class LandingPageWebController {
    private WebAction webAction;

    public LandingPageWebController setWebAction(WebAction webAction) {
        this.webAction = webAction;
        return this;
    }


    public LandingPageWebController goToContactPage() {
        try {
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.scroll(1000);
            webAction.click(landingPage.getContactModule(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió al ingresar al modulo de contacto", e);
        }
        return this;
    }

    public static LandingPageWebController landingPageWebController(){
        return new LandingPageWebController();
    }


}

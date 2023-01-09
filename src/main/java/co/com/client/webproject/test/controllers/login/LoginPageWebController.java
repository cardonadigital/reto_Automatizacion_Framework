package co.com.client.webproject.test.controllers.login;

import co.com.client.webproject.test.page.LandingPage;
import co.com.client.webproject.test.page.LoginPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class LoginPageWebController {
    private WebAction webAction;

    public LoginPageWebController setWebAction(WebAction webAction) {
        this.webAction = webAction;
        return this;
    }


    public LoginPageWebController loginUser(String username, String password) {
        try {
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            LoginPage loginPage = new LoginPage(webAction.getDriver());
            webAction.click(landingPage.getLogin(), 2, true);
            webAction.sendText(loginPage.getFieldEmail(), username, true);
            webAction.sendText(loginPage.getFieldPassword(), password, true);
            webAction.click(loginPage.getSendCredentials(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un erro al loguear un usuario", e);
        }
        return this;
    }

    public static LoginPageWebController loginPageWebController() {
        return new LoginPageWebController();
    }
}

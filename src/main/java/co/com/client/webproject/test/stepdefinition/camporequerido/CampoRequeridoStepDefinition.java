package co.com.client.webproject.test.stepdefinition.camporequerido;

import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.stepdefinition.GeneralSetUp;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static co.com.client.webproject.test.controllers.contact.ContactPageWebController.contactPageWebController;
import static co.com.client.webproject.test.controllers.landing.LandingPageWebController.landingPageWebController;
import static co.com.client.webproject.test.controllers.login.LoginPageWebController.loginPageWebController;
import static co.com.client.webproject.test.controllers.successfulcheckout.SuccessfulCheckoutWebController.successfulCheckoutWebController;

public class CampoRequeridoStepDefinition extends GeneralSetUp {
    private WebAction webAction;
    private static String name = "melo12345";
    private static String email = "melo12345@gmail.com";

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente navegó a la página de contacto")
    public void queElClienteNavegóALaPáginaDeContacto() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
        landingPageWebController()
                .setWebAction(webAction)
                .goToContactPage();
    }

    @Cuando("el cliente ingresa todos los campos menos el de Enquiry")
    public void elClienteIngresaTodosLosCamposMenosElDeEnquiry() {
        contactPageWebController()
                .setWebAction(webAction)
                .fillFields(name, email);
    }

    @Entonces("el sistema debera mostrar el siguiente mensaje: {string}")
    public void elSistemaDeberaMostrarElSiguienteMensaje(String message) {
        Assert.Hard.thatString(
                contactPageWebController()
                        .setWebAction(webAction).getEnquiryWarning()).isEqualTo(message);
    }

    @After
    public void tearDown() throws WebActionsException {
        webAction.pause(5, false);
        // Cerrar el driver
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}

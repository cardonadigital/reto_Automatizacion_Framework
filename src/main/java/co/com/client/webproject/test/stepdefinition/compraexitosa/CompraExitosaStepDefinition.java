package co.com.client.webproject.test.stepdefinition.compraexitosa;

import co.com.client.webproject.test.controllers.login.LoginPageWebController;
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
import cucumber.api.java.es.Y;

import static co.com.client.webproject.test.controllers.books.BookPageWebController.bookPageWebController;
import static co.com.client.webproject.test.controllers.checkout.CheckoutWebController.checkoutWebController;
import static co.com.client.webproject.test.controllers.login.LoginPageWebController.loginPageWebController;
import static co.com.client.webproject.test.controllers.shoppingcart.ShoppingCartWebController.shoppingCartWebController;
import static co.com.client.webproject.test.controllers.successfulcheckout.SuccessfulCheckoutWebController.successfulCheckoutWebController;

public class CompraExitosaStepDefinition extends GeneralSetUp {

    private WebAction webAction;
    private static String username = "melo12345@gmail.com";
    private static String password = "melo12345";
    private static String successMessage = "Your order has been successfully processed!";

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());

    }

    @Dado("que el cliente se logueo correctamente")
    public void queElClienteSeLogueoCorrectamente() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
        loginPageWebController()
                .setWebAction(webAction)
                .loginUser(username, password);
    }

    @Cuando("el cliente ingresa los productos en el carrito de compras")
    public void elClienteIngresaLosProductosEnElCarritoDeCompras() {
        bookPageWebController().setWebAction(webAction).addProductsToCart();
    }

    @Y("el cliente realiza el checkout")
    public void elClienteRealizaElCheckout() {
        shoppingCartWebController().setWebAction(webAction).checkoutProducts();
        checkoutWebController().setWebAction(webAction).doCheckout();
    }

    @Entonces("el sistema debera mostrar que la compra ha sido exitosa")
    public void elSistemaDeberaMostrarQueLaCompraHaSidoExitosa() {
        Assert.Hard.thatString(
                successfulCheckoutWebController().setWebAction(webAction).getCheckoutMessage()).isEqualTo(successMessage);
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

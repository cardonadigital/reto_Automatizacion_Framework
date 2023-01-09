package co.com.client.webproject.test.controllers.books;

import co.com.client.webproject.test.page.BooksPage;
import co.com.client.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class BookPageWebController {

    private WebAction webAction;

    public BookPageWebController setWebAction(WebAction webAction) {
        this.webAction = webAction;
        return this;
    }


    public BookPageWebController addProductsToCart(){
        try {
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getBooksModule(), true);
            BooksPage booksPage = new BooksPage(webAction.getDriver());
            webAction.moveTo(booksPage.getProduct1(), false);
            webAction.click(booksPage.getProduct1(), true);
            webAction.moveTo(booksPage.getProduct2(), false);
            webAction.click(booksPage.getProduct2(), true);
        }catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al agregar productos al carrito de compras", e);
        }return this;
    }


    public static BookPageWebController bookPageWebController() {
        return new BookPageWebController();
    }
}

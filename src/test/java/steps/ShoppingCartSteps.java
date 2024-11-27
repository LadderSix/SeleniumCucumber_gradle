package steps;

import pages.ShoppingCartPage;
import io.cucumber.java.en.And;

public class ShoppingCartSteps {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @And("Elimino producto del carrito")
    public void eliminoProductoDelCarrito(){
        shoppingCartPage.eliminaItem();
        shoppingCartPage.irAlCheckout();
    }
}

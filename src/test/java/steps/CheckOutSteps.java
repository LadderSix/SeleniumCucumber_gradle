package steps;

import pages.CheckOutPage;
import io.cucumber.java.en.And;

public class CheckOutSteps {

   CheckOutPage checkOutPage = new CheckOutPage();

    @And("Realizo el Checkout")
    public void realizoElCheckout() {
        checkOutPage.realizarCheckout();
    }

    @And("Ingreso a seccion Order History")
    public void ingresoASeccionOrderHistory() {
        checkOutPage.irASeccionOrderHistory();
    }

    
}

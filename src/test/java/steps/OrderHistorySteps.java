package steps;

import pages.OrderHistoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class OrderHistorySteps {

    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();

    @Then("Visualizo detalle de la orden")
    public void visualizoDetalleOrden() {
        orderHistoryPage.visualizarInformacionDeOrden();
    }
}

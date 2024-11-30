package steps;

import pages.OrderHistoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OrderHistorySteps {

    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();

    @Then("Visualizo detalle de la orden")
    public void visualizoDetalleOrden(){
        orderHistoryPage.visualizarInformacionDeOrden();
        orderHistoryPage.capturaDePantalla();

    }
}

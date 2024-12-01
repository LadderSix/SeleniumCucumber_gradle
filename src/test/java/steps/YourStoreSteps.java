package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyAccountPage;
import io.cucumber.java.en.And;

public class YourStoreSteps {

    MyAccountPage myAccountPage = new MyAccountPage();

    @And("Ingresar a Seccion YourStore")
    public void ingresarASeccionYourStore() {
        myAccountPage.ingresoSeccionYourStore();
    }

    @And("Agrego productos al carrito")
    public void agregoXProductosAMiCarrito() {
        myAccountPage.agregoItemMacbook();
        myAccountPage.agregoAlCarrito();

        myAccountPage.menuHome();

        myAccountPage.agregoItemIphone();
        myAccountPage.agregoAlCarrito();

        myAccountPage.menuHome();

        myAccountPage.agregoItemCamara();
        myAccountPage.agregoAlCarrito();

        myAccountPage.irAlCarrito();

    }
}

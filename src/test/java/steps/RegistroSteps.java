package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistroPage;
import utils.MetodosGenericos;

public class RegistroSteps {
    RegistroPage registroPage = new RegistroPage();


    @When("Ingresamos a seccion New Customer")
    public void ingresamosASeccionNewCustomer() {
        registroPage.goToRegisterPage();
    }

    @And("Completar formulario de ingreso")
    public void completarFormularioDeIngreso() {
        registroPage.completaFormularioDeRegistro();
    }

    @Then("Validamos registro correcto de usuario")
    public void validamosRegistroCorrectoDeUsuario() {
        registroPage.validaCreacionDeCliente();
    }

}

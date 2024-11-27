package steps;

import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @When("Ingreso credenciales para acceder {} {}")
    public void ingresoCredencialesParaAcceder(String email, String password) {
        loginPage.ingresoCredencialesIncorrectas(email, password);
    }

    @When("Ingreso credenciales validas")
    public void ingresoCredencialesValidas() {
        loginPage.ingresoCredencialesCorrectas();
    }

    @And("Presiono boton Login")
    public void presionoBotonLogin() {
        loginPage.btnLogin();
    }

    @Then("Visualizamos mensaje de error por credenciales incorrectas")
    public void visualizamosMensajeDeError() {
        loginPage.validaMsjError();
    }

}

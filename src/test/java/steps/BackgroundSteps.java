package steps;

import constants.Constant;
import constants.Navegador;
import driverConfig.DriverContext;
import io.cucumber.java.en.Given;

import static org.junit.Assert.assertEquals;

public class BackgroundSteps {

    @Given("Ingreso a la Web Abstracta")
    public void ingresoALaWebAbstracta() {
        DriverContext.setUp(Navegador.Chrome, Constant.url);
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(Constant.url, url);
    }
}

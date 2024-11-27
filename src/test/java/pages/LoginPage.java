package pages;


import driverConfig.DriverContext;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import utils.MetodosGenericos;
import utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//div[@class='col-sm-6'][.//*[@id='input-email']]")
    private WebElement LoginContainer;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement imputEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement imputPassword;

    @FindBy(xpath = "//input[@value=\"Login\"]")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[contains(@class, 'alert')] ")
    private WebElement msjError;


    public void ingresoCredencialesIncorrectas(String email, String password) {
        MetodosGenericos.accionSenkeys(imputEmail, email);
        MetodosGenericos.accionSenkeys(imputPassword, password);
        System.out.println("Credenciales Incorrectas Ingresadas !");

    }

    public void ingresoCredencialesCorrectas() {
        MetodosGenericos.esperar(2);
        MetodosGenericos.accionSenkeys(imputEmail, PropertyReader.getProperty("email"));
        MetodosGenericos.accionSenkeys(imputPassword, PropertyReader.getProperty("pass"));
        System.out.println("Credenciales Validas Ingresadas !");

    }

    public void btnLogin(){
        MetodosGenericos.accionClick(btnLogin);
    }

    public void validaMsjError(){
        try {
            String msj = MetodosGenericos.accionGetText(msjError);

            assertEquals("Warning: No match for E-Mail Address and/or Password.",msj);

        } catch (NoSuchElementException ex) {
            ex.getMessage();
        }

    }

}

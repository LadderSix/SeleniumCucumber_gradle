package pages;


import driverConfig.DriverContext;
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

    @FindBy(xpath = "//i[@class=\"fa fa-exclamation-circle\"]")
    private WebElement msjError;


    public void ingresoCredencialesIncorrectas(String email, String password) {
        MetodosGenericos.esperar(2);
        MetodosGenericos.accionSenkeys(imputEmail, email);
        MetodosGenericos.esperar(2);
        MetodosGenericos.accionSenkeys(imputPassword, password);
        System.out.println("Credenciales Ingresadas !");

    }

    public void ingresoCredencialesCorrectas() {
        MetodosGenericos.accionSenkeys(imputEmail, PropertyReader.getProperty("email"));
        MetodosGenericos.esperar(2);
        MetodosGenericos.accionSenkeys(imputPassword, PropertyReader.getProperty("pass"));
        System.out.println("Credenciales Validas Ingresadas !");

    }

    public void btnLogin(){
        MetodosGenericos.esperar(2);
        MetodosGenericos.accionClick(btnLogin);
    }

    public void validaMsjError(){
        try{
            String msj = MetodosGenericos.accionGetText(msjError);
            System.out.println(msj);

            switch (msj){
                case "" :
                    assertEquals("",msj);
                    break;
                case " Warning" :
                    assertEquals(" Warning.",msj);
                    break;
            }

        }catch (Exception e){
            e.getMessage();
        }
    }

}

package pages;

import driverConfig.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

public class RegistroPage {

    private WebDriver driver;

    public RegistroPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement btnRegister;

    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    private WebElement titleNewCustomerSection;

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement inputTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//input[@name=\"agree\"]")
    private WebElement chekboxPrivacyPolicy;

    @FindBy(xpath = "//input[@value=\"Continue\"]")
    private WebElement btnContinue;


    public void goToRegisterPage() {
        MetodosGenericos.visualizarObjeto(btnRegister,10);
        btnRegister.click();
    }

    public void completaFormularioDeRegistro() {
        MetodosGenericos.visualizarObjeto(inputFirstName,10);
        MetodosGenericos.accionSenkeys(inputFirstName,"Tester");
        MetodosGenericos.accionSenkeys(inputLastName,"Senior");
        MetodosGenericos.accionSenkeys(inputEmail,"xxxxx@tester.cl");
        MetodosGenericos.accionSenkeys(inputTelephone,"9212448844");

        MetodosGenericos.accionSenkeys(inputPassword,"1234");
        MetodosGenericos.accionSenkeys(inputConfirmPassword,"1234");

        chekboxPrivacyPolicy.click();
        btnContinue.click();
    }

    public void validaCreacionDeCliente() {
        MetodosGenericos.capturaDePantallaCompleta();
    }
}

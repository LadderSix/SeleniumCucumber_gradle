package pages;

import driverConfig.DriverContext;
import org.openqa.selenium.*;
import utils.MetodosGenericos;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }


    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    private WebElement inputFirstname;

    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='input-payment-company']")
    private WebElement inputCompany;

    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    private WebElement inputAdress1;

    @FindBy(xpath = "//input[@id='input-payment-address-2']")
    private WebElement inputAdress2;

    @FindBy(xpath = "//input[@id='input-payment-city']")
    private WebElement inputCity;

    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    private WebElement inputPostCode;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    private WebElement btnPaymentAdress;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    private WebElement btnShippingAdress;

    @FindBy(xpath = "//p//textarea[@name='comment']")
    private WebElement textareaComment;

    @FindBy(xpath = "//div//input[@name=\"agree\"]")
    private WebElement checkboxAgree;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    private WebElement btnShippingMethod;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    private WebElement btnPaymentMethod;

    @FindBy(xpath = "//input[@id='button-confirm']")
    private WebElement btnConfirmOrder;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement btnContinue;

    @FindBy(xpath = "(//li//a[text()=\"Order History\"])[1]")
    private WebElement btnMenuOrderHistory;

    @FindBy(xpath = "//select[@id='input-payment-country']")
    private WebElement drpCountry;

    @FindBy(xpath = "//select[@id='input-payment-zone']")
    private WebElement drpZone;

    private void selectCountry(String country) {
        try {
            Select select = new Select(drpCountry);
            List<WebElement> optionListCountry = select.getOptions();

            for (WebElement option : optionListCountry) {
                if(option.getText().equals(country)) {
                    option.click();
                    break;
                }
            }
        }catch (ElementNotInteractableException e){
            e.getMessage();
        }
        MetodosGenericos.esperar(3);

    }

    private void selectZone(String zone) {
        try {
            Select select = new Select(drpZone);
            List<WebElement> optionListCountry = select.getOptions();

            for (WebElement option : optionListCountry) {
                if(option.getText().equals(zone)) {
                    option.click();
                    break;
                }
            }
        }catch (ElementNotInteractableException e){
            e.getMessage();
        }
    }


    public void realizarCheckout() {

        MetodosGenericos.visualizarObjeto(inputFirstname,10);
        MetodosGenericos.accionSenkeys(inputFirstname, "Tester");

        inputLastName.sendKeys("Senior");
        inputCompany.sendKeys("Tecnova");
        inputAdress1.sendKeys("Direccion1");
        inputAdress2.sendKeys("Direccion2");
        inputCity.sendKeys("Santiago");
        inputPostCode.sendKeys("8150000");

        selectCountry("Chile");
        selectZone("Region Metropolitana");

        MetodosGenericos.visualizarObjeto(btnPaymentAdress,10);
        btnPaymentAdress.click();

        MetodosGenericos.visualizarObjeto(btnShippingAdress,10);
        btnShippingAdress.click();

        MetodosGenericos.visualizarObjeto(btnShippingMethod,10);
        btnShippingMethod.click();

        MetodosGenericos.visualizarObjeto(textareaComment,10);
        textareaComment.sendKeys("Matias Rojas xx-xx-2024");

        MetodosGenericos.visualizarObjeto(checkboxAgree,10);
        checkboxAgree.click();

        MetodosGenericos.visualizarObjeto(btnPaymentMethod,10);
        btnPaymentMethod.click();

        MetodosGenericos.visualizarObjeto(btnConfirmOrder,10);
        btnConfirmOrder.click();

        MetodosGenericos.visualizarObjeto(btnContinue,10);
        btnContinue.click();

        System.out.println("Orden Confirmada!");
    }

    public void irASeccionOrderHistory(){
        btnMenuOrderHistory.click();
    }
}

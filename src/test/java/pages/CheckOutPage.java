package pages;

import driverConfig.DriverContext;
import utils.MetodosGenericos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//input[@id='input-payment-adress-1']")
    private WebElement inputAdress1;

    @FindBy(xpath = "//input[@id='input-payment-adress-2']")
    private WebElement inputAdress2;

    @FindBy(xpath = "//input[@id='input-payment-city']")
    private WebElement inputCity;

    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    private WebElement inputPostCode;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    private WebElement btnPaymentAdress;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    private WebElement btnShippingAdress;

    @FindBy(xpath = "textarea[name=\"comment\"]")
    private WebElement textareaComment;

    @FindBy(xpath = "input[name=\"agree\"]")
    private WebElement checkboxAgree;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    private WebElement btnShippingMethod;

    @FindBy(xpath = "//input[@id='button-confirm']")
    private WebElement btnConfirmOrder;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement btnContinue;

    @FindBy(xpath = "(//li//a[text()=\"Order History\"])[1]")
    private WebElement btnMenuOrderHistory;


    public void realizarCheckout() {

        inputFirstname.sendKeys("Tester");
        inputLastName.sendKeys("Senior");
        inputCompany.sendKeys("Tecnova");
        inputAdress1.sendKeys("Direccion1");
        inputAdress2.sendKeys("Direccion2");
        inputCity.sendKeys("Santiago");
        inputPostCode.sendKeys("8150000");

        Select drpCountry = new Select(driver.findElement(By.name("country_id")));
        drpCountry.selectByVisibleText("Chile");

        Select drpZone = new Select(driver.findElement(By.name("zone_id")));
        drpZone.selectByVisibleText("Region Metropolitana");

        btnPaymentAdress.click();

        MetodosGenericos.esperar(3);

        btnShippingAdress.click();

        MetodosGenericos.esperar(3);

        btnShippingMethod.click();

        textareaComment.sendKeys("Matias Rojas 15-11-2024");
        checkboxAgree.click();

        MetodosGenericos.esperar(3);
        btnConfirmOrder.click();

        MetodosGenericos.esperar(3);
        btnContinue.click();

    }

    public void irASeccionOrderHistory(){
        btnMenuOrderHistory.click();
    }
}

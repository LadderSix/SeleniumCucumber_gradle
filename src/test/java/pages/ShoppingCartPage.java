package pages;

import driverConfig.DriverContext;
import utils.MetodosGenericos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private WebDriver driver;

    public ShoppingCartPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }


    @FindBy(xpath = "(//button[@title=\"Remove\"])[1]")
    private WebElement btnEliminarProducto;

    @FindBy(xpath = "(//p//a//strong)[2]")
    private WebElement btnCheckoutCart;

    @FindBy(xpath = "//button[contains(@data-loading-text, 'Loading...')]")
    private WebElement btnShoppingCart;


    public void eliminaItem(){
        MetodosGenericos.visualizarObjeto(btnEliminarProducto,10);
        MetodosGenericos.accionClick(btnEliminarProducto);
        System.out.println("Item Eliminado!");


    }
    public void goToCart(){

        MetodosGenericos.visualizarObjeto(btnShoppingCart,10);
        MetodosGenericos.esperar(5);
        MetodosGenericos.accionClick(btnShoppingCart);
        System.out.println("Presionando Carrito!...");


    }

    public void irAlCheckout(){
        MetodosGenericos.visualizarObjeto(btnCheckoutCart, 10);
        MetodosGenericos.esperar(5);
        MetodosGenericos.accionClick(btnCheckoutCart);

    }
}

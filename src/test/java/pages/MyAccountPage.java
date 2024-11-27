package pages;

import driverConfig.DriverContext;
import utils.MetodosGenericos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }


    @FindBy(xpath = "//a[contains(text(),'Your Store')]")
    private WebElement sectionYourStore;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    private WebElement homeButton;

    @FindBy(xpath = "//div[@id='cart']")
    private WebElement btnShoppingCart;

    @FindBy(xpath = "//div[@class='image']//img[@title='MacBook']")
    private WebElement itemMacbook;

    @FindBy(xpath = "//div[@class='image']//img[@title='iPhone']")
    private WebElement itemiPhone;

    @FindBy(xpath = "//img[@title='Apple Cinema 30\"']")
    private WebElement itemMonitor;

    @FindBy(xpath = "//div[@class='image']//img[@title='Canon EOS 5D']")
    private WebElement itemCamara;

    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "")
    private WebElement msjExitosoProductoAgregadoAlCarro;

   @FindBy(xpath = "(//div[@class=\"checkbox\"]//input)[1]")
   private WebElement checkbox3;

   @FindBy(xpath = "//textarea[@Placeholder=\"Textarea\"]")
   private WebElement textareaMonitor;

   @FindBy(xpath = "(//input)[13]")
   private WebElement btnUploadFile;

    public void ingresoSeccionYourStore() {
        MetodosGenericos.accionClick(sectionYourStore);
    }

    public void menuHome(){
        MetodosGenericos.waitExplicit(homeButton,2);
        homeButton.click();

    }

    public void irAlCarrito(){
        btnShoppingCart.click();
        MetodosGenericos.esperar(3);
    }

    public void agregoItemMacbook() {

        boolean response = MetodosGenericos.visualizarObjeto(itemMacbook, 20);
        System.out.println(response);

        if (response) {
            MetodosGenericos.scrollElement(itemMacbook, driver);
            itemMacbook.click();
        }
    }

    public void agregoItemIphone() {

        boolean response = MetodosGenericos.visualizarObjeto(itemiPhone, 20);
        System.out.println(response);

        if (response) {
            MetodosGenericos.scrollElement(itemiPhone,driver);
            itemiPhone.click();
        }
    }

    public void agregoItemCamara() {

        boolean response = MetodosGenericos.visualizarObjeto(itemCamara, 20);
        System.out.println(response);

        if (response) {
            MetodosGenericos.scrollElement(itemCamara,driver);
            itemCamara.click();
        }

        Select drpCountry = new Select(driver.findElement(By.name("option[226]")));
        drpCountry.selectByVisibleText("Red ");

    }

    /*public void agregoItemMonitor() {

        boolean response = MetodosGenericos.visualizarObjeto(itemMonitor, 20);
        System.out.println(response);

        if (response) {
            MetodosGenericos.scrollElement(itemMonitor,driver);
            itemMonitor.click();
        }

        checkbox3.click();

        Select drpCountry = new Select(driver.findElement(By.name("option[217]")));
        drpCountry.selectByVisibleText("Red (+$4.00) ");

        textareaMonitor.sendKeys("esta es una prueba automatizada por Matias Rojas");

        File file = new File("C:\\Users\\Matias Rojas\\Downloads\\Evaluacion Automatización 2024.pdf");
        System.out.println("Cargando archivo!");
        MetodosGenericos.esperar(3);
        btnUploadFile.sendKeys(file.getAbsolutePath());
        MetodosGenericos.esperar(3);

        //driver.switchTo().alert().accept();
        System.out.println("Archivo cargado");
    }*/

    public void agregoAlCarrito(){
        //MetodosGenericos.waitExplicit(btnAddToCart,2);
        MetodosGenericos.accionClick(btnAddToCart);
        System.out.println("Item Agregado!");
        MetodosGenericos.esperar(1);
    }

    public void msjExitosoProductoAgregadoAlCarrito(){

        String msjExitoso = msjExitosoProductoAgregadoAlCarro.getText();
        System.out.println(msjExitoso);



    }

}

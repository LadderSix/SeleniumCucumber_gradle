package pages;

import driverConfig.DriverContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    private WebDriver driver;

    public OrderHistoryPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }


    @FindBy(xpath = "")
    private WebElement btnEliminarProducto;
}

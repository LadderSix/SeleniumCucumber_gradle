package pages;

import driverConfig.DriverContext;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;
import utils.MetodosGenericos;

import java.io.File;

public class OrderHistoryPage {

    private WebDriver driver;

    public OrderHistoryPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//a[@class='btn btn-info']")
    private WebElement btnOrderInformation;


    public void capturaDePantalla() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverContext.getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir") + "\\test-output\\screenshots\\OrderInformation.png");
        sourceFile.renameTo(targetFile);
    }


    public void visualizarInformacionDeOrden() {
        MetodosGenericos.visualizarObjeto(btnOrderInformation,10);
        btnOrderInformation.click();


    }
}

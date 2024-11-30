package pages;

import driverConfig.DriverContext;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MetodosGenericos;

import java.io.File;
import java.io.IOException;

public class OrderHistoryPage {

    private WebDriver driver;

    public OrderHistoryPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//a[@class='btn btn-info']")
    private WebElement btnOrderInformation;


    public void capturaDePantallaCompleta(){
        try{
            TakesScreenshot takesScreenshot = (TakesScreenshot) DriverContext.getDriver();
            File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File tgt = new File(System.getProperty("user.dir") + "\\test-output\\screenshots\\OrderInformation.png");
            System.out.println("Captura de pantalla generada");
            FileUtils.copyFile(src, tgt);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void visualizarInformacionDeOrden() {
        MetodosGenericos.visualizarObjeto(btnOrderInformation,10);
        btnOrderInformation.click();
        capturaDePantallaCompleta();
    }
}

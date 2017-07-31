package POM.AvmgRu;

import POM.AvmgBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 12.07.2017.
 */
public class AvmgServicesPage extends AvmgBasePage{

    String AvmgServicestPageUrl = "https://ru.avmg.com.ua/uslugi/";

    public AvmgServicesPage(String browser) {
        super(browser);
    }

    public AvmgServicesPage(WebDriver driver) {
        super(driver);
    }

    public AvmgGasCuttingMetalPage goToGasCuttingMetalPage(){
        getDriver().findElement(By.cssSelector("img[src*=\"gazovay-rezka\"]")).click();
        return new AvmgGasCuttingMetalPage(getDriver());
    }

    public AvmgPlasmaCuttingMetalPage goToPlasmaCuttingMetalPage(){
        getDriver().findElement(By.cssSelector("img[src*=\"843/rezka\"]")).click();
        return new AvmgPlasmaCuttingMetalPage(getDriver());
    }

    public AvmgCuttingBandSawPage goToCuttingBandSaw(){
        getDriver().findElement(By.cssSelector("img[src*=\"lentochniy-stanok\"]")).click();
        return new AvmgCuttingBandSawPage(getDriver());
    }
}

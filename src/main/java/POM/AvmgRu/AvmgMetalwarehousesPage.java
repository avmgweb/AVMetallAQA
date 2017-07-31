package POM.AvmgRu;

import POM.AvmgBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public class AvmgMetalwarehousesPage extends AvmgBasePage {
    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]/a")
    private List<WebElement> allRegions;

    public static String AvmgMetalwarehousesUrl = "https://avmg.com.ua/metallobaza/";


    public AvmgMetalwarehousesPage(String browser) {
        super(browser);
        goToUrl(AvmgMetalwarehousesUrl);
    }

    public AvmgMetalwarehousesPage(WebDriver driver) {
        super(driver);
    }

    public AvmgMetalwarehousesRegionPage goToRegion(String region) throws InterruptedException {
        for (WebElement obl : allRegions) {
            if (obl.getAttribute("href").contains(region)) {
                goToUrl(obl.getAttribute("href"));
                break;
            }
        }
        return new AvmgMetalwarehousesRegionPage(getDriver());
    }
}


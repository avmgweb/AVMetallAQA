package POM.AvmgPage.AvmgMetalwarehouses;

import POM.AvmgPage.AvmgBasePage;
import POM.AvmgPage.AvmgMetalwarehousesRegionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 22.08.2017.
 */
public abstract class  AvmgMetalwarehousesAbstract extends AvmgBasePage {

    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]/a")
    private List<WebElement> allRegions;

    public static String AvmgMetalwarehousesUrl;

    public AvmgMetalwarehousesAbstract(String browser) {
        super(browser);
        goToUrl(AvmgMetalwarehousesUrl);
    }

    public AvmgMetalwarehousesAbstract(WebDriver driver) {
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

    public abstract boolean isFilterTownDisplayed();

    public abstract boolean isFilterRegionDisplayed();

    public abstract boolean isFilterTypeDisplayed();

    public abstract boolean isFilterMainDirectionsDisplayed();

    public boolean isCancelFiltrDisplayed(){
        return isElementDisplayed(By.className("av-form-button-alt2"));
    }

    public boolean checkMainDirectionsFilter() throws InterruptedException {
        List<WebElement> filtrs= getDriver().findElements(By.cssSelector("input[name=\"AV_BASES_FILTER_pf[streams][]\"]"));
        for (WebElement filtr : filtrs){
            this.setAttribute(getDriver(),filtr,"style", "display:block");
            filtr.click();
            //in process
        }
        return true;
    }
}

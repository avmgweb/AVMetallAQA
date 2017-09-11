package POM.AvmgPage.AvmgMainPage;

import POM.AvmgPage.AvmgBasePage;
import POM.AvmgPage.AvmgContactPage;
import POM.AvmgPage.AvmgMetalwarehouses.AvmgMetalwarehousesAbstract;
import POM.AvmgPage.AvmgMetalwarehouses.AvmgMetalwarehousesPageRu;
import POM.AvmgPage.AvmgMetalwarehouses.AvmgMetalwarehousesPageUa;
import POM.AvmgPage.AvmgServicesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Дмитрий on 22.08.2017.
 */
public abstract class AvmgMainPageAbstract extends AvmgBasePage {

    public AvmgMainPageAbstract(String browser) {
        super(browser);
    }

    public AvmgMainPageAbstract(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-av-at-avmg-main-menu=\"link main\" and @href=\"/metallobaza/\"]")
    private WebElement metalwarehousesButton;

    @FindBy(xpath = "//a[@data-av-at-avmg-main-menu=\"link main\" and @href=\"/contacts/\"]")
    private WebElement contactButton;

    @FindBy(xpath = "//a[@data-av-at-avmg-main-menu=\"link main parent-24\" and @href=\"/uslugi/\"]")
    private WebElement servicesButton;

    public static String AvmgMainPageUrl;



    public AvmgMetalwarehousesAbstract goToAvmgMetalwarehousesPage(String lg){
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(metalwarehousesButton));
        metalwarehousesButton.click();
        switch (lg){
            case "ua" : return new AvmgMetalwarehousesPageUa(getDriver());
            case "ru" : return new AvmgMetalwarehousesPageRu(getDriver());
        }
        return null;
    }


    public AvmgContactPage goToContactPage(){
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(contactButton));
        contactButton.click();
        return new AvmgContactPage(getDriver());
    }

    public AvmgServicesPage goToServicesPage(){
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(servicesButton));
        servicesButton.click();
        return new AvmgServicesPage(getDriver());
    }


}

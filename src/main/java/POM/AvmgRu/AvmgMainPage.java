package POM.AvmgRu;

import POM.AvmgBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public class AvmgMainPage extends AvmgBasePage {

    @FindBy(xpath = "//a[@data-av-at-avmg-main-menu=\"link main\" and @href=\"/metallobaza/\"]")
    private WebElement metalwarehousesButton;

    @FindBy(xpath = "//a[@data-av-at-avmg-main-menu=\"link main\" and @href=\"/contacts/\"]")
    private WebElement contactButton;

    @FindBy(xpath = "//a[@data-av-at-avmg-main-menu=\"link main parent-24\" and @href=\"/uslugi/\"]")
    private WebElement servicesButton;

    public static String AvmgMainPageUrl = "https://ru.avmg.com.ua/";

    public AvmgMainPage(String browser) {
        super(browser);
        goToUrl(AvmgMainPageUrl);
    }

    public AvmgMainPage(WebDriver driver) {
        super(driver);
    }

    public AvmgMetalwarehousesPage goToAvmgMetalwarehousesPage(){
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(metalwarehousesButton));
        metalwarehousesButton.click();
        return new AvmgMetalwarehousesPage(getDriver());
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



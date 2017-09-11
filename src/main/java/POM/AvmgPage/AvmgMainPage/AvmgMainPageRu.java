package POM.AvmgPage.AvmgMainPage;

import POM.AvmgPage.AvmgBasePage;
import POM.AvmgPage.AvmgContactPage;
import POM.AvmgPage.AvmgMetalwarehouses.AvmgMetalwarehousesPageUa;
import POM.AvmgPage.AvmgServicesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public class AvmgMainPageRu extends AvmgMainPageAbstract {

    private static String link404 = "https://ru.avmg.com.ua/404";
    public static String AvmgMainPageUrl = "https://ru.avmg.com.ua/";

    public AvmgMainPageRu(String browser) {
        super(browser);
        goToUrl(AvmgMainPageUrl);
    }

    public AvmgMainPageRu(WebDriver driver) {
        super(driver);
    }

    public static String get404Page() {
        return link404;
    }

    public AvmgMainPageUa goToAvmgMainPageUa(){
        goToUrl(AvmgMainPageUa.AvmgMainPageUrl);
        return new AvmgMainPageUa(getDriver());
    }


}



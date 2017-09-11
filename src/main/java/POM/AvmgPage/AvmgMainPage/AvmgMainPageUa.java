package POM.AvmgPage.AvmgMainPage;

import POM.AvmgPage.AvmgBasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 01.08.2017.
 */
public class AvmgMainPageUa extends AvmgMainPageAbstract {

    private static String link404 = "https://avmg.com.ua/404";

    public AvmgMainPageUa(String browser) {
        super(browser);
        goToUrl(AvmgMainPageUrl);
    }

    public AvmgMainPageUa(WebDriver driver) {
        super(driver);
    }

    public static String get404Page() {
        return link404;
    }


    public static String AvmgMainPageUrl = "https://avmg.com.ua/";
}

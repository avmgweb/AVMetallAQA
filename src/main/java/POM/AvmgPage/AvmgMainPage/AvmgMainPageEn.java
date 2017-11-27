package POM.AvmgPage.AvmgMainPage;

import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 11.09.2017.
 */
public class AvmgMainPageEn extends  AvmgMainPageAbstract {

    private static String link404 = "https://en.avmg.com.ua/404";
    public static String AvmgMainPageUrl = "https://en.avmg.com.ua/";

    public AvmgMainPageEn(String browser) {
        super(browser);
        goToUrl(AvmgMainPageUrl);
    }

    public AvmgMainPageEn(WebDriver driver) {
        super(driver);
    }

    public static String get404Page() {
        return link404;
    }
}

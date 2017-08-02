package POM.AvmgUa;

import POM.AvmgBasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 01.08.2017.
 */
public class AvmgMainPageUa extends AvmgBasePage{
    public AvmgMainPageUa(String browser) {
        super(browser);
        goToUrl(AvmgMainPageUrlUa);
    }

    public AvmgMainPageUa(WebDriver driver) {
        super(driver);
    }

    public static String AvmgMainPageUrlUa = "https://avmg.com.ua/";


}

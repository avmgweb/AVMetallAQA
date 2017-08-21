package POM.AvmgRu;

import POM.AvmgBasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 12.07.2017.
 */
public class AvmgGasCuttingMetalPage extends AvmgBasePage{

    String AvmgGasCuttingMetalPage = "https://ru.avmg.com.ua/uslugi/gazovaya-rezka-metalla/";

    public AvmgGasCuttingMetalPage(String browser) {
        super(browser);
    }

    public AvmgGasCuttingMetalPage(WebDriver driver) {
        super(driver);
    }



}

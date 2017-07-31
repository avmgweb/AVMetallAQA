package POM.AvmgRu;

import POM.AvmgBasePage;
import POM.classes.RequestAvmg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

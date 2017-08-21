package POM.AvmgRu;

import POM.AvmgBasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 11.07.2017.
 */
public class AvmgContactPage extends AvmgBasePage {

    String AvmgContactPageUrl = "https://ru.avmg.com.ua/contacts/";

    public AvmgContactPage(String browser) {
        super(browser);
    }

    public AvmgContactPage(WebDriver driver) {
        super(driver);
    }



    public void refresh() {
        getDriver().navigate().to(AvmgContactPageUrl);
    }

}

package POM;

import POM.BasePage;
import POM.classes.CareerAvmg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Created by Дмитрий on 16.05.2017.
 */
public class AdminBasePage extends BasePage {
    public AdminBasePage(String browser) {
        super(browser);
    }

    public AdminBasePage(WebDriver driver) {
        super(driver);
    }


    public void logOut(){
        getDriver().findElement(By.xpath("//a[text()=\"Выйти\"]")).click();
    }

    public  AvmgBasePage goToUrlFormBasePage(String url) {
        goToUrl(url);
        return new  AvmgBasePage(getDriver());
    }


}

package POM.AdminPage;

import POM.AdminBasePage;
import POM.AdminPage.AdminAvmgSettingsFormPage;
import POM.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 12.05.2017.
 */
public class AdminAvmgMainPage extends AdminBasePage {


    public AdminAvmgMainPage(String browser) {
        super(browser);
    }

    public AdminAvmgMainPage(WebDriver driver) {
        super(driver);
    }


    public AdminAvmgSettingsFormPage goToSettingsFormPage() throws InterruptedException {
        if (isElementDisplayed(By.cssSelector("input[name=\"close\"]")))
            type("click", By.cssSelector("input[name=\"close\"]"), "");

        if (getDriver().findElement(By.className("adm-header-language")).getText().equals("UA") ||
                getDriver().findElement(By.className("adm-header-language")).getText().equals("EN")){
            type("click", By.className("adm-header-language"), "");
            type("click", By.xpath("//*[text()=\"(ru) Russian\"]"), "");
        }

        type("click", By.id("global_menu_services"), "");
        Thread.sleep(1000);
        goToPoints(189,1745);
        if (!(isElementDisplayed(By.xpath("//*[text()=\"Настройка форм\"]")))){
            type("click", By.xpath("//*[contains (text(), \"Веб-форм\") ]"), "");
        }
        type("click", By.xpath("//*[text()=\"Настройка форм\"]"), "");
        return new AdminAvmgSettingsFormPage(getDriver());
    }


}


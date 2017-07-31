package POM.AdminPage;

import POM.AdminBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 26.06.2017.
 */
public class AdminAvmgSettingsFormPage extends AdminBasePage {
    public AdminAvmgSettingsFormPage(String browser) {
        super(browser);
    }

    public AdminAvmgSettingsFormPage(WebDriver driver) {
        super(driver);
    }


    public AdminAvmgSettingsFormPage setFilterById(String idForm) {
        if (!getDriver().findElement(By.cssSelector("input[name=\"find_id\"]")).isDisplayed()) {
            type("click", By.className("adm-filter-add-button"), "");
            type("click", By.xpath("//*[@class = \"bx-core-popup-menu-item-text\" and contains(text(), 'ID формы') ]"), "");
        }
        type("write", By.cssSelector("input[name=\"find_id\"]"), idForm);
        type("click", By.cssSelector("input[name=\"set_filter\"]"), "");
        return new AdminAvmgSettingsFormPage(getDriver());
    }

    public AdminAvmgResultsFormPage goToResultsFormPage(String id) throws InterruptedException {
        String xpath = "//a[contains(@href,'form_result_list.php?lang=ru&WEB_FORM_ID=" + id + "')]";
        type("click", By.xpath(xpath), "");
        return new AdminAvmgResultsFormPage(getDriver());
    }
}
//https://avmg.com.ua/bitrix/admin/form_result_list.php?lang=ru&WEB_FORM_ID=12
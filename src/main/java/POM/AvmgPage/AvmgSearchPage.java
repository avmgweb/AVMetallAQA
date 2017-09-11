package POM.AvmgPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 01.08.2017.
 */
public class AvmgSearchPage extends AvmgBasePage {
    public AvmgSearchPage(String browser) {
        super(browser);
    }

    public AvmgSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isListOfProductionButtonDisplayed() {
        return isElementDisplayed(By.className("av-form-elements-av_site_alt-button"));
    }

    public boolean isSearchListDisplayed(){
        return isElementDisplayed(By.className("items-list"));
    }

    public AvmgSearchPage searchFromPage (String key){
        type("wait", By.className("av-form-elements-element-search"), "");
        type("write", By.className("av-form-elements-element-search"), key);
        getDriver().findElement(By.className("av-form-elements-element-search")).sendKeys(Keys.ENTER);
        return this;
    }

    public int returnNumberOfPages() {
        return Integer.parseInt(getDriver().findElement(By.xpath("//*[@class=\"page\"]")).getText());
    }
}

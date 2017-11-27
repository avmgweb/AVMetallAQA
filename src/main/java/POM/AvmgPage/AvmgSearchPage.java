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
        return isElementDisplayed(By.className("av-form-button-alt"));
    }

    public boolean isSearchListDisplayed(){
        return isElementDisplayed(By.className("items-list"));
    }

    public AvmgSearchPage searchFromPage (String key){
        type("wait", By.xpath("//div[@data-av-form-item=\"search\"]/input"), "");
        type("write", By.xpath("//div[@data-av-form-item=\"search\"]/input"), key);
        getDriver().findElement(By.xpath("//div[@data-av-form-item=\"search\"]/input")).sendKeys(Keys.ENTER);
        return this;
    }

    public int returnNumberOfPages() {
        return Integer.parseInt(getDriver().findElement(By.xpath("//*[@class=\"page\"]")).getText());
    }
}

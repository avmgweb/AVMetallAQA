package POM.AvmgPage.AvmgMetalwarehouses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 22.08.2017.
 */
public class AvmgMetalwarehousesPageRu extends AvmgMetalwarehousesAbstract{

    public static String AvmgMetalwarehousesUrl = "https://ru.avmg.com.ua/metallobaza/";

    public AvmgMetalwarehousesPageRu(String browser) {
        super(browser);
    }

    public AvmgMetalwarehousesPageRu(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFilterTownDisplayed() {
        return isElementDisplayed(By.xpath("//*[@class=\"title-label\" and @title=\"Город\"]"));
    }

    @Override
    public boolean isFilterRegionDisplayed() {
        return isElementDisplayed(By.xpath("//*[@class=\"title-label\" and @title=\"Область\"]"));
    }

    @Override
    public boolean isFilterTypeDisplayed() {
        return isElementDisplayed(By.xpath("//*[@class=\"title-label\" and @title=\"Тип обьекта\"]"));
    }

    @Override
    public boolean isFilterMainDirectionsDisplayed() {
        return isElementDisplayed(By.cssSelector("div[class=\"av-form-select-multiple\"]"));
    }


}

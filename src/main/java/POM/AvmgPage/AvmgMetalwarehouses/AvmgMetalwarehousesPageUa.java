package POM.AvmgPage.AvmgMetalwarehouses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public class AvmgMetalwarehousesPageUa extends AvmgMetalwarehousesAbstract {

    public static String AvmgMetalwarehousesUrl = "https://avmg.com.ua/metallobaza/";


    public AvmgMetalwarehousesPageUa(String browser) {
        super(browser);
    }

    public AvmgMetalwarehousesPageUa(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFilterTownDisplayed() {
        return isElementDisplayed(By.xpath("//*[@class=\"title-label\" and @title=\"Місто\"]"));
    }

    @Override
    public boolean isFilterRegionDisplayed() {
        return isElementDisplayed(By.xpath("//*[@class=\"title-label\" and @title=\"Область\"]"));
    }

    @Override
    public boolean isFilterTypeDisplayed() {
        return isElementDisplayed(By.xpath("//*[@class=\"title-label\" and @title=\"Тип об’єкту\"]"));
    }

    @Override
    public boolean isFilterMainDirectionsDisplayed() {
        return isElementDisplayed(By.cssSelector("div.av-form-select-multiple"));
    }

}


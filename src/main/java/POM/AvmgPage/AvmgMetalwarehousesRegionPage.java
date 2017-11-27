package POM.AvmgPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public class AvmgMetalwarehousesRegionPage extends AvmgBasePage {

    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]/a")
    private List<WebElement> allRegions;

    public AvmgMetalwarehousesRegionPage(String browser) {
        super(browser);
    }

    public AvmgMetalwarehousesRegionPage(WebDriver driver) {
        super(driver);
    }

    public int countMetalwarehouses() throws InterruptedException {
        boolean flag = false;
        int page = 1;
        int sum;
        if (!(this.isElementDisplayed(By.cssSelector("div.av-bases-list-element")))){
            return 0;
        }
        if (!(this.isElementDisplayed(By.xpath("//a[@class=\"page\"]")))){
            sum =  getDriver().findElements(By.cssSelector("div.av-bases-list-element")).size();
            return sum;
        }
        int lastPage = Integer.parseInt(getDriver().findElements(By.xpath("//a[@class=\"page\"]")).get(getDriver().findElements(By.xpath("//a[@class=\"page\"]")).size() - 1).getText());
        sum = getDriver().findElements(By.cssSelector("div.av-bases-list-element")).size();
        while ((lastPage-1 != page)&&(lastPage !=2)) {
            page++;
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElements(By.xpath("//a[@class=\"page\"]")).get(0));
            actions.perform();
            for (WebElement element :  getDriver().findElements(By.xpath("//a[@class=\"page additional\"]"))){
                if ((Integer.parseInt(element.getText())) == page) {
                    Point elementPoint = element.getLocation();
                    goToPoints(elementPoint.getX(), elementPoint.getY());
                    element.click();
                    flag = true;
                    break;
                }
                if (flag) break;
            }
            sum += getDriver().findElements(By.cssSelector("div.av-bases-list-element")).size();
        }
        Point avPage = getDriver().findElement(By.className("av-pager")).getLocation();
        goToPoints(avPage.getX(),avPage.getY());
        getDriver().findElements(By.xpath("//a[@class=\"page\"]")).get(getDriver().findElements(By.xpath("//a[@class=\"page\"]")).size() - 1).click();
        sum += getDriver().findElements(By.cssSelector("div.av-bases-list-element")).size();
        return sum;
    }

    public AvmgMetalwarehousesRegionPage goToRegion(String region) throws InterruptedException {
        for (WebElement obl : allRegions) {
            if (obl.getAttribute("href").contains(region)) {
                goToUrl(obl.getAttribute("href"));
                break;
            }
        }
        return new AvmgMetalwarehousesRegionPage(getDriver());
    }



}

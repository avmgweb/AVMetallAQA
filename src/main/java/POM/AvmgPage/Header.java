package POM.AvmgPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Дмитрий on 15.06.2017.
 */
public class Header {

    private WebDriver driver;

    @FindBy(xpath = "img[title=\"АВ металл групп\"]")
    private List<WebElement> logo;

    @FindBy(xpath = "//a[@class=\"main-link\" and @href=\"/metallobaza/\"]")
    private WebElement aboutUs;


    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}

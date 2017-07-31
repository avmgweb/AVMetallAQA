package POM.AvmgRu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Дмитрий on 15.06.2017.
 */
public class Header {

    @FindBy(xpath = "img[title=\"АВ металл групп\"]")
    private List<WebElement> logo;

    @FindBy(xpath = "//a[@class=\"main-link\" and @href=\"/metallobaza/\"]")
    private WebElement aboutUs;


}

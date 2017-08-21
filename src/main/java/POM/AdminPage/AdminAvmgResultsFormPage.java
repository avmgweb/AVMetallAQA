package POM.AdminPage;

import POM.AdminBasePage;
import classes.CareerAvmg;
import classes.PartnersAvmg;
import classes.RequestAvmg;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Point;

import java.util.List;
import java.util.Map;

/**
 * Created by Дмитрий on 26.06.2017.
 */
public class AdminAvmgResultsFormPage extends AdminBasePage {
    public AdminAvmgResultsFormPage(String browser) {
        super(browser);
    }

    public AdminAvmgResultsFormPage(WebDriver driver) {
        super(driver);
    }

    public AdminAvmgResultsFormPage sortingDown() {
        if (getDriver().findElement(By.xpath("//tbody//td[contains(@title, \"Сортировка: ID\")]")).getAttribute("class").contains("sort-up"))
            getDriver().findElement(By.xpath("//tbody//td[contains(@title, \"Сортировка: ID\")]")).click();
        return this;
    }

    private void goToRequest(String name){
        Boolean flag = false;
        int i = 0;
        List<WebElement> requests = getDriver().findElements(By.xpath("//tr[@class=\"adm-list-table-row\"]"));
        for (WebElement request : requests) {
            List<WebElement> requestsFields = request.findElements(By.tagName("td"));
            System.out.println(requestsFields.size());
            for (WebElement requestFields : requestsFields) {
                i++;
                if (requestFields.getText().equals(name)) {
                    Actions action = new Actions(getDriver());
                    action.doubleClick(requestFields).build().perform();
                    flag = true;
                    break;
                }
                if (flag) break;
            }
            if (flag) break;
        }
    }


    public RequestAvmg   getRequest(String name, String value, Map<String, By> selectors) throws InterruptedException {
        RequestAvmg requestAvmg = new RequestAvmg();
        goToRequest(name);
        try{
            switch (value) {
                case "common" :
                        requestAvmg.setName(getValueOfElement(selectors.get("name")));
                        requestAvmg.setSurname(getValueOfElement(selectors.get("surname")));
                        requestAvmg.setMail(getValueOfElement(selectors.get("mail")));
                        requestAvmg.setTelephone(getValueOfElement(selectors.get("telephone")).
                                replace(")", "").replace("(", "").
                                replace("-", ""));
                        requestAvmg.setCompany(getValueOfElement(selectors.get("company")));
                        requestAvmg.setTown(getValueOfElement(selectors.get("town")));
                        requestAvmg.setMessage(getValueOfElement(selectors.get("message")));
                        break;
                case "services" :
                        requestAvmg.setName(getValueOfElement(selectors.get("name")));
                        requestAvmg.setSurname(getValueOfElement(selectors.get("surname")));
                        requestAvmg.setMail(getValueOfElement(selectors.get("mail")));
                        requestAvmg.setTelephone(getValueOfElement(selectors.get("telephone")).
                        replace(")", "").replace("(", "").
                        replace("-", ""));
                        requestAvmg.setCompany(getValueOfElement(selectors.get("company")));
                        requestAvmg.setMessage(getValueOfElement(selectors.get("message")));
                        break;
                default:
                        System.out.println("Такого ключа нет");
                        break;
            }
        } catch (Exception e){
            System.out.println("ERROR" + e.getMessage());
        }
        finally {
            type("click", By.cssSelector("input[name=\"cancel\"]"), "");}
        return requestAvmg;
    }

    public boolean deletePrice(String name) throws InterruptedException {
        Boolean flag = false;
        List<WebElement> requests = getDriver().findElements(By.xpath("//tr[@class=\"adm-list-table-row\"]"));
        for (WebElement request : requests) {
            List<WebElement> requestsFields = request.findElements(By.tagName("td"));
            for (WebElement requestFields : requestsFields){
                if (requestFields.getText().equals(name)){
                    request.findElement(By.cssSelector("td[class=\"adm-list-table-cell adm-list-table-popup-block\"]")).click();
                    type("click", By.xpath("//*[text()=\"Удалить\"]"), "");
                    try {
                        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
                        wait.until(ExpectedConditions.alertIsPresent());
                        Alert alert = getDriver().switchTo().alert();
                        alert.accept();
                    } catch (Exception e) {
                    }
                    flag = true;
                    break;
                }
                if (flag) break;
            }
            if (flag) break;
        }
        if (isElementDisplayed((By.xpath("//*[contains(@class, \"adm-list-table-empty\")]"))))
            return false;
        flag = false;
        getDriver().navigate().refresh();
        Thread.sleep(3000);
        requests = getDriver().findElements(By.xpath("//tr[@class=\"adm-list-table-row\"]"));
        for (WebElement request : requests) {
            List<WebElement> requestsFields = request.findElements(By.tagName("td"));
            for (WebElement requestFields : requestsFields){
                if (requestFields.getText().equals(name)){
                    flag = true;
                    break;
                }
                if (flag) break;
            }
            if (flag) break;
        }
        return flag;
    }

    public PartnersAvmg getRequestPartners(String companyName, Map<String, By> selector) {
        PartnersAvmg partnersAvmg = new PartnersAvmg();
        goToRequest(companyName);
        try{
            partnersAvmg.setCompanyName(getValueOfElement(selector.get("companyName")));
            partnersAvmg.setLegalAdress(getValueOfElement(selector.get("legalAdress")));
            partnersAvmg.setTown(getValueOfElement(selector.get("town")));
            partnersAvmg.setPostalIndex(getValueOfElement(selector.get("postalIndex")));
            partnersAvmg.setAddressForDeliveryOfDocuments(getValueOfElement(selector.get("addressForDeliveryOfDocuments")));
            partnersAvmg.setPlaceOfdelivery(getValueOfElement(selector.get("placeOfdelivery")));
            partnersAvmg.setPostalCodeOfDelivery(getValueOfElement(selector.get("postalCodeOfDelivery")));
            partnersAvmg.setSurname(getValueOfElement(selector.get("surname")));
            partnersAvmg.setName(getValueOfElement(selector.get("name")));
            partnersAvmg.setPosition(getValueOfElement(selector.get("position")));
            partnersAvmg.setMail(getValueOfElement(selector.get("mail")));
            partnersAvmg.setTelephone(getValueOfElement(selector.get("telephone")).
                replace(")", "").replace("(", "").
                replace("-", ""));
            partnersAvmg.setAdditionalTelephone(getValueOfElement(selector.get("additionalTelephone")).
                replace(")", "").replace("(", "").
                replace("-", ""));
            partnersAvmg.setMessage(getValueOfElement(selector.get("message")));
        } catch (Exception e){
            System.out.println("ERROR" + e.getMessage());
        }
        finally {
        type("click", By.cssSelector("input[name=\"cancel\"]"), "");}
        return partnersAvmg;
    }

    public CareerAvmg getRequestCareer(String mail, Map<String, By> selector) {
        CareerAvmg careerAvmg = new CareerAvmg();
        goToRequest(mail);
        try{
            careerAvmg.setMail(getValueOfElement(selector.get("mail")));
            careerAvmg.setMessage(getValueOfElement(selector.get("message")));
            careerAvmg.setLink(getValueOfElement(selector.get("link")));
            careerAvmg.setFileName(getTextOfElement(selector.get("fileName")));
            WebElement link = getDriver().findElement(By.cssSelector("a[href *=\"/bitrix/tools/form_show_file.php?\"]"));
            Point point = link.getLocation();
            goToPoints(point.getX(), point.getY());
            link.click();

        } catch (Exception e){
            System.out.println("ERROR" + e.getMessage());
        }
        finally {
            type("click", By.cssSelector("input[name=\"cancel\"]"), ""); }
        return careerAvmg;
    }
}

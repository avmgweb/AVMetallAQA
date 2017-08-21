package POM.AdminPage;

import POM.AdminBasePage;
import classes.UserAvmg;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Дмитрий on 22.06.2017.
 */
public class UsersListPage  extends AdminBasePage{
    public UsersListPage(String browser) {
        super(browser);
    }

    public UsersListPage(WebDriver driver) {
        super(driver);
    }

    public UsersListPage callFilterByMail() throws InterruptedException {
        type("click", By.className("adm-filter-add-button"),"");
        WebElement email = getDriver().findElements(By.xpath("//*[text()=\"E-Mail\"]")).get(0);
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(email));
        email.click();
        return this;
    }

    public UsersListPage findByMail(String mail) throws InterruptedException {
        type("write", By.cssSelector("input[name=\"find_email\"]"), mail);
        type("click", By.cssSelector("input[name=\"set_filter\"]"), "");
        Thread.sleep(3000);
        return this;
    }

    public boolean enableUser (String mail) throws InterruptedException {
        boolean enableUser = true;
        type("write", By.cssSelector("input[name=\"find_email\"]"), mail);
        type("click", By.cssSelector("input[name=\"set_filter\"]"), "");

        return isElementDisplayed(By.cssSelector("td[class=\"adm-list-table-cell adm-list-table-empty\"]"));
    }

    public UserAvmg getUserAvmgAdmin(String mail) throws InterruptedException {
        UserAvmg userAvmg = new UserAvmg();
        findByMail(mail);
        type("click", By.xpath("//*[@title=\"Действия\"]"), "");
        type("click", By.xpath("//*[text()=\"Изменить\"]"), "");
        type("wait", By.cssSelector("input[name=\"NAME\"]"),"");
        userAvmg.setName(getDriver().findElement(By.cssSelector("input[name=\"NAME\"]")).getAttribute("value"));
        System.out.println(getDriver().findElement(By.cssSelector("input[name=\"NAME\"]")).getAttribute("value"));
        type("wait", By.cssSelector("input[name=\"LAST_NAME\"]"),"");
        userAvmg.setSurname(getDriver().findElement(By.cssSelector("input[name=\"LAST_NAME\"]")).getAttribute("value"));
        type("wait", By.cssSelector("input[name=\"EMAIL\"]"),"");
        userAvmg.setMail(getDriver().findElement(By.cssSelector("input[name=\"EMAIL\"]")).getAttribute("value"));
        type("wait", By.cssSelector("input[name=\"LOGIN\"]"),"");
        userAvmg.setLoginAvmg(getDriver().findElement(By.cssSelector("input[name=\"LOGIN\"]")).getAttribute("value"));
        type("click", By.xpath("//*[@title=\"Личные данные\"]"),"");
        type("wait", By.cssSelector("input[name=\"PERSONAL_MOBILE\"]"),"");
        String mobile = getDriver().findElement(By.cssSelector("input[name=\"PERSONAL_MOBILE\"]")).getAttribute("value");
        mobile = mobile.replace(")","").replace("(","").replace("-","");
        userAvmg.setMobile(mobile);
        type("click", By.cssSelector("input[name=\"cancel\"]"),"");
        return userAvmg;
    }

    public void deleteUserByEmail(String mail) throws InterruptedException {
        findByMail(mail);
        type("click", By.xpath("//*[@title=\"Действия\"]"), "");
        type("click", By.xpath("//*[text()=\"Удалить\"]"), "");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }
    }
}

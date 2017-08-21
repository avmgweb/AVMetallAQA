package POM;

import POM.AdminPage.UsersListPage;
import POM.AvmgRu.AvmgSearchPage;
import POM.AdminPage.AdminAvmgMainPage;
import POM.AvmgRu.Header;
import classes.CareerAvmg;
import classes.PartnersAvmg;
import classes.RequestAvmg;
import classes.UserAvmg;
import files.FileAV;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.*;

/**
 * Created by Дмитрий on 12.05.2017.
 */
public class AvmgBasePage extends BasePage{
    @FindBy(id = "av-auth-guest-bar")
    private WebElement entertButton;


    @FindBy (id = "title-search")
    private WebElement search;

    private boolean flag;


    public AvmgBasePage(String browser) {
        super(browser);
    }

    public AvmgBasePage(WebDriver driver) {
        super(driver);
    }

    public String checkFormMenu() {
        return entertButton.getAttribute("class");
    }

    public AvmgBasePage callFormMenu(){
        System.out.println(checkFormMenu());
        if (checkFormMenu().equals("av-auth-form-call-button"))
            type("click",By.id("av-auth-guest-bar"),"");
        return this;
    }

    public AvmgBasePage closeFormMenu(){

        if (checkFormMenu().equals("av-auth-form-call-button active"))
            type("click",By.className("close-form-button"),"");
        return this;
    }

    public AvmgBasePage logInWithPassword(String login, String password) throws InterruptedException {
        WebElement userLoginField = getDriver().findElement(By.cssSelector("input[name=\"USER_LOGIN\"]"));
        WebElement userPasswordField = getDriver().findElement(By.cssSelector("input[name=\"USER_PASSWORD\"]"));
        userLoginField.clear();
        userLoginField.sendKeys(login);
        userPasswordField.clear();
        userPasswordField.sendKeys(password);
        getDriver().findElement(By.cssSelector("button[name=\"LoginR0QuFZ\"]")).click();
        if (isElementDisplayed(By.xpath(".//*[@id='av-auth-guest-form']/form[1]/div[1]")))
            return null;
        else (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.id("bx-panel-menu-text"))));

        return this;
    }



    public boolean isAdminPage(){

        return isElementDisplayed(By.id("bx-panel-top"));
    }

    public AvmgBasePage loginFacebook(String loginFb, String passwordFB) throws InterruptedException {
        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        String urlNewWindow = "";
        String parentWindow = getDriver().getWindowHandle();
        Set<String> handles =  getDriver().getWindowHandles();
        for(String windowHandle  : handles) {
            if(!windowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(windowHandle);
                getDriver().navigate().to("https://www.facebook.com/");
                getDriver().findElement(By.id("email")).clear();
                getDriver().findElement(By.id("email")).sendKeys(loginFb);
                getDriver().findElement(By.id("pass")).clear();
                getDriver().findElement(By.id("pass")).sendKeys(passwordFB);
                getDriver().findElement(By.cssSelector("input[type=\"submit\"]")).click();
                (new WebDriverWait(getDriver(), 10))
                        .until(ExpectedConditions.elementToBeClickable(By.id("u_0_5")));
                getDriver().close();
                getDriver().switchTo().window(parentWindow); //cntrl to parent window
            }
        }
        callFormMenu();
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"call-button facebook\"]")));
        getDriver().findElement(By.xpath("//*[@class=\"call-button facebook\"]")).click();
        urlNewWindow = "";
        parentWindow = getDriver().getWindowHandle();
        handles =  getDriver().getWindowHandles();
        for(String windowHandle  : handles) {
            if(!windowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(windowHandle);
                System.out.println(getDriver().getCurrentUrl());
                getDriver().findElement(By.cssSelector("button[name=\"__CONFIRM__\"]")).click();
                getDriver().close();
                getDriver().switchTo().window(parentWindow);
            }
        }
        return new AvmgBasePage(getDriver());
    }

    public AvmgBasePage loginGmail(String loginGm, String passwordGm) throws InterruptedException {
        callFormMenu();
        type("click", By.xpath("//*[@class=\"call-button google-plus\"]"),"");
        String urlNewWindow = "";
        String parentWindow = getDriver().getWindowHandle();
        Set<String> handles =  getDriver().getWindowHandles();
        for(String windowHandle  : handles) {
            if(!windowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(windowHandle);
                type("write", By.cssSelector("input[type=\"email\"]"), loginGm);
                type("click", By.xpath("//*[text()=\"Далее\"]"), "");
                Thread.sleep(1000);
                type("write", By.cssSelector("input[type=\"password\"]"), passwordGm);
                type("click", By.xpath("//*[text()=\"Далее\"]"), "");
                type("click", By.xpath("//*[text()=\"РАЗРЕШИТЬ\"]"), "");
                getDriver().close();
                getDriver().switchTo().window(parentWindow); //cntrl to parent window
            }
        }


        getDriver().findElement(By.xpath("//*[@class=\"call-button google-plus\"]")).click();
        urlNewWindow = "";
        parentWindow = getDriver().getWindowHandle();
        handles =  getDriver().getWindowHandles();
        for(String windowHandle  : handles) {
            if(!windowHandle.equals(parentWindow)) {
                getDriver().switchTo().window(windowHandle);
                System.out.println(getDriver().getCurrentUrl());
                type("click", By.cssSelector("p[role=\"presentation\"]"), "");
                type("click", By.xpath("//*[text()=\"РАЗРЕШИТЬ\"]"), "");
                getDriver().switchTo().window(parentWindow);
            }
        }

        return new AvmgBasePage(getDriver());
    }

    public boolean checkLogin() {
        return isElementDisplayed(By.id("av-auth-user-panel"));
    }

    public AvmgBasePage logOut() throws InterruptedException {
        type("click", By.cssSelector("[id=\"av-auth-user-panel\"]"),"");
        type("wait", By.cssSelector("button[name=\"logout_butt\"]"), "");
        getDriver().findElements(By.cssSelector("button[name=\"logout_butt\"]")).get(0).click();
        return this;
    }

    public AvmgBasePage goToRegistrationTab() {
        type("click", By.xpath("//*/li[@class=\"register\"]"), "");
        return this;
    }

    public void fillRegistrationForm(UserAvmg userAvmg) {
        type("write", By.cssSelector("input[name=\"REGISTER[LOGIN]\"]"), userAvmg.getLoginAvmg());
        type("write", By.cssSelector("input[name=\"REGISTER[PASSWORD]\"]"), userAvmg.getPasswordAvmg());
        type("write", By.cssSelector("input[name=\"REGISTER[CONFIRM_PASSWORD]\"]"), userAvmg.getPasswordConfirmation());
        type("write", By.cssSelector("input[name=\"REGISTER[EMAIL]"), userAvmg.getMail());
        type("write", By.cssSelector("input[name=\"REGISTER[NAME]"), userAvmg.getName());
        type("write", By.cssSelector("input[name=\"REGISTER[LAST_NAME]"), userAvmg.getSurname());
        type("write", By.cssSelector("input[name=\"REGISTER[PERSONAL_MOBILE]"), userAvmg.getMobile());
        type("click", By.cssSelector("button[name=\"register_submit_buttoneKR8mc\"]"), "");
    }

    public UsersListPage goToUserListPage() throws InterruptedException {
        if (isElementDisplayed(By.cssSelector("input[name=\"close\"]")))
            type("click", By.cssSelector("input[name=\"close\"]"), "");
        type("click", By.id("global_menu_settings"), "");
        type("click", By.xpath("//*[text()=\"Список пользователей\"]"), "");
        return new UsersListPage(getDriver());
    }

    public AdminAvmgMainPage goToAdminPanel(){
        type("click", By.id("bx-panel-admin-tab"), "");
        return new AdminAvmgMainPage(getDriver());
    }


    public AvmgBasePage sendMessageForgetPassword(String mail) {
        type("click", By.xpath("//a[contains(@href,\"forgot_password\")]"), "");
        type("write", By.cssSelector("input[title=\"Логин или E-mail\"]"), mail);
        type("click", By.cssSelector("input[name=\"send_account_info\"]"), "");
        return this;
    }

    public boolean checkForgetPasswordPage() {
        return isElementDisplayed(By.xpath("//*[h3=\"Смена пароля\"]"));
    }

    public void changePassword(String newPasswordAvmg, String newPasswordAvmgCongirmation) {
        type("write", By.cssSelector("input[title=\"Новый пароль\"]"), newPasswordAvmg);
        type("write", By.cssSelector("input[name=\"USER_CONFIRM_PASSWORD\"]"), newPasswordAvmgCongirmation);
        type("click", By.cssSelector("input[name=\"change_pwd\"]"),"");
    }



    public String getIdFormOrderPrice() {
        return getDriver().findElement(By.className("av-form-index")).getAttribute("data-avat-form-id");
    }


    public Set<String> getAllLinks(String language) {
        Set<String> hrefs = null;
        switch (language){
            case ("ru") :
                hrefs = FileAV.readLinksFile("C:\\Users\\Дмитрий\\Documents\\AQA\\AVMetallAQA\\src\\main\\links\\LinksRu.txt");
                break;
            case ("ua") :
                hrefs = FileAV.readLinksFile("C:\\Users\\Дмитрий\\Documents\\AQA\\AVMetallAQA\\src\\main\\links\\LinksUa.txt");
                break;
            default :
                System.out.println("Error");
                break;
        }
        return hrefs;
    }

    public AvmgBasePage sendOrderPriceServicies(RequestAvmg requestAvmg, String value , Map<String, By> selectors) {
        switch (value) {
            case "common" :     type("write", selectors.get("name"), requestAvmg.getName());
                                type("write", selectors.get("surname"), requestAvmg.getSurname());
                                type("write", selectors.get("mail"), requestAvmg.getMail());
                                type("write", selectors.get("telephone"), requestAvmg.getTelephone());
                                type("write", selectors.get("company"), requestAvmg.getCompany());
                                type("write", selectors.get("town"), requestAvmg.getTown());
                                WebElement textArea = getDriver().findElement(selectors.get("message"));
                                textArea.sendKeys(Keys.TAB);
                                textArea.clear();
                                textArea.sendKeys(requestAvmg.getMessage());
                                type("click", By.cssSelector("input[name=\"web_form_submit\"]"), "");
                                break;
            case "services" :   type("write", selectors.get("name"), requestAvmg.getName());
                                type("write", selectors.get("surname"), requestAvmg.getSurname());
                                type("write", selectors.get("mail"), requestAvmg.getMail());
                                type("write", selectors.get("telephone"), requestAvmg.getTelephone());
                                type("write", selectors.get("company"), requestAvmg.getCompany());
                                WebElement textArea1 = getDriver().findElement(selectors.get("message"));
                                textArea1.sendKeys(Keys.TAB);
                                textArea1.clear();
                                textArea1.sendKeys(requestAvmg.getMessage());
                                type("click", By.cssSelector("input[name=\"web_form_submit\"]"), "");
                                break;
            default:            System.out.println("Такого ключа нет");
                                break;
        }
        return this;
    }

    public AvmgBasePage goToUrlFormBasePage(String url) {
        goToUrl(url);
        return new AvmgBasePage(getDriver());
    }


    public String getIdForm(By sel) {
        return getDriver().findElement(sel).getAttribute("data-avat-form-id");
    }

    public BasePage sendFormPartners(PartnersAvmg partnersAvmg, Map<String, By> selectors) {
        type("write", selectors.get("companyName"), partnersAvmg.getCompanyName());
        type("write", selectors.get("legalAdress"), partnersAvmg.getLegalAdress());
        type("write", selectors.get("town"), partnersAvmg.getTown());
        type("write", selectors.get("postalIndex"), partnersAvmg.getPostalIndex());
        getDriver().findElements(By.cssSelector("label[title=\"СПД (ФЛП)\"]")).get(0).click();
        type("write", selectors.get("addressForDeliveryOfDocuments"), partnersAvmg.getAddressForDeliveryOfDocuments());
        type("write", selectors.get("placeOfdelivery"), partnersAvmg.getPlaceOfdelivery());
        type("write", selectors.get("postalCodeOfDelivery"), partnersAvmg.getPostalCodeOfDelivery());
        type("write", selectors.get("surname"), partnersAvmg.getSurname());
        type("write", selectors.get("name"), partnersAvmg.getName());
        type("write", selectors.get("position"), partnersAvmg.getPosition());
        type("write", selectors.get("mail"), partnersAvmg.getMail());
        type("write", selectors.get("telephone"), partnersAvmg.getTelephone());
        type("write", selectors.get("additionalTelephone"), partnersAvmg.getAdditionalTelephone());
        WebElement textArea = getDriver().findElement(selectors.get("message"));
        textArea.sendKeys(Keys.TAB);
        textArea.clear();
        textArea.sendKeys(partnersAvmg.getMessage());
        type("click", By.cssSelector("input[name=\"web_form_submit\"]"), "");
        return this;
    }

    public boolean enableSuccessfulSending(){
        return isElementDisplayed(By.xpath("//*[@class=\"av-alert-popup\"]"));
    }

    public void closeSuccessfulSending(){
        getDriver().findElements(By.xpath("//*[@class=\"close-form-button\"]")).get(1).click();
    }

    public void closeSuccessfulSendingPartners(){
        getDriver().findElement(By.xpath("//*[@class=\"close-form-button\"]")).click();
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }

    public BasePage sendFormCareer(CareerAvmg careerAvmg, Map<String, By> selectors) throws InterruptedException {
        type("write", selectors.get("mail"), careerAvmg.getMail());
        setAttribute(getDriver(), getDriver().findElement(By.cssSelector("input[type=\"checkbox\"]")), "checked", "checked");
        setAttribute(getDriver(), getDriver().findElement(By.xpath("//*[@class=\"comments-field hidden-field\"]")), "style", "display:block");
        File file = new File(careerAvmg.getFile());
        getDriver().findElement(selectors.get("file")).sendKeys(file.getAbsolutePath());
        WebElement textArea = getDriver().findElement(selectors.get("message"));
        textArea.sendKeys(Keys.TAB);
        textArea.clear();
        textArea.sendKeys(careerAvmg.getMessage());
        type("click", By.cssSelector("input[name=\"web_form_submit\"]"), "");
        return this;
    }


    public AvmgBasePage search (String key, boolean enter){
        search.click();
        type("wait", By.id("title-search-input"), "");
        type("write", By.id("title-search-input"), key);
        if (enter) {
            getDriver().findElement(By.id("title-search-input")).sendKeys(Keys.ENTER);
            return new AvmgSearchPage(getDriver());
        }
        else if (isSearchResultListDisplayed()){
            type("wait", By.className("av-search-title-result-list"), "");
            this.setAttribute(getDriver(),getDriver().findElement(By.className("av-search-title-result-list")),
                    "style", "display: block !important");
            System.out.println(getDriver().findElement(By.className("av-search-title-result-list")).getText());
        }
            return this;
    }

    public boolean isSearchResultListDisplayed(){
        return isElementDisplayed(By.className("av-search-title-result-list"));
    }

    public String returnTextFormSearchTitlrResultList(){
        return getDriver().findElement(By.className("av-search-title-result-list")).getText();
    }

    public String getH1() {
        return getDriver().findElement(By.tagName("h1")).getText();
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public Header navigationHeader(){
        return new Header(getDriver());
    }

    public String get404Page(String lang) {
        switch (lang){
            case "ua" : return "https://avmg.com.ua/404";
            case "ru" : return "https://ru.avmg.com.ua/404";
        }
        return "Error";
    }
}

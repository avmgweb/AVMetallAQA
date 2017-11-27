package checkForm;

import BaseTest.BaseTest;
import POM.AdminPage.AdminAvmgResultsFormPage;
import POM.AdminPage.AdminAvmgSettingsFormPage;
import selector.selectors;
import POM.AvmgPage.AvmgBasePage;
import models.RequestAvmg;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by Дмитрий on 17.07.2017.
 */
public class checkFormBase extends BaseTest {

    String login = "d.prikhodko";
    String password = "mc7nqrsH";
    RequestAvmg requestAvmg;
    RequestAvmg requestAvmgAdmin;
    String idForm;
    AdminAvmgSettingsFormPage adminAvmgSettingsFormPage;
    AdminAvmgResultsFormPage adminAvmgResultsFormPage;
    AvmgBasePage avmgBasePage;
    Map<String, By> selector;

    @Parameters({"type", "url"})
    @Test
    public void  checkOrderPriceListForm(String type, String url) throws InterruptedException {
        requestAvmg = RequestAvmg.generate();
        avmgBasePage = avmgMainPage.goToUrlFormBasePage(url);
        selector =  selectors.getSelectors(url);
        idForm = avmgBasePage.getIdForm(selector.get("idform"));
        avmgBasePage.sendOrderPriceServicies(requestAvmg, type, selector);
        System.out.println(requestAvmg + idForm);
        Assert.assertTrue(avmgBasePage.enableSuccessfulSending());
        avmgBasePage.closeSuccessfulSending();
        avmgMainPage.refresh();
    }


    @Parameters({"type"})
    @Test(dependsOnMethods = {"checkOrderPriceListForm"})
    public void checkOrderPriceListFormAdmin(String type) throws InterruptedException {
        avmgBasePage.callFormMenu().logInWithPassword(login, password);
        adminAvmgMainPage = avmgBasePage.goToAdminPanel();
        adminAvmgSettingsFormPage = adminAvmgMainPage.goToSettingsFormPage();
        adminAvmgSettingsFormPage.setFilterById(idForm);
        adminAvmgResultsFormPage = adminAvmgSettingsFormPage.goToResultsFormPage(idForm);
        adminAvmgResultsFormPage.sortingDown();
        requestAvmgAdmin = adminAvmgResultsFormPage.getRequest(requestAvmg.getName(), type, selector );
        Assert.assertEquals(requestAvmg.getName(), requestAvmgAdmin.getName());
        Assert.assertEquals(requestAvmg.getSurname(), requestAvmgAdmin.getSurname());
        Assert.assertEquals(requestAvmg.getMail(), requestAvmgAdmin.getMail());
        Assert.assertTrue(requestAvmgAdmin.getTelephone().contains(requestAvmg.getTelephone()));
        Assert.assertEquals(requestAvmg.getCompany(), requestAvmgAdmin.getCompany());
        Assert.assertEquals(requestAvmg.getMessage(), requestAvmgAdmin.getMessage());
        System.out.println(requestAvmg.getTown());
        System.out.println(requestAvmgAdmin.getTown());
        if (type.equals("common"))
            Assert.assertEquals(requestAvmg.getTown(), requestAvmgAdmin.getTown());
    }

    @Test(dependsOnMethods = {"checkOrderPriceListFormAdmin"})
    public void checkDeletePriceListFormAdmin() throws InterruptedException {
        Assert.assertFalse(adminAvmgResultsFormPage.deletePrice(requestAvmg.getName()));
    }

}

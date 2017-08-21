package checkForm;

import BaseTest.BaseTest;
import POM.AdminBasePage;
import POM.AdminPage.AdminAvmgResultsFormPage;
import POM.AdminPage.AdminAvmgSettingsFormPage;
import POM.AvmgBasePage;
import classes.PartnersAvmg;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selector.selectors;

import java.util.Map;

/**
 * Created by Дмитрий on 18.07.2017.
 */
public class checkFormPartners extends BaseTest {
    String login = "awe5040";
    String password = "Qwerty5040+";
    String idForm;
    AdminAvmgSettingsFormPage adminAvmgSettingsFormPage;
    AdminAvmgResultsFormPage adminAvmgResultsFormPage;
    AvmgBasePage avmgBasePage;
    AdminBasePage adminBasePage;
    Map<String, By> selector;
    PartnersAvmg partnersAvmg;
    PartnersAvmg partnersAvmgAdmin;

    @Parameters({"url"})
    @Test (priority = 1)
    public void  checkOrderPriceListForm(String url) throws InterruptedException {
        partnersAvmg = PartnersAvmg.generate();
        avmgBasePage = avmgMainPage.goToUrlFormBasePage(url);
        avmgBasePage.callFormMenu().logInWithPassword(login, password);
        selector =  selectors.getSelectors(url);
        idForm = avmgBasePage.getIdForm(selector.get("idform"));
        avmgBasePage.sendFormPartners(partnersAvmg,  selector);
        System.out.println(partnersAvmg + idForm);
        Assert.assertTrue(avmgBasePage.enableSuccessfulSending());
        avmgBasePage.closeSuccessfulSendingPartners();
        avmgBasePage.refresh();
    }


    @Test (priority = 2)
    public void checkOrderPriceListFormAdmin() throws InterruptedException {
        adminAvmgMainPage = avmgBasePage.goToAdminPanel();
        adminAvmgSettingsFormPage = adminAvmgMainPage.goToSettingsFormPage();
        adminAvmgSettingsFormPage.setFilterById(idForm);
        adminAvmgResultsFormPage = adminAvmgSettingsFormPage.goToResultsFormPage(idForm);
        adminAvmgResultsFormPage.sortingDown();
        partnersAvmgAdmin = adminAvmgResultsFormPage.getRequestPartners(partnersAvmg.getCompanyName(),  selector );
        Assert.assertTrue(partnersAvmg.getCompanyName().equals(partnersAvmgAdmin.getCompanyName()));
        Assert.assertTrue(partnersAvmg.getLegalAdress().equals(partnersAvmgAdmin.getLegalAdress()));
        Assert.assertTrue(partnersAvmg.getTown().equals(partnersAvmgAdmin.getTown()));
        Assert.assertTrue(partnersAvmg.getPostalIndex().contains(partnersAvmgAdmin.getPostalIndex()));
        Assert.assertTrue(partnersAvmg.getLegalAdress().equals(partnersAvmgAdmin.getLegalAdress()));
        Assert.assertTrue(partnersAvmg.getAddressForDeliveryOfDocuments().equals(partnersAvmgAdmin.getAddressForDeliveryOfDocuments()));
        Assert.assertTrue(partnersAvmg.getPlaceOfdelivery().equals(partnersAvmgAdmin.getPlaceOfdelivery()));
        Assert.assertTrue(partnersAvmg.getPostalCodeOfDelivery().equals(partnersAvmgAdmin.getPostalCodeOfDelivery()));
        Assert.assertTrue(partnersAvmg.getSurname().equals(partnersAvmgAdmin.getSurname()));
        Assert.assertTrue(partnersAvmg.getName().contains(partnersAvmgAdmin.getName()));
        Assert.assertTrue(partnersAvmg.getPosition().equals(partnersAvmgAdmin.getPosition()));
        Assert.assertTrue(partnersAvmg.getMail().equals(partnersAvmgAdmin.getMail()));
        Assert.assertTrue(partnersAvmgAdmin.getTelephone().contains(partnersAvmg.getTelephone()));
        Assert.assertTrue(partnersAvmgAdmin.getAdditionalTelephone().contains(partnersAvmg.getAdditionalTelephone()));
        Assert.assertTrue(partnersAvmg.getMessage().equals(partnersAvmgAdmin.getMessage()));
    }

    @Test (priority = 3)
    public void checkDeletePriceListFormAdmin() throws InterruptedException {
        Assert.assertFalse(adminAvmgResultsFormPage.deletePrice(partnersAvmg.getCompanyName()));
    }
}












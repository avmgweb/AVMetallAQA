package checkForm;

import BaseTest.BaseTest;
import POM.AdminPage.AdminAvmgResultsFormPage;
import POM.AdminPage.AdminAvmgSettingsFormPage;
import POM.AvmgBasePage;
import POM.classes.CareerAvmg;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selector.selectors;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static files.FileAV.*;

/**
 * Created by Дмитрий on 24.07.2017.
 */
public class checkFormCareer extends BaseTest {

    String login = "awe5040";
    String password = "qwerty5040";
    CareerAvmg careerAvmg;
    CareerAvmg careerAvmgAdmin;
    String idForm;
    AdminAvmgSettingsFormPage adminAvmgSettingsFormPage;
    AdminAvmgResultsFormPage adminAvmgResultsFormPage;
    AvmgBasePage avmgBasePage;
    Map<String, By> selector;
    File fileCareer;


    @Parameters({"url", "urlMain"})
    @Test(priority = 1)
    public void  checkCareerForm(String url, String urlMain) throws InterruptedException, IOException {
        careerAvmg = CareerAvmg.generate();
        careerAvmg.setLink(url);
        fileCareer = createFile(careerAvmg.getFileName());
        writeToFile(fileCareer, careerAvmg.getResume());
        careerAvmg.setFile(fileCareer.getAbsolutePath());
        avmgBasePage = avmgMainPage.goToUrlFormBasePage(url);
        selector =  selectors.getSelectors(url);
        idForm = avmgBasePage.getIdForm(selector.get("idform"));
        avmgBasePage.sendFormCareer(careerAvmg,  selector);
        System.out.println(careerAvmg + idForm);
        Assert.assertTrue(avmgBasePage.enableSuccessfulSending());
        avmgBasePage.closeSuccessfulSendingPartners();
        deleteFile(fileCareer);
        avmgBasePage.goToUrl(urlMain);
    }

    @Test (priority = 2)
    public void checkCareerFormAdmin() throws InterruptedException {
        avmgBasePage.callFormMenu().logInWithPassword(login, password);
        adminAvmgMainPage = avmgBasePage.goToAdminPanel();
        adminAvmgSettingsFormPage = adminAvmgMainPage.goToSettingsFormPage();
        adminAvmgSettingsFormPage.setFilterById(idForm);
        adminAvmgResultsFormPage = adminAvmgSettingsFormPage.goToResultsFormPage(idForm);
        adminAvmgResultsFormPage.sortingDown();
        careerAvmgAdmin = adminAvmgResultsFormPage.getRequestCareer(careerAvmg.getMail(),  selector );
        Assert.assertTrue(careerAvmgAdmin.getLink().replace(" ","+").equals(careerAvmg.getLink()));
        Assert.assertTrue(careerAvmgAdmin.getMessage().equals(careerAvmg.getMessage()));
        Assert.assertTrue(careerAvmgAdmin.getMail().equals(careerAvmg.getMail()));
        Assert.assertTrue(careerAvmgAdmin.getFileName().equals(careerAvmg.getFileName()));
        Assert.assertTrue(readFile(fileCareer).equals(careerAvmg.getResume()));
        deleteFile(fileCareer);
    }

    @Test (priority = 3)
    public void checkDeletePriceListFormAdmin() throws InterruptedException {
        Assert.assertFalse(adminAvmgResultsFormPage.deletePrice(careerAvmg.getMail()));
    }
}

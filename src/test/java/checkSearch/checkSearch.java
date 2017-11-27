package checkSearch;

import POM.AdminPage.AdminAvmgResultsFormPage;
import POM.AdminPage.AdminAvmgSettingsFormPage;
import POM.AvmgPage.AvmgBasePage;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageRu;
import POM.AvmgPage.AvmgSearchPage;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageUa;
import driver.Driver;
import driverSupport.TestReports;
import mail.Mails;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashSet;

import static Screenshot.Screenshot.takeScreenshot;
import static files.FileAV.deleteAllFilesFromFolder;
import static files.FileAV.getAllFilesFromFolder;

/**
 * Created by Дмитрий on 28.07.2017.
 */
@Listeners(TestReports.class)
public class checkSearch{
    String browser;
    AdminAvmgSettingsFormPage adminAvmgSettingsFormPage;
    AdminAvmgResultsFormPage adminAvmgResultsFormPage;
    AvmgBasePage avmgMainPage;
    AvmgSearchPage avmgSearchPage;
    String loginGm = "avmg5040@gmail.com";
    String passwordGm = "Finave5040";
    String recipient = "awesome5040@gmail.com";
    public HashSet<String> screenshotPathes;
    public String folderForScreenshots = "src/main/java/screenshots";
    String testName;


    @BeforeClass
    @Parameters({"browser", "language"})
    public void setUp(@Optional("chrome") String browser, @Optional("ua") String language) throws InterruptedException {
        this.browser = browser;
        switch (language){
            case "ua" :  avmgMainPage = new AvmgMainPageUa(browser);  break;
            case "ru" :  avmgMainPage = new AvmgMainPageRu(browser);    break;
            default   :  break;
        }
        Driver.maximize();
    }

    @Parameters({"correctness", "key1"})
    @Test(priority = 1)
    public void  checkResultList(String correctness, String key) throws InterruptedException {
        boolean flagCor = Boolean.parseBoolean(correctness);
        avmgMainPage.search(key, false);
        if (flagCor) {
            Assert.assertTrue(avmgMainPage.isSearchResultListDisplayed());
            Assert.assertTrue(avmgMainPage.returnTextFormSearchTitlrResultList().contains(key));
        }
        else Assert.assertFalse(avmgMainPage.isSearchResultListDisplayed());
    }

    @Parameters({"correctness", "key1"})
    @Test(priority = 2)
    public void  checkResultPage(String correctness, String key) throws InterruptedException {
        boolean flagCor = Boolean.parseBoolean(correctness);
        avmgSearchPage = (AvmgSearchPage) avmgMainPage.search(key, true);
        if (flagCor) {
            Assert.assertTrue(avmgSearchPage.isSearchListDisplayed());
        }
        else Assert.assertTrue(avmgSearchPage.isListOfProductionButtonDisplayed());
    }

    @Parameters({"language"})
    @Test(priority = 3)
    public void  checkH1AndTitle(String language) throws InterruptedException {
        switch (language){
            case "ua" :  Assert.assertEquals(avmgSearchPage.getH1(),    "Результати пошуку");
                         Assert.assertEquals(avmgSearchPage.getTitle(), "Результати пошуку");
                         break;
            case "ru" :  Assert.assertEquals(avmgSearchPage.getH1(),    "Результаты поиска");
                         Assert.assertEquals(avmgSearchPage.getTitle(), "Результаты поиска");
                         break;
            default   :  break;
        }
    }

    @Parameters({"correctness", "key1", "key2"})
    @Test(priority = 4)
    public void  checkSearchWithTwoKeysInDifferentOrders(String correctness, String key1, String key2) throws InterruptedException {
        boolean flagCor = Boolean.parseBoolean(correctness);
        if (flagCor) {
            avmgSearchPage.searchFromPage(key1+ " " + key2);
            int c = avmgSearchPage.returnNumberOfPages();
            avmgSearchPage.searchFromPage(key2+ " " + key1);
            Assert.assertEquals(c, avmgSearchPage.returnNumberOfPages());
        }
    }

    @AfterClass
    public void tearDown() {
        Driver.tearDown();
        Driver.nullDriver();
        try {
            screenshotPathes = getAllFilesFromFolder(folderForScreenshots);
            if ((!screenshotPathes.isEmpty())){
                Mails.sendScreenshot(loginGm, passwordGm, recipient,screenshotPathes, testName);
                deleteAllFilesFromFolder(folderForScreenshots);
            }
        }
        catch (NullPointerException e){
            System.out.println("Скриншотов не обнаружено");
        }
    }


    @AfterMethod
    public void takeSkreenshots(ITestResult result , ITestContext testContext) throws IOException {
        testName = testContext.getName()  + " " + result.getInstanceName() + " " + browser;
        if (ITestResult.FAILURE == result.getStatus()){
            takeScreenshot(result.getName());
        }
    }
}

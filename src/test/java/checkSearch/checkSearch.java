package checkSearch;

import BaseTest.BaseTest;
import POM.AdminPage.AdminAvmgResultsFormPage;
import POM.AdminPage.AdminAvmgSettingsFormPage;
import POM.AvmgBasePage;
import POM.AvmgRu.AvmgMainPage;
import POM.AvmgRu.AvmgSearchPage;
import POM.AvmgUa.AvmgMainPageUa;
import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Дмитрий on 28.07.2017.
 */
public class checkSearch{
    AdminAvmgSettingsFormPage adminAvmgSettingsFormPage;
    AdminAvmgResultsFormPage adminAvmgResultsFormPage;
    AvmgBasePage avmgMainPage;
    AvmgSearchPage avmgSearchPage;


    @BeforeClass
    @Parameters({"browser", "language"})
    public void setUp(@Optional("chrome") String browser, @Optional("ua") String language) throws InterruptedException {
        switch (language){
            case "ua" :  avmgMainPage = new AvmgMainPageUa(browser);  break;
            case "ru" :  avmgMainPage = new AvmgMainPage(browser);    break;
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
    }
}

import BaseTest.BaseTest;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageAbstract;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageEn;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageRu;
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
 * Created by Дмитрий on 12.05.2017.
 */
public class checkAutentification {
    String browser;
    String login = "awe5040";
    String password = "Qwerty5040+";
    String loginFb = "avmg5040@gmail.com";
    String passwordFB = "Finave5040";
    String loginGm = "avmg5040@gmail.com";
    String passwordGm = "Finave5040";
    String host = "imap.gmail.com";// change accordingly
    String mailStoreType = "pop3";
    public HashSet<String> screenshotPathes;
    public String folderForScreenshots = "src/main/java/screenshots";
    String recipient = "awesome5040@gmail.com";
    String testName;
    AvmgMainPageAbstract avmgMainPage;


    @BeforeClass
    @Parameters({"browser", "language"})
    public void setUp(@Optional("chrome") String browser, @Optional("ua") String language) throws InterruptedException {
        this.browser = browser;
        switch (language){
            case "ua" :  avmgMainPage = new AvmgMainPageUa(browser);  break;
            case "ru" :  avmgMainPage = new AvmgMainPageRu(browser);    break;
            case "en" :  avmgMainPage = new AvmgMainPageEn(browser);    break;
            default   :  break;
        }
        Driver.maximize();
    }

    @Test(priority = 1)
    public void checkAutorization() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword(login, "sw");
        Assert.assertFalse(avmgMainPage.isAdminPage());
        avmgMainPage.logInWithPassword(login, password);
        Assert.assertTrue(avmgMainPage.isAdminPage());
        avmgMainPage.logOut();
    }

    @Test(priority = 2)
    public void checkNegativeAutorizationWithIncorrectPasswordAndLogin() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword(login, "sw");
        Assert.assertFalse(avmgMainPage.checkLogin());
        Assert.assertTrue(avmgMainPage.checkDisplayedErrorWithMessagtAboutIncorrectPasswordOrLogin());
        avmgMainPage.closeFormMenu();
        Thread.sleep(500);
    }

    @Test(priority = 3)
    public void checkNegativeAutorizationWithOnlyPassword() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword("", password);
        Assert.assertFalse(avmgMainPage.checkLogin());
        Assert.assertTrue(avmgMainPage.checkDisplayedAllertWithMessage());
        avmgMainPage.closeAllert().closeFormMenu();
        Thread.sleep(500);
    }

    @Test(priority = 4)
    public void checkNegativeAutorizationWithOnlyLogin() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword(login, "");
        Assert.assertFalse(avmgMainPage.checkLogin());
        Assert.assertTrue(avmgMainPage.checkDisplayedAllertWithMessage());
        avmgMainPage.closeAllert().closeFormMenu();
        Thread.sleep(500);
    }

    @Test(priority = 5)
    public void checkNegativeAutorizationWithoutData() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword("", "");
        Assert.assertFalse(avmgMainPage.checkLogin());
        Assert.assertTrue(avmgMainPage.checkDisplayedAllertWithMessage());
        avmgMainPage.closeAllert().closeFormMenu();
    }

    @Test(enabled = false)
    public void checkAutorizationWithFacebook() throws InterruptedException {
        avmgMainPage.loginFacebook(loginFb, passwordFB);
        Assert.assertTrue(avmgMainPage.checkLogin());
        avmgMainPage.logOut();
        Assert.assertFalse(avmgMainPage.checkLogin());
    }

    @Test(enabled = false)
    public void checkAutorizationWithGmail() throws InterruptedException {
        avmgMainPage.loginGmail(loginGm, passwordGm);
        Assert.assertTrue(avmgMainPage.checkLogin());
        avmgMainPage.logOut();
        Assert.assertFalse(avmgMainPage.checkLogin());
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
    public void takeSkreenshots(ITestResult result, ITestContext testContext) throws IOException {
        testName = testContext.getName()  + " " + result.getInstanceName() + " " + browser;
        if (ITestResult.FAILURE == result.getStatus()){
            takeScreenshot(result.getName());
        }
    }
}

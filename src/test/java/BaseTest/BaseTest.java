package BaseTest;

import POM.AvmgPage.AvmgBasePage;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageAbstract;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageRu;
import POM.AdminPage.AdminAvmgMainPage;
import driver.Driver;
import mail.Mails;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashSet;

import static Screenshot.Screenshot.takeScreenshot;
import static files.FileAV.deleteAllFilesFromFolder;
import static files.FileAV.getAllFilesFromFolder;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public abstract class BaseTest {
    public AvmgMainPageRu avmgMainPage;
    public AdminAvmgMainPage adminAvmgMainPage;
    public String loginGm = "avmg5040@gmail.com";
    public String passwordGm = "Finave5040";
    public String recipient = "awesome5040@gmail.com";
    public HashSet<String> screenshotPathes;
    public String folderForScreenshots = "src/main/java/screenshots";
    String testName;

    private WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser){
        deleteAllFilesFromFolder(folderForScreenshots);
        avmgMainPage = new AvmgMainPageRu(browser);
        Driver.maximize();
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
    public void takeSkreenshots(ITestResult result) throws IOException {
        testName = result.getInstanceName();
        if (ITestResult.FAILURE == result.getStatus()){
            takeScreenshot(result.getName());
        }
    }
}
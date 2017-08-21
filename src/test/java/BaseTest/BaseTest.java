package BaseTest;

import POM.AvmgRu.AvmgMainPage;
import POM.AdminPage.AdminAvmgMainPage;
import driver.Driver;
import mail.Mails;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static files.FileAV.deleteAllFilesFromFolder;
import static files.FileAV.getAllFilesFromFolder;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public abstract class BaseTest {
    public  boolean isMobileTesting;
    public AvmgMainPage avmgMainPage;
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
        avmgMainPage = new AvmgMainPage(browser);
        Driver.maximize();
    }

    @AfterClass
    public void tearDown() {
        Driver.tearDown();
        Driver.nullDriver();
        screenshotPathes = getAllFilesFromFolder(folderForScreenshots);
        if ((!screenshotPathes.isEmpty())){
            Mails.sendScreenshot(loginGm, passwordGm, recipient,screenshotPathes, testName);
            deleteAllFilesFromFolder(folderForScreenshots);
        }
    }

    @AfterMethod
    public void takeSkreenshots(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            avmgMainPage.takeScreenshot(result.getName());
        }
        testName = result.getInstanceName();
    }
}
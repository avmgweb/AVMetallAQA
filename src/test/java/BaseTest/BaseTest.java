package BaseTest;

import POM.AvmgPage.AvmgMainPage.AvmgMainPageRu;
import POM.AdminPage.AdminAvmgMainPage;
import driver.Driver;
import driverSupport.TestReports;
import mail.Mails;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.util.HashSet;
import static files.FileAV.deleteAllFilesFromFolder;
import static files.FileAV.getAllFilesFromFolder;

/**
 * Created by Дмитрий on 03.05.2017.
 */
@Listeners(TestReports.class)
public abstract class BaseTest {

    public String browser;
    public AvmgMainPageRu avmgMainPage;
    public AdminAvmgMainPage adminAvmgMainPage;
    public String loginGm = "avmg5040@gmail.com";
    public String passwordGm = "Finave5040";
    public String recipient = "awesome5040@gmail.com";
    public HashSet<String> screenshotPathes;
    public String folderForScreenshots = "src/main/java/screenshots";
    String testName;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser){
        this.browser = browser;
        deleteAllFilesFromFolder(folderForScreenshots);
        avmgMainPage = new AvmgMainPageRu(browser);
        Driver.maximize();
    }

    @AfterClass
    public void tearDown(ITestContext testContext) {
        testName = testContext.getName() + " " + browser;
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


}
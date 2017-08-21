package BaseTest;

import POM.AvmgRu.AvmgMainPage;
import POM.AdminPage.AdminAvmgMainPage;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by Дмитрий on 03.05.2017.
 */
public abstract class BaseTest {
    public  boolean isMobileTesting;
    public AvmgMainPage avmgMainPage;
    public AdminAvmgMainPage adminAvmgMainPage;
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
    }

    @AfterMethod
    public void takeSkreenshots(ITestResult result){
        System.out.println(result.getStatus());
        System.out.println(result.getName());
    }
}
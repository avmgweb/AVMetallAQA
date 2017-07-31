package BaseTest;

import POM.AvmgRu.AvmgMainPage;
import POM.Login.AdminAvmgMainPage;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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


}
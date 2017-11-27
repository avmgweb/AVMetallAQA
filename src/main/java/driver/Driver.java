package driver;

import logger.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import java.util.Map;
/**
 * Created by Дмитрий on 03.05.2017.
 */
public class Driver {

    private static WebDriver driver;

    public static WebDriver getInstance(String browser) {

        String downloadFilepath = "C:\\Users\\Дмитрий\\Documents\\AQA\\AVMetallAQA\\src\\main\\folderForCareer";
        Map<String, Object> preferences = new Hashtable<String, Object>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.prompt_for_download", "false");
        preferences.put("download.default_directory", downloadFilepath);
        preferences.put("plugins.plugins_disabled", new String[]{
                "Adobe Flash Player", "Chrome PDF Viewer"});
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        if (driver==null)
        {
            switch (browser)
            {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver(capabilities);
                    break;
                case "phantomjs":
                    System.setProperty("phantomjs.binary.path", "src/main/resources/drivers/phantomjs.exe");
                    driver = new PhantomJSDriver();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
                    DesiredCapabilities dc1 = DesiredCapabilities.internetExplorer();
                    dc1.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setAcceptInsecureCerts(true);
                    driver = new InternetExplorerDriver(dc1);
                    break;
                case "opera":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/operadriver.exe");
                    options = new ChromeOptions();
                    options.setBinary("C:\\Program Files\\Opera\\47.0.2631.80\\opera.exe");
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    driver = new ChromeDriver(capabilities);
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default: driver = new ChromeDriver(capabilities);
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(75, TimeUnit.SECONDS);
            return new EventFiringWebDriver(driver).register(new WebEventListener());
        }
        maximize();
        return driver;
    }

    public static void tearDown(){
        driver.quit();
    }

    public static void maximize(){
        driver.manage().window().maximize();
    }

    public static void nullDriver(){
        driver = null;
    }
}
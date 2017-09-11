package Screenshot;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


/**
 * Created by Дмитрий on 22.08.2017.
 */
public class Screenshot {
    public static void takeScreenshot(String name) throws IOException {
        String path = "src/main/java/screenshots/" + name +".jpg";
        File scrFile = ((TakesScreenshot) Driver.getInstance("")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(path));
    }

}

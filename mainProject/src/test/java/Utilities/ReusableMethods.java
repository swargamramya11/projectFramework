package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static Utilities.Props.*;

public class ReusableMethods {

    public static void deleteRequiredFolder(String path) throws IOException {
        String filePath = System.getProperty("user.dir") + path;
        File file = new File(filePath);
        FileUtils.deleteDirectory(file);
        file.delete();
    }

    public static byte[] takesScreenshotAsByte() {
        byte[] screenshot = ((TakesScreenshot) BrowserDriver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static void threadSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {

        }
    }

    public static String getProp(String propertyName) {
        return properties.getProperty(propertyName);
    }


}
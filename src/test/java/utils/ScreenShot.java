package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static com.google.common.io.Files.copy;

public class ScreenShot {

    public static void take(WebDriver webDriver, String file) {
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            copy(screenshot, new File(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

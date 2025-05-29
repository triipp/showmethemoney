package helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;

import smtm.resources.Data;

public class ScreenshotHelper {

    public static String takeScreenshot(WebDriver driver, String name) {
        Data data = JsonHelper.readJson();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String filename = data.getScreenshot() + name + ".png";
        File dest = new File(filename);
        dest.getParentFile().mkdirs();
        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error saving screenshot: " + e.getMessage());
        }
        return dest.getAbsolutePath();
    }
}
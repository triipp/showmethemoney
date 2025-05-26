package smtm.helpers;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Environment", "Staging");
        return extent;
    }

}

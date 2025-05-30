import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helpers.ExtentFactory;
import smtm.pages.MisInversionesPage;

import java.lang.reflect.Method;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import helpers.JsonHelper;
import smtm.resources.Data;

public class BaseTest {
    static Data data = JsonHelper.readJson();
    public WebDriver driver;
    public WebDriverWait wait;
    MisInversionesPage misInversionesPage;
    static ExtentSparkReporter info = new ExtentSparkReporter(data.getReports());
    static ExtentReports extent = ExtentFactory.getInstance();
    static ExtentTest test;

    @BeforeAll
    public static void createReport() {
        extent.attachReporter(info);
    }

    @BeforeEach
    public void preconditions(TestInfo testInfo) throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        misInversionesPage = new MisInversionesPage(driver, wait);
        misInversionesPage.setup();
        misInversionesPage.url(data.getUrl());

        String className = this.getClass().getSimpleName();
        String methodName = testInfo.getTestMethod().map(Method::getName).orElse("UnknownMethod");
        test = extent.createTest(className + " - " + methodName);
    }

    @AfterEach
    public void postconditions() {
        misInversionesPage.close();
    }

    @AfterAll
    public static void closeReport() {
        extent.flush();
    }
}
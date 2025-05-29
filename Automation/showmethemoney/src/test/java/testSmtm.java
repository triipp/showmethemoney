import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helpers.ExtentFactory;
import helpers.ScreenshotHelper;
import smtm.pages.MisInversionesPage;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import helpers.JsonHelper;
import smtm.resources.Data;

/* Adding a demo test to validate if the POM is working*/

public class testSmtm {
    static Data data = JsonHelper.readJson();
    public WebDriver driver;
    public WebDriverWait wait;
    MisInversionesPage misInversionesPage;
    static ExtentSparkReporter info = new ExtentSparkReporter(data.getReports());
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeAll
    public static void createReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);

    }

    @BeforeEach
    public void preconditions() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        misInversionesPage = new MisInversionesPage(driver, wait);
        misInversionesPage.setup();
        misInversionesPage.url(data.getUrl());
    }

    @Test
    public void testBuyFromMyInvestments() {
        try {
            // TEST 1: Buy from my investment section - TEST STEPS
            test = extent.createTest("First test - Buy from my investment section");
            test.log(Status.INFO, "Starting test case: First test - Buy from my investment section");
            misInversionesPage.clickMyInvestmentItem(data.getTest1data().getAsset());
            test.log(Status.INFO, "Clicked on " + data.getTest1data().getAsset() + " investment item");
            misInversionesPage.enterComprar(data.getTest1data().getQuantity());
            test.log(Status.INFO, "Entered quantity to buy: " + data.getTest1data().getQuantity());
            misInversionesPage.clickComprarButton();
            test.log(Status.INFO, "Clicked on Comprar button");
            misInversionesPage.getDetailNotification("Operación realizada.");
            test.log(Status.INFO, "Verified operation notification: Operación realizada.");
            Assertions.assertEquals(data.getTest1data().getBalance(), misInversionesPage.getBalanceValue());
            test.log(Status.INFO, "Verified balance value: " + data.getTest1data().getBalance());
            Assertions.assertEquals("(11 unidades)",
                    misInversionesPage.getMyInvestmentItemUnits(data.getTest1data().getAsset()));
            test.log(Status.INFO, "Verified " + data.getTest1data().getAsset() + " investment units: (11 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals(data.getTest2data().getAsset(),
                    misInversionesPage.getPieChartItemText(data.getTest1data().getAsset()));
            test.log(Status.INFO, "Verified pie chart contains item text: " + data.getTest1data().getAsset());
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 1

        } catch (AssertionError assertionError) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail(assertionError, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception error) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail(error, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @Test
    public void testSellFromMyInvestments() {
        try {
            // TEST 2: Sell from my investment section - TEST STEPS
            test = extent.createTest("Second test - Sell from my investment section");
            test.log(Status.INFO, "Starting test case: Second test - Sell from my investment section");
            misInversionesPage.clickMyInvestmentItem(data.getTest2data().getAsset());
            test.log(Status.INFO, "Clicked on " + data.getTest2data().getAsset() + " investment item");
            misInversionesPage.enterVender(data.getTest2data().getQuantity());
            test.log(Status.INFO, "Entered quantity to sell: " + data.getTest2data().getQuantity());
            misInversionesPage.clickVenderButton();
            test.log(Status.INFO, "Clicked on Vender button");
            misInversionesPage.getDetailNotification("Operación realizada.");
            test.log(Status.INFO, "Verified operation notification: Operación realizada.");
            Assertions.assertEquals(data.getTest2data().getBalance(), misInversionesPage.getBalanceValue());
            test.log(Status.INFO, "Verified balance value: " + data.getTest2data().getBalance());
            Assertions.assertEquals("(9 unidades)",
                    misInversionesPage.getMyInvestmentItemUnits(data.getTest2data().getAsset()));
            test.log(Status.INFO, "Verified " + data.getTest2data().getAsset() + " investment units: (9 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals(data.getTest2data().getAsset(),
                    misInversionesPage.getPieChartItemText(data.getTest2data().getAsset()));
            test.log(Status.INFO, "Verified pie chart contains item text: " + data.getTest2data().getAsset());
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 2

        } catch (AssertionError assertionError) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail(assertionError, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception error) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail(error, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @Test
    public void testBuyFromOtherInvestments() {
        try {
            // TEST 3: Buy from other investments section - Without holdings - TEST STEPS
            test = extent.createTest("Second test - Sell from other investments section - User without holdings");
            test.log(Status.INFO,
                    "Starting test case: Second test - Sell from my investment section - User without holdings");
            misInversionesPage.clickOtherInvestmentItem(data.getTest3data().getAsset());
            test.log(Status.INFO, "Clicked on " + data.getTest3data().getAsset() + " investment item");
            misInversionesPage.enterComprar(data.getTest3data().getQuantity());
            test.log(Status.INFO, "Entered quantity to buy: " + data.getTest3data().getQuantity());
            misInversionesPage.clickComprarButton();
            test.log(Status.INFO, "Clicked on Comprar button");
            misInversionesPage.getDetailNotification("Operación realizada.");
            test.log(Status.INFO, "Verified operation notification: Operación realizada.");
            Assertions.assertEquals("$ 41.910,00", misInversionesPage.getBalanceValue());
            test.log(Status.INFO, "Verified balance value: $ 41.910,00");
            Assertions.assertEquals("(1 unidades)",
                    misInversionesPage.getMyInvestmentItemUnits(data.getTest3data().getAsset()));
            test.log(Status.INFO, "Verified " + data.getTest3data().getAsset() + " investment units: (1 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals(data.getTest3data().getAsset(),
                    misInversionesPage.getPieChartItemText(data.getTest3data().getAsset()));
            test.log(Status.INFO, "Verified pie chart contains item text: " + data.getTest3data().getAsset());
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 3

        } catch (AssertionError assertionError) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail(assertionError, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception error) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail(error, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
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

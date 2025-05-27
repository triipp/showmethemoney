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

/* Adding a demo test to validate if the POM is working*/

public class testSmtm {
    public WebDriver driver;
    public WebDriverWait wait;
    MisInversionesPage misInversionesPage;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Report_smtm.html");
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
        misInversionesPage.url("https://sea-lion-app-7celq.ondigitalocean.app/");
    }

    @Test
    public void testBuyFromMyInvestments() {
        try {
            // TEST 1: Buy from my investment section - TEST STEPS
            test = extent.createTest("First test - Buy from my investment section");
            test.log(Status.INFO, "Starting test case: First test - Buy from my investment section");
            misInversionesPage.clickMyInvestmentItem("Ternium Argentina");
            test.log(Status.INFO, "Clicked on Ternium Argentina investment item");
            misInversionesPage.enterComprar("1");
            test.log(Status.INFO, "Entered quantity to buy: 1");
            misInversionesPage.clickComprarButton();
            test.log(Status.INFO, "Clicked on Comprar button");
            misInversionesPage.getDetailNotification("Operación realizada.");
            test.log(Status.INFO, "Verified operation notification: Operación realizada.");
            Assertions.assertEquals("$ 41.873,75", misInversionesPage.getBalanceValue());
            test.log(Status.INFO, "Verified balance value: $ 41.873,75");
            Assertions.assertEquals("(11 unidades)", misInversionesPage.getMyInvestmentItemUnits("Ternium Argentina"));
            test.log(Status.INFO, "Verified Ternium Argentina investment units: (11 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals("Ternium Argentina", misInversionesPage.getPieChartItemText("Ternium Argentina"));
            test.log(Status.INFO, "Verified pie chart contains item text: Ternium Argentina");
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 1

        } catch (AssertionError assertionError) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail("Assertion failure: " + assertionError.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception error) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail("Exception failure: " + error.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @Test
    public void testSellFromMyInvestments() {
        try {
            // TEST 2: Sell from my investment section - TEST STEPS
            test = extent.createTest("Second test - Sell from my investment section");
            test.log(Status.INFO, "Starting test case: Second test - Sell from my investment section");
            misInversionesPage.clickMyInvestmentItem("Ternium Argentina");
            test.log(Status.INFO, "Clicked on Ternium Argentina investment item");
            misInversionesPage.enterVender("1");
            test.log(Status.INFO, "Entered quantity to sell: 1");
            misInversionesPage.clickVenderButton();
            test.log(Status.INFO, "Clicked on Vender button");
            misInversionesPage.getDetailNotification("Operación realizada.");
            test.log(Status.INFO, "Verified operation notification: Operación realizada.");
            Assertions.assertEquals("$ 42.126,25", misInversionesPage.getBalanceValue());
            test.log(Status.INFO, "Verified balance value: $ 42.126,25");
            Assertions.assertEquals("(9 unidades)", misInversionesPage.getMyInvestmentItemUnits("Ternium Argentina"));
            test.log(Status.INFO, "Verified Ternium Argentina investment units: (9 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals("Ternium Argentina", misInversionesPage.getPieChartItemText("Ternium Argentina"));
            test.log(Status.INFO, "Verified pie chart contains item text: Ternium Argentina");
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 2

        } catch (AssertionError assertionError) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail("Assertion failure: " + assertionError.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception error) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail("Exception failure: " + error.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @Test
    public void testBuyFromOtherInvestments() {
        try {
            // TEST 3: Buy from other investments section - Without holdings - TEST STEPS
            test = extent.createTest("Second test - Sell from other investments section - User without holdings");
            test.log(Status.INFO,
                    "Starting test case: Second test - Sell from my investment section - User without holdings");
            misInversionesPage.clickOtherInvestmentItem("BOCAN 2022");
            test.log(Status.INFO, "Clicked on BOCAN 2022 investment item");
            misInversionesPage.enterComprar("1");
            test.log(Status.INFO, "Entered quantity to buy: 1");
            misInversionesPage.clickComprarButton();
            test.log(Status.INFO, "Clicked on Comprar button");
            misInversionesPage.getDetailNotification("Operación realizada.");
            test.log(Status.INFO, "Verified operation notification: Operación realizada.");
            Assertions.assertEquals("$ 41.910,00", misInversionesPage.getBalanceValue());
            test.log(Status.INFO, "Verified balance value: $ 41.910,00");
            Assertions.assertEquals("(1 unidades)", misInversionesPage.getMyInvestmentItemUnits("BOCAN 2022"));
            test.log(Status.INFO, "Verified BOCAN 2022 investment units: (1 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals("BOCAN 2022", misInversionesPage.getPieChartItemText("BOCAN 2022"));
            test.log(Status.INFO, "Verified pie chart contains item text: BOCAN 2022");
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 3

        } catch (AssertionError assertionError) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail("Assertion failure: " + assertionError.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception error) {
            String screenshotPath = ScreenshotHelper.takeScreenshot(driver,
                    Thread.currentThread().getStackTrace()[1].getMethodName());
            test.fail("Exception failure: " + error.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
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

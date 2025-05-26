import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helpers.ExtentFactory;
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
    public void test_1() {
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
            Assertions.assertEquals(misInversionesPage.getBalanceValue(), "$ 41.873,75");
            test.log(Status.INFO, "Verified balance value: $ 41.873,75");
            Assertions.assertEquals(misInversionesPage.getMyInvestmentItemUnits("Ternium Argentina"), "(11 unidades)");
            test.log(Status.INFO, "Verified Ternium Argentina investment units: (11 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals(misInversionesPage.getPieChartItemText("Ternium Argentina"), "Ternium Argentina");
            test.log(Status.INFO, "Verified pie chart contains item text: Ternium Argentina");
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 1

        } catch (AssertionError assertionError) {
            test.log(Status.FAIL, "Assertion failed: " + assertionError.getMessage());
            throw assertionError;
        } catch (Exception error) {
            test.log(Status.FAIL, "Test failed due to: " + error.getMessage());
            Assertions.fail("Test failed due to: " + error.getMessage());
        }
    }

    @Test
    public void test_2() {
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
            Assertions.assertEquals(misInversionesPage.getBalanceValue(), "$ 42.126,25");
            test.log(Status.INFO, "Verified balance value: $ 42.126,25");
            Assertions.assertEquals(misInversionesPage.getMyInvestmentItemUnits("Ternium Argentina"), "(9 unidades)");
            test.log(Status.INFO, "Verified Ternium Argentina investment units: (9 unidades)");
            misInversionesPage.clickMyInvestmentsButton();
            test.log(Status.INFO, "Clicked on My Investments button");
            Assertions.assertEquals(misInversionesPage.getPieChartItemText("Ternium Argentina"), "Ternium Argentina");
            test.log(Status.INFO, "Verified pie chart contains item text: Ternium Argentina");
            test.log(Status.PASS, "Test passed successfully");
            // END TEST 2

        } catch (AssertionError assertionError) {
            test.log(Status.FAIL, "Assertion failed: " + assertionError.getMessage());
            throw assertionError;
        } catch (Exception error) {
            test.log(Status.FAIL, "Test failed due to: " + error.getMessage());
            Assertions.fail("Test failed due to: " + error.getMessage());
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

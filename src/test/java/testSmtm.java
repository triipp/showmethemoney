import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import smtm.helpers.ExtentFactory;
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
    public void test_1() throws InterruptedException {
        ExtentTest test = extent.createTest("First test - Buy Ternium Argentina");
        test.log(Status.INFO, "Starting test case: First test - Buy Ternium Argentina");
        misInversionesPage.clickMyInvestmentItem("Ternium Argentina");
        test.log(Status.INFO, "Clicked on Ternium Argentina investment item");
        misInversionesPage.enterComprar("1");
        test.log(Status.INFO, "Entered quantity to buy: 1");
        misInversionesPage.clickComprarButton();
        test.log(Status.INFO, "Clicked on Comprar button");
        misInversionesPage.getDetailNotification("Operación realizada.");
        test.log(Status.INFO, "Verified operation notification: Operación realizada.");
        Assertions.assertTrue(misInversionesPage.getBalanceValue().equals("$ 41.873,75"));
        test.log(Status.INFO, "Verified balance value: $ 41.873,75");
        Assertions.assertTrue(misInversionesPage.getMyInvestmentItemUnits("Ternium Argentina").equals("(11 unidades)"));
        test.log(Status.INFO, "Verified Ternium Argentina investment units: (11 unidades)");
        misInversionesPage.clickMyInvestmentsButton();
        test.log(Status.INFO, "Clicked on My Investments button");
        Assertions.assertTrue(misInversionesPage.getPieChartItemText("Ternium Argentina").equals("Ternium Argentina"));
        test.log(Status.INFO, "Verified pie chart contains item text: Ternium Argentina");
        test.log(Status.PASS, "Test case passed successfully.");
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

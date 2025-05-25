import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import smtm.MisInversionesPage;

/* Adding a demo test to validate if the POM is working*/
public class testSmtm {
    public WebDriver driver;
    public WebDriverWait wait;

    @Test
    public void test_1() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        MisInversionesPage misInversionesPage = new MisInversionesPage(driver, wait);
        misInversionesPage.setup();
        driver.get("https://sea-lion-app-7celq.ondigitalocean.app/");
        Thread.sleep(2000);
        misInversionesPage.clickMyInvestmentItem("Ternium Argentina");

        Thread.sleep(2000);
        misInversionesPage.enterComprar("1");
        misInversionesPage.clickComprarButton();
        Thread.sleep(5000);
        System.out.println(misInversionesPage.getBalanceValue());
        assert misInversionesPage.getBalanceValue().equals("$ 41.873,75");
        System.out.println(misInversionesPage.getMyInvestmentItemUnits("Ternium Argentina"));
        assert misInversionesPage.getMyInvestmentItemUnits("Ternium Argentina").equals("(11 unidades)");
        misInversionesPage.clickMyInvestmentsButton();
        assert misInversionesPage.getPieChartItemText("Ternium Argentina").equals("Ternium Argentina");
        System.out.println(misInversionesPage.getPieChartItemText("Ternium Argentina"));
    }
}

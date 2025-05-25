import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/* Adding a demo test to validate we can track elements */
public class testSmtm {
    public WebDriver driver;

    public void clickMyInvestmentItemTernium(String item) {
        WebElement myInvestmentItem = driver.findElement(
                By.xpath("//*[@class='my-investments']//button[text()='" + item + "']/following-sibling::button"));
        myInvestmentItem.click();
    }

    @Test
    public void test_1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://sea-lion-app-7celq.ondigitalocean.app/");
        Thread.sleep(2000);

        WebElement balanceField = driver.findElement(By.className("my-investments"));

        clickMyInvestmentItemTernium("Aluar");
        System.err.println(balanceField.getText());
        Assertions.assertTrue(balanceField.getText().contains("$ 42.000,00"));

        // driver.quit();
    }
}

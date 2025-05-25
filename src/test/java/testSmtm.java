import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testSmtm {
    public WebDriver driver;

    @Test
    public void test_1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://sea-lion-app-7celq.ondigitalocean.app/");
        Thread.sleep(2000);

        WebElement balanceField = driver.findElement(By.className("my-investments"));

        System.err.println(balanceField.getText()); // "Primer Test"
        Assertions.assertTrue(balanceField.getText().contains("$ 42.000,00"));

        driver.quit();
    }
}

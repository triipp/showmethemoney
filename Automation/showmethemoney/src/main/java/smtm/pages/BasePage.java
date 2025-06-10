package smtm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        PageFactory.initElements(driver, this);
    }

    public void setup() {
        driver.manage().window().maximize();
    }

    public void url(String url) throws InterruptedException {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void sendText(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.findElement(locator).clear();
        this.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.findElement(locator).click();
    }

    protected String getText(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this.findElement(locator).getText();
    }

    // EMPIEZO ACA
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendText(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getText();
    }
}
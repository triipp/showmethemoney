package smtm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MisInversionesPage extends BasePage {
    // Locators
    private By myInvestmentsSection = By.className("my-investments");
    private By myInvestmentsButton = By.className("my-investments__title");
    private By itemComprarBox = By.xpath("//p[text()='Comprar']/following-sibling::input");
    private By itemComprarButton = By.xpath("//p[text()='Comprar']/following-sibling::button");
    private By itemVenderBox = By.xpath("//p[text()='Vender']/following-sibling::input");
    private By itemVenderButton = By.xpath("//p[text()='Vender']/following-sibling::button");

    // Constructor
    public MisInversionesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    // Methods
    public void clickMyInvestmentItem(String item) {
        // adding a parameter to the XPath to find the specific investment item
        WebElement myInvestmentItem = driver.findElement(
                By.xpath("//*[@class='my-investments']//button[text()='" + item + "']/following-sibling::button"));
        myInvestmentItem.click();
    }

    public void clickOtherInvestmentItem(String item) {
        // adding a parameter to the XPath to find the specific other investment item
        WebElement otherInvestmentItem = driver.findElement(
                By.xpath("//*[@class='other-investments']//button[text()='" + item + "']/following-sibling::button"));
        otherInvestmentItem.click();
    }

    public void enterComprar(String quantity) {
        this.sendText(itemComprarBox, quantity);
    }

    public void enterVender(String quantity) {
        this.sendText(itemVenderBox, quantity);
    }

    public void clickComprarButton() {
        this.click(itemComprarButton);
    }

    public void clickVenderButton() {
        this.click(itemVenderButton);
    }

    public void clickMyInvestmentsButton() {
        this.click(myInvestmentsButton);
    }

    public String getMyInvestmentsText() {
        return this.getText(myInvestmentsSection);
    }

    public String getPieChartItemText(String item) {
        // adding a parameter to the XPath to find the specific pie chart item
        WebElement pieChartItem = driver.findElement(
                By.xpath("//*[@id='piechart']//*[name()='text' and contains(text(),'" + item + "')]"));
        return pieChartItem.getText();
    }
}
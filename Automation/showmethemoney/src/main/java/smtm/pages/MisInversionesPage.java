package smtm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MisInversionesPage extends BasePage {
    // Locators
    @FindBy(xpath = "//p[text()='Caja de ahorro']/following-sibling::p[1]")
    WebElement balanceValue;

    @FindBy(className = "my-investments__title")
    WebElement myInvestmentsButton;

    @FindBy(xpath = "//p[text()='Comprar']/following-sibling::input")
    WebElement itemComprarBox;

    @FindBy(xpath = "//p[text()='Comprar']/following-sibling::button")
    WebElement itemComprarButton;

    @FindBy(xpath = "//p[text()='Vender']/following-sibling::input")
    WebElement itemVenderBox;

    @FindBy(xpath = "//p[text()='Vender']/following-sibling::button")
    WebElement itemVenderButton;

    @FindBy(xpath = "//*[@class='detail__notification']")
    WebElement detailNotication;

    private By myInvestmentItem;
    private By otherInvestmentItem;
    private By pieChartItem;

    // Constructor
    public MisInversionesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    // Methods
    public void clickMyInvestmentItem(String item) {
        // adding a parameter to the XPath to find the specific investment item
        myInvestmentItem = By
                .xpath("//*[@class='my-investments']//button[text()='" + item + "']/following-sibling::button");
        this.click(myInvestmentItem);
    }

    public String getMyInvestmentItemUnits(String item) {
        // adding a parameter to the XPath to find the specific investment item
        myInvestmentItem = By
                .xpath("//*[@class='my-investments']//button[text()='" + item + "']/following-sibling::button");
        return this.getText(myInvestmentItem);
    }

    public void clickOtherInvestmentItem(String item) {
        // adding a parameter to the XPath to find the specific other investment item
        otherInvestmentItem = By
                .xpath("//*[@class='other-investments']//button[text()='" + item + "']/following-sibling::button");
        this.click(otherInvestmentItem);
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

    public String getBalanceValue() {
        return this.getText(balanceValue);
    }

    public String getPieChartItemText(String item) {
        // adding a parameter to the XPath to find the specific pie chart item
        pieChartItem = By.xpath("//*[@id='piechart']//*[name()='text' and contains(text(),'" + item + "')]");
        return this.getText(pieChartItem);
    }

    public void getDetailNotification(String status) {
        wait.until(ExpectedConditions.textToBePresentInElement(detailNotication, status));
    }

}
package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertClick {
    ChromeDriver chromeDriver;
    private static final By alertBtn = By.id("alertButton");
    private static final By timerAlertBtn = By.id("timerAlertButton");
    private static final By confirmBtn = By.id("confirmButton");
    private static final By cancelText = By.xpath("//span[contains(., 'Cancel')]");

    public AlertClick(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public void clickOnAlerts() {
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement alertButton = chromeDriver.findElement(alertBtn);
        WebElement timerAlertButton = chromeDriver.findElement(timerAlertBtn);
        WebElement confirmButton = chromeDriver.findElement(confirmBtn);

        alertButton.click();
        chromeDriver.switchTo()
                .alert()
                .accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent())
                .accept();

        confirmButton.click();
        chromeDriver.switchTo()
                .alert()
                .dismiss();
    }

    public boolean cancelIsSelected() {
        return !chromeDriver.findElements(cancelText).isEmpty();
    }
}

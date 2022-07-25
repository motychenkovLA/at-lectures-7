import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {

    private final WebDriver webDriver;
    private final By textCancel = By.xpath("//span[contains(., 'Cancel')]");
    private final By alertButton = By.xpath("//button[@id = \"alertButton\"]");
    private final By timerAlertButton = By.xpath("//button[@id = \"timerAlertButton\"]");
    private final By confirmButton = By.xpath("//button[@id = \"confirmButton\"]");

    public AlertsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    public void open() {
//        String urlPageWithAlerts = "https://demoqa.com/alerts";
//        webDriver.get(urlPageWithAlerts);
//    }


    public void ClickAlertAndAccept() {
        WebElement button = webDriver.findElement(alertButton);
        button.click();
        webDriver.switchTo().alert().accept();
    }

    public void ClickTimerAlertAndAccept() {
        WebElement button = webDriver.findElement(timerAlertButton);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
        button.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void ClickConfirmAlertAndAccept() {
        WebElement button = webDriver.findElement(confirmButton);
        button.click();
        webDriver.switchTo().alert().dismiss();
    }

    public boolean isEmpty() {
        return !webDriver.findElements(textCancel)
                .isEmpty();
    }
}

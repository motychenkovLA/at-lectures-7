package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickAlert {
    private static final By alertButtonXpath = By.id("alertButton");
    private static final By timerAlertButtonXpath = By.id("timerAlertButton");
    private static final By confirmButtonXpath = By.id("confirmButton");
    private static final By cancelText = By.xpath("//span[contains(.,'Cancel')]");
    private static final String url = "https://demoqa.com/alerts";
    private final WebDriver webDriver;

    public ClickAlert(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(url);
    }

    public void clickAlertButton(By by) {
        webDriver.findElement(by).click();
        webDriver.switchTo().alert().accept();
    }

    public void clickTimerAlertButton(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.findElement(by).click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void clickConfirmButton(By by) {
        webDriver.findElement(by).click();
        webDriver.switchTo().alert().dismiss();
    }

    public boolean pageIsHaveText() {
        return (!webDriver.findElements(cancelText).isEmpty());
    }

    public void allBtnClickAlert() {
        clickAlertButton(alertButtonXpath);
        clickTimerAlertButton(timerAlertButtonXpath);
        clickConfirmButton(confirmButtonXpath);

        }

    }

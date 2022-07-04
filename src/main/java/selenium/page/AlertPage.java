package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {

    private static final By alertBtn = By.id("alertButton");
    private static final By timerAlertBtn = By.id("timerAlertButton");
    private static final By confirmBtn = By.id("confirmButton");

    private static final String url = "https://demoqa.com/alerts";
    WebDriver webDriver;

    public AlertPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(url);
    }

    public void alertAccept(By by) {
        webDriver.findElement(by).click();
        webDriver.switchTo().alert().accept();
    }

    public void alertAcceptWait(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.findElement(by).click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

    }

    public void alertDismiss(By by) {
        webDriver.findElement(by).click();
        webDriver.switchTo().alert().dismiss();

    }

    public boolean pageIsHaveText(String text) {
        return (!webDriver.findElements(By.xpath("//span[contains(.,'" + text + "')]")).isEmpty());
    }

    public void allBtnClick() {
        alertAccept(alertBtn);
        alertAcceptWait(timerAlertBtn);
        alertDismiss(confirmBtn);

    }

}

package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {
    private final WebDriver driver;


    private final By cancelText = By.xpath("//span[contains(., 'Cancel')]");
    private static final By alertButtonXpath = By.id("alertButton");
    private static final By timerAlertButtonXpath = By.id("timerAlertButton");
    private static final By confirmButtonXpath = By.id("confirmButton");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAlertButton() {
        WebElement alertButton = driver.findElement(alertButtonXpath);
        alertButton.click();
        driver.switchTo().alert().accept();
    }

    public void clickTimerAlertButton() {
        WebElement timerAlertButton = driver.findElement(timerAlertButtonXpath);
        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void clickConfirmButton() {
        WebElement confirmButton = driver.findElement(confirmButtonXpath);
        confirmButton.click();
        driver.switchTo().alert().dismiss();
    }

    public boolean isEmpty() {
        return !driver.findElements(cancelText)
                .isEmpty();
    }
}
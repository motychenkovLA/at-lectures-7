package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickAlert {
    private final WebDriver driver;

    private static final By alertButtonXpath = By.id("alertButton");
    private static final By timerAlertButtonXpath = By.id("timerAlertButton");
    private static final By confirmButtonXpath = By.id("confirmButton");
    private final By textAlertCancelXpath = By.xpath("//span[text()='You selected ' and text()='Cancel'] ");

    public ClickAlert(WebDriver driver) {
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
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(8));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void clickConfirmButton() {
        WebElement confirmButton = driver.findElement(confirmButtonXpath);
        confirmButton.click();
        driver.switchTo().alert().dismiss();
    }

    public String isHaveText() {
        return driver.findElement(textAlertCancelXpath).getText();
    }
}
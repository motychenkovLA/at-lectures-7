package Page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {
    private final WebDriver driver;


    private static final By alertButtonXpath = By.id("alertButton");
    private static final By timerAlertButtonXpath = By.id("timerAlertButton");
    private static final By confirmButtonXpath = By.id("confirmButton");
    private final By textAlertCancelXpath = By.xpath("//span[text()='You selected ' and text()='Cancel'] ");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку с тестом: Click Button to see alert")
    public void clickAlertButton() {
        WebElement alertButton = driver.findElement(alertButtonXpath);
        alertButton.click();
        driver.switchTo().alert().accept();
    }

    @Step("Нажать кнопку с тестом: On button click, alert will appear after 5 seconds")
    public void clickTimerAlertButton() {
        WebElement timerAlertButton = driver.findElement(timerAlertButtonXpath);
        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    @Step("Нажать кнопку с тестом: On button click, confirm box will appear")
    public void clickConfirmButton() {
        WebElement confirmButton = driver.findElement(confirmButtonXpath);
        confirmButton.click();
        driver.switchTo().alert().dismiss();
    }

    public String isHaveText() {
        return driver.findElement(textAlertCancelXpath).getText();
    }

}
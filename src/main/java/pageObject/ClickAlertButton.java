package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickAlertButton {

    private static WebDriver webDriver;

    private By alertButtonElement = By.id("alertButton");
    private By timerAlertButtonElement = By.id("timerAlertButton");
    private By confirmButtonElement = By.id("confirmButton");

    private By shouldAlertText = By.xpath("//span[text()='You selected '][text()='Cancel']");

    public ClickAlertButton(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие страницы с Алертами")
    public void openAlertDemoqa() {
        webDriver.get("https://demoqa.com/alerts");
    }

    @Step("Клик по кнопкам Алерта")
    public void clickAlertAll() {
        WebElement alertButton = webDriver.findElement(alertButtonElement);
        WebElement timerAlertButton = webDriver.findElement(timerAlertButtonElement);
        WebElement confirmButton = webDriver.findElement(confirmButtonElement);

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
        webDriver.switchTo().alert().dismiss();
    }

    @Step("Проверка")
    public boolean isAlertText() {
        boolean isHaveText = !webDriver.findElements(shouldAlertText).isEmpty();
        return isHaveText;
    }
}

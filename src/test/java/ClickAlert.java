import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickAlert {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
        webDriver.get("https://demoqa.com/alerts");

        WebElement alertButton = webDriver.findElement(By.id("alertButton"));
        WebElement alertTimerButton = webDriver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));

        alertButton.click();
        webDriver.switchTo().alert().accept();

        alertTimerButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
        webDriver.switchTo().alert().dismiss();

        boolean isHaveText = !webDriver.findElements(By.id("confirmResult")).isEmpty();
        if (isHaveText) {
            System.out.println("Тест пройден успешно");
        } else {
            System.out.println("Тест провален");
        }

        webDriver.quit();
    }
}

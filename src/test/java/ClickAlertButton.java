import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickAlertButton {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32_103.05060.53\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get("https://demoqa.com/alerts");

        WebElement alertButton = webDriver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = webDriver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
//        webDriver.switchTo().alert().accept();
        webDriver.switchTo().alert().dismiss();

        boolean isHaveText = !webDriver.findElements(By.xpath("//span[text()='You selected '][text()='Cancel']")).isEmpty();

        if (isHaveText) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест провален");
        }

        webDriver.quit();
    }
}

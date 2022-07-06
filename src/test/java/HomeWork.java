import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork {
    public static WebDriver driver;

    public static void main(String[] args) {
        click();
        clickAlert();
    }

    public static void driverCall() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void click() {
        driverCall();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/buttons");
        Click click = new Click(driver);
        click.clickDoubleButton();
        click.clickRightButton();
        click.clickMe();

        if (click.isHaveDoubleClickText() && click.isHaveRightClickText()
                && click.isHaveClickText()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
        driver.quit();
    }

    public static void clickAlert() {
        driverCall();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/alerts");
        ClickAlert clickAlert = new ClickAlert(driver);
        clickAlert.clickAlertButton();
        clickAlert.clickTimerAlertButton();
        clickAlert.clickConfirmButton();
        clickAlert.isHaveText();
        driver.quit();
    }

}


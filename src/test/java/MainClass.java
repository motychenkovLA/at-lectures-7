import Page.Click;
import Page.ClickAlert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainClass {
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
        ClickAlert clickOnAlert = new ClickAlert(driver);
        clickOnAlert.clickAlertButton();
        clickOnAlert.clickTimerAlertButton();
        clickOnAlert.clickConfirmButton();
        clickOnAlert.isHaveText();
        driver.quit();
    }
}

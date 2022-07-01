import Page.ClickNewTab;
import Page.ClickOnAlert;
import Page.ClickOnButtons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static WebDriver driver;

    public static void main(String[] args) {
        clickOnButtons();
        clickOnAlert();
        clickNewWin();
    }

    public static void driverCall() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void clickOnButtons() {
        driverCall();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/buttons");
        ClickOnButtons clickOnButtons = new ClickOnButtons(driver);
        clickOnButtons.clickDoubleButton();
        clickOnButtons.clickRightButton();
        clickOnButtons.clickMe();

        if (clickOnButtons.isHaveDoubleClickText() && clickOnButtons.isHaveRightClickText()
                && clickOnButtons.isHaveClickText()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
        driver.quit();
    }

        public static void clickOnAlert() {
            driverCall();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            driver.get("https://demoqa.com/alerts");
            ClickOnAlert clickOnAlert = new ClickOnAlert(driver);
            clickOnAlert.clickAlertButton();
            clickOnAlert.clickTimerAlertButton();
            clickOnAlert.clickConfirmButton();
            clickOnAlert.isHaveText();
            driver.quit();
        }

        public static void clickNewWin() {
            driverCall();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            ClickNewTab clickNewTab = new ClickNewTab(driver);
            clickNewTab.clickNewTab();
            driver.quit();
        }
    }

package Page;
import Page.ClickPage;
import Page.AlertPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Main {
    public static WebDriver driver;

    public static void main(String[] args) {
        clickPage();
        alertPage();
    }

    public static void driverCall() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void clickPage() {
        driverCall();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/buttons");
        ClickPage clickPage = new ClickPage(driver);
        clickPage.clickDoubleButton();
        clickPage.clickRightButton();
        clickPage.clickMe();

        if (clickPage.isHaveDoubleClickText() && clickPage.isHaveRightClickText()
                && clickPage.isHaveClickText()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
        driver.quit();
    }

    public static void alertPage() {
        driverCall();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/alerts");
        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickAlertButton();
        alertPage.clickTimerAlertButton();
        alertPage.clickConfirmButton();
        alertPage.isHaveText();
        driver.quit();
    }

}
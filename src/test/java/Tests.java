import Page.ButtonsPage;
import Page.AlertPage;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tests {

    @Rule
    public Timeout durationsOfTests = Timeout.seconds(180);
    public static WebDriver driver;

    @Before
    public void driveCall() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void click() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://demoqa.com/buttons");
        ButtonsPage click = new ButtonsPage(driver);
        click.clickDoubleButton();
        click.clickRightButton();
        click.clickMe();
        String expectedDoubleClickMeText = "You have done a double click";
        String expectedRightClickMeText = "You have done a right click";
        String expectedClickMeText = "You have done a dynamic click";

        Assert.assertEquals("Тест Двойной клик не пройден",
                expectedDoubleClickMeText, click.isHaveDoubleClickText());
        Assert.assertEquals("Тест Правый клик не пройден",
                expectedRightClickMeText, click.isHaveRightClickText());
        Assert.assertEquals("Тест Нажми меня не пройден",
                expectedClickMeText, click.isHaveClickText());
    }

    @Test
    public void clickAlert() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://demoqa.com/alerts");
        AlertPage clickOnAlert = new AlertPage(driver);
        clickOnAlert.clickAlertButton();
        clickOnAlert.clickTimerAlertButton();
        clickOnAlert.clickConfirmButton();
        String expectedAlertCancelText = "You selected " + "Cancel";
        Assert.assertEquals("Тексты сообщений не совпадают",
                expectedAlertCancelText, clickOnAlert.isHaveText());
    }
}

import Page.AlertPage;
import Page.ButtonsPage;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tests {

    @Rule
    public Timeout durationsOfTests = Timeout.seconds(180);
    private static WebDriver driver;

    @Before
    public void driverCall() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @DisplayName("Тест для кнопок")
    @Test
    public void clickOnButtons() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/buttons");
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickDoubleButton();
        buttonsPage.clickRightButton();
        buttonsPage.clickMe();
        String expectedDoubleClickMeText = "You have done a double click";
        String expectedRightClickMeText = "You have done a right click";
        String expectedClickMeText = "You have done a dynamic click";

        Assert.assertEquals("Тест Двойной клик не пройден",
                expectedDoubleClickMeText, buttonsPage.isHaveDoubleClickText());
        Assert.assertEquals("Тест Правый клик не пройден",
                expectedRightClickMeText, buttonsPage.isHaveRightClickText());
        Assert.assertEquals("Тест Нажми меня не пройден",
                expectedClickMeText, buttonsPage.isHaveClickText());
    }

    @DisplayName("Тест для алерта")
    @Test
    public void clickOnAlert() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/alerts");
        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickAlertButton();
        alertPage.clickTimerAlertButton();
        alertPage.clickConfirmButton();
        String expectedAlertCancelText = "You selected " + "Cancel";
        Assert.assertEquals("Тексты сообщений не совпадают",
                expectedAlertCancelText, alertPage.isHaveAlertText());
    }
}

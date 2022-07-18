import Page.ClickOnAlert;
import Page.ClickOnButtons;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
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

    @DisplayName("Тест для кнопок")
    @Test
    public void clickOnButtons() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/buttons");
        ClickOnButtons clickOnButtons = new ClickOnButtons(driver);
        clickOnButtons.clickDoubleButton();
        clickOnButtons.clickRightButton();
        clickOnButtons.clickMe();
        String expectedDoubleClickMeText = "You have done a double click";
        String expectedRightClickMeText = "You have done a right click";
        String expectedClickMeText = "You have done a dynamic click";

        Assert.assertEquals("Тест Двойной клик не пройден",
                expectedDoubleClickMeText, clickOnButtons.isHaveDoubleClickText());
        Assert.assertEquals("Тест Правый клик не пройден",
                expectedRightClickMeText, clickOnButtons.isHaveRightClickText());
        Assert.assertEquals("Тест Нажми меня не пройден",
                expectedClickMeText, clickOnButtons.isHaveClickText());

        driver.quit();
    }

    @DisplayName("Тест для алерта")
    @Test
    public void clickOnAlert() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demoqa.com/alerts");
        ClickOnAlert clickOnAlert = new ClickOnAlert(driver);
        clickOnAlert.clickAlertButton();
        clickOnAlert.clickTimerAlertButton();
        clickOnAlert.clickConfirmButton();
        String expectedAlertCancelText = "You selected " + "Cancel";
        Assert.assertEquals("Тексты сообщений не совпадают",
                expectedAlertCancelText, clickOnAlert.isHaveAlertText());

        driver.quit();
    }
}

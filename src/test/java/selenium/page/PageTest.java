package selenium.page;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class PageTest {

    @Rule
    public Timeout timeout = Timeout.seconds(180);
    private WebDriver driver;

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
    @Description("Тесты для кнопок")
    @Test
    public void clickTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://demoqa.com/buttons");
        ClickPage click = new ClickPage(driver);
        click.clickDoubleButton();
        click.clickRightButton();
        click.clickMe();

        Assert.assertTrue("Тест Двойной клик не пройден", click.isHaveDoubleClickText());
        Assert.assertTrue("Тест Правый клик не пройден", click.isHaveRightClickText());
        Assert.assertTrue("Тест Нажми меня не пройден", click.isHaveClickText());
    }


    @DisplayName("Тест для алерта")
    @Description("Все тесты для алерта")
    @Test
    public void ClickAlert() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://demoqa.com/alerts");
        AlertPage clickAlert = new AlertPage(driver);
        clickAlert.clickAlertButton();
        clickAlert.clickTimerAlertButton();
        clickAlert.clickConfirmButton();
        String expectedAlertCancelText = "You selected " + "Cancel";
        Assert.assertEquals("Тексты сообщений не совпадают",
                expectedAlertCancelText, clickAlert.isHaveText());
    }
}

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SecondTest {

    private static WebDriver driver;
    private static AlertsPage alertsPage;

    @Before
    public void setUpBeforeTests() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        alertsPage = new AlertsPage(driver);
    }

    @After
    public void afterTests() {
        if (driver != null) driver.quit();
    }

    @Rule
    public Timeout timeout =  Timeout.seconds(180);

    @Test
    public void alertsTests() {
        alertsPage = new AlertsPage(driver);
        driver.get("https://demoqa.com/alerts");
        alertsPage.ClickAlertAndAccept();
        alertsPage.ClickTimerAlertAndAccept();
        alertsPage.ClickConfirmAlertAndAccept();

        Assert.assertTrue("Тест провален!", alertsPage.isEmpty());
    }

}

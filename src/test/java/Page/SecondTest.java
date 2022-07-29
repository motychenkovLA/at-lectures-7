package Page;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.Timeout;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SecondTest {

    ChromeDriver driver;

    @Rule
    public Timeout testTimeout = Timeout.seconds(180);

    @Before
    public void BeforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @After
    public void afterMethod() {
        driver.quit();
    }

    @Category(TestLibrary.class)
    @Test
    public void secondTest() {
        driver.get("https://demoqa.com/alerts");

        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickAlertButton();
        alertPage.clickTimerAlertButton();
        alertPage.clickConfirmButton();
        Assert.assertTrue("Тест провален!", alertPage.isEmpty());


    }


}

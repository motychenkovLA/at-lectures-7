import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTest {

    private static WebDriver driver;

    @Before
    public void setUpBeforeTests() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void afterTests() {
        if (driver != null) driver.quit();
    }

    @Rule
    public Timeout timeout =  Timeout.seconds(180);

    @Test
    public void clickButtonsTest() {
        driver.get("https://demoqa.com/buttons");
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.DoubleClickButton();
        buttonsPage.RightMouseButtonClick();
        buttonsPage.LeftMouseButtonClick();

        Assert.assertTrue("Тест провален!", buttonsPage.isDoubleClickMessageEmpty());
        Assert.assertTrue("Тест провален!", buttonsPage.isLeftMouseClickMessageEmpty());
        Assert.assertTrue("Тест провален!", buttonsPage.isRightMouseClickMessageEmpty());
    }

}

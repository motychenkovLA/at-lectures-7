package selenium.page;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


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
    @Test
    public void clickTest() {
        ClickPage clickPage = new ClickPage(driver);
        clickPage.allBtnClick();
        Assert.assertTrue("Тест кнопок не пройден", clickPage.isHaveDoubleClickText());
        Assert.assertTrue( "Тест кнопок не пройден", clickPage.isHaveRightClickText());
        Assert.assertTrue ("Тест кнопок не пройден",  clickPage.isHaveClickText());
    }


    @DisplayName("Тест для алерта")
    @Test
    public void clickAlertTest() {
        ClickAlert clickAlert = new ClickAlert(driver);
        clickAlert.allBtnClickAlert();
        Assert.assertTrue("Тест алерта не пройден", clickAlert.pageIsHaveText());
    }

    @Test
    public void windowPageTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WindowPage page = new WindowPage(driver);
        String firstWindowDescriptor = driver.getWindowHandle();
        page.tabBtnClick();
        Set<String> descriptors = driver.getWindowHandles();
        descriptors.remove(firstWindowDescriptor);
        Iterator<String> iterator = descriptors.iterator();
        String secondWindowDescriptor = iterator.next();
        driver.switchTo().window(secondWindowDescriptor);
        driver.get("https://google.com");
        driver.switchTo().window(firstWindowDescriptor);
        Assert.assertTrue("Тест 3 (windowPageTest) не пройден", page.pageIsHaveBtn());
    }
}

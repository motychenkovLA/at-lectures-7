package selenium.page;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PageTest {

    private WebDriver driver;

    @Rule
    public Timeout timeout = new Timeout(180000);


    @BeforeClass
    public static void setProperties() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/selenium/chromedriver.exe");
    }

    @Before
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @After
    public void quitDriver() {
        if (driver != null) driver.quit();
    }

    @Test
    public void buttonPageTest() {
        ButtonPage page = new ButtonPage(driver);
        page.allBtnClick();
        Assert.assertTrue("Тест 1 (buttonPageTest) не пройден", page.pageIsHaveText("You have done a double click")
                && page.pageIsHaveText("You have done a right click")
                && page.pageIsHaveText("You have done a dynamic click"));
    }

    @Test
    public void alertPageTest() {
        AlertPage page = new AlertPage(driver);
        page.allBtnClick();
        Assert.assertTrue("Тест 2 (alertPageTest) не пройден", page.pageIsHaveText());
    }

    @Test
    public void windowPageTest() {
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
package selenium.page;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

@DisplayName("Тест на JUnit")
public class PageTest {

    @Rule
    public Timeout timeout = new Timeout(180000);
    private WebDriver driver;

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
    @DisplayName("Нажатие кнопок")
    public void buttonPageTest() {
        ButtonPage page = new ButtonPage(driver);
        page.allBtnClick();
        Assert.assertTrue("Тест 1 (buttonPageTest) не пройден", page.pageIsHaveText("You have done a double click")
                && page.pageIsHaveText("You have done a right click")
                && page.pageIsHaveText("You have done a dynamic click"));
    }

    @Test
    @DisplayName("Работа с алертами")
    public void alertPageTest() {
        AlertPage page = new AlertPage(driver);
        //page.siteOpen();
        page.allBtnClick();
        Assert.assertTrue("Тест 2 (alertPageTest) не пройден", page.pageIsHaveText());
    }

    @Test
    @DisplayName("Работа с окнами")
    public void windowPageTest() {
        WindowPage page = new WindowPage(driver);
        String firstWindowDescriptor = driver.getWindowHandle();
        page.tabBtnClick();
        Set<String> descriptors = driver.getWindowHandles();
        descriptors.remove(firstWindowDescriptor);
        Iterator<String> iterator = descriptors.iterator();
        String secondWindowDescriptor = iterator.next();

        CommonSteps.focusTo(driver, secondWindowDescriptor);
        CommonSteps.pageOpen(driver, "https://google.com");
        CommonSteps.focusTo(driver, firstWindowDescriptor);
        Assert.assertTrue("Тест 3 (windowPageTest) не пройден", page.pageIsHaveBtn());
    }


}
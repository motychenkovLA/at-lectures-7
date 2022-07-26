import Page.ButtonClick;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

@DisplayName("JUnit - первый тест")
public class FirstTest {
    ChromeDriver chromeDriver;

    @Before
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @After
    public void afterMethod() {
        chromeDriver.quit();
    }

    @Rule
    public Timeout testTimeout = Timeout.seconds(180);

    @Test
    @DisplayName("Тест: нажатие кнопок")
    public void firstTest() {
        chromeDriver.get("https://demoqa.com/buttons");

        ButtonClick buttonClick = new ButtonClick(chromeDriver);
        buttonClick.clickOnButtons();
        boolean expected = true;
        boolean actual = buttonClick.doneClick();
        Assert.assertEquals("Тест не пройден", expected, actual);
    }
}
import Page.AlertClick;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

@DisplayName("JUnit - второй тест")
public class SecondTest {
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
    @DisplayName("Тест: вызов алертов")
    public void exerciseSecond() {
        chromeDriver.get("https://demoqa.com/alerts");

        AlertClick alertClick = new AlertClick(chromeDriver);
        alertClick.clickOnAlerts();
        boolean expected = true;
        boolean actual = alertClick.cancelIsSelected();
        Assert.assertEquals("Тест не пройден", expected, actual);
    }
}
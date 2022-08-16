package pageObject.demoqa;

import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.ClickButton;

import java.time.Duration;

@DisplayName("Тест на JUnit2")
public class ClickButtonTest {
    static WebDriver webDriver;
    ClickButton clickButton;

    @Rule
    public Timeout clickTimeOut = Timeout.seconds(180);

    @BeforeClass
    public static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @DisplayName("Клик по кнопке")
    @Test
    public void shouldText() {
        clickButton = new ClickButton(webDriver);
        clickButton.openDemoqa();
        clickButton.clickAll();
        assert clickButton.isText();
    }

    @AfterClass
    public static void endUp() {
        webDriver.quit();
    }
}

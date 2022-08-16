package demoqa;

import io.qameta.allure.junit4.DisplayName;
import lombok.Getter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClickAlertButton;

import java.time.Duration;

@DisplayName("Тест на JUnit1")
public class ClickAlertButtonTest {
    static WebDriver webDriver;
    ClickAlertButton clickAlertButton;

    @Rule
    public Timeout clickAlertTimeOut = Timeout.seconds(180);

    @BeforeClass
    public static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @DisplayName("Клик по кнопке Алерта")
    @Test
    public void shouldText() {
        clickAlertButton = new ClickAlertButton(webDriver);
        clickAlertButton.openAlertDemoqa();
        clickAlertButton.clickAlertAll();
        assert clickAlertButton.isAlertText();
    }

    @AfterClass
    public  static void endUp() {
        webDriver.quit();
    }
}

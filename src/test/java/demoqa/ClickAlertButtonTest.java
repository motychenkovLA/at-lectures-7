package demoqa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClickAlertButton;

import java.time.Duration;

public class ClickAlertButtonTest {
    static WebDriver webDriver;
    static ClickAlertButton clickAlertButton;

    @Rule
    public Timeout clickAlertTimeOut = Timeout.seconds(180);

    @BeforeClass
    public static void setUp() {
        webDriver = new ChromeDriver();
        clickAlertButton = new ClickAlertButton(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void shouldText() {
        clickAlertButton.openAlertDemoqa();
        clickAlertButton.clickAlertAll();
        assert clickAlertButton.isAlertText();
    }

    @AfterClass
    public  static void endUp() {
        webDriver.quit();
    }
}

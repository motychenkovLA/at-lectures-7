package demoqa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClickAlertButton;

import java.time.Duration;

public class ClickAlertButtonTest {
    static WebDriver webDriver;
    static ClickAlertButton clickAlertButton;

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

//        assert clickButton.isAlertText();

        if (clickAlertButton.isAlertText()) {
            System.out.println("Тест пройден");
        } else {
            throw new AssertionError();
        }
        webDriver.quit();
    }
}

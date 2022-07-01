package demoqa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ClickButton;

import java.time.Duration;

public class ClickButtonTest {
    static WebDriver webDriver;
    static ClickButton clickButton;

    @BeforeClass
    public static void setUp() {
        webDriver = new ChromeDriver();
        clickButton = new ClickButton(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void souldText() {
        clickButton.openDemoqa();
        clickButton.clickAll();

//        assert clickButton.isText();

        if (clickButton.isText()) {
            System.out.println("Тест пройден");
        } else {
            throw new AssertionError();
        }
        webDriver.quit();
    }
}

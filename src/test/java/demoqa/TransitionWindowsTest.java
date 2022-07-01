package demoqa;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TransitionWindows;

import java.time.Duration;

public class TransitionWindowsTest {
    static WebDriver webDriver;
    static TransitionWindows transitionWindows;

    @BeforeClass
    public static void setUp() {
        webDriver = new ChromeDriver();
        transitionWindows = new TransitionWindows(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void shouldPageWindows() throws InterruptedException {
        transitionWindows.openDemoqaWindows();
        transitionWindows.clickTabButton();
        transitionWindows.transitionWindows();
        boolean atPage = webDriver.getTitle().equals("ToolsQA");
        if (atPage) {
            System.out.println("Тест пройден");
        } else {
            throw new AssertionError();
        }
        webDriver.quit();
    }
}

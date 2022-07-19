package demoqa;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TransitionWindows;

import java.time.Duration;

public class TransitionWindowsTest {
    static WebDriver webDriver;
    static TransitionWindows transitionWindows;

    @Rule
    public Timeout transitionTimeOut = Timeout.seconds(180);

    @BeforeClass
    public static void setUp() {
        webDriver = new ChromeDriver();
        transitionWindows = new TransitionWindows(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void shouldBePageWindows() throws InterruptedException {
        transitionWindows.openDemoqaWindows();
        transitionWindows.clickTabButton();
        transitionWindows.transitionWindows();
        Assert.assertTrue(transitionWindows.isPage());
    }

    @AfterClass
    public static void endUp() {
        webDriver.quit();
    }
}

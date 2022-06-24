import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TransitionWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32_103.05060.53\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get("https://demoqa.com/browser-windows");
//        String demoqaWindowDescription = webDriver.getWindowHandle();

        WebElement tabButton = webDriver.findElement(By.id("tabButton"));
        new Actions(webDriver).click(tabButton).build().perform();

        List<String> description = new ArrayList<>(webDriver.getWindowHandles());

        webDriver.switchTo().window(description.get(1));
        webDriver.get("https://google.com");

        Thread.sleep(2000);
        webDriver.switchTo().window(description.get(0));
    }
}

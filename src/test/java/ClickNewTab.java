import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ClickNewTab {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/browser-windows");

        String demoqaDescriptor = webDriver.getWindowHandle();

        WebElement newTab = webDriver.findElement(By.id("tabButton"));

        newTab.click();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoqaDescriptor);

        Iterator<String> iterator = handles.iterator();
        String newTabWindowDescriptor = iterator.next();

        webDriver.switchTo()
                .window(newTabWindowDescriptor);
        webDriver.get("https://google.com");

        webDriver.switchTo()
                .window(demoqaDescriptor);

        webDriver.quit();
    }
}

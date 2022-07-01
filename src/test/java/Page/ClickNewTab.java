package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class ClickNewTab {

    private final WebDriver driver;
    private final By newTab = By.id("tabButton");

    public ClickNewTab(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewTab() {
        driver.get("https://demoqa.com/browser-windows");
        String demoqaDescriptor = driver.getWindowHandle();
        WebElement newTabReal = driver.findElement(newTab);
        newTabReal.click();

        Set<String> handles = driver.getWindowHandles();
        handles.remove(demoqaDescriptor);

        Iterator<String> iterator = handles.iterator();
        String newTabWindowDescriptor = iterator.next();

        driver.switchTo().window(newTabWindowDescriptor);
        driver.get("https://google.com");
        driver.switchTo().window(demoqaDescriptor);
    }
}

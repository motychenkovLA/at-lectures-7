import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Click {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        WebElement doubleClick = webDriver.findElement(By.id("doubleClickBtn"));
        WebElement rightClick = webDriver.findElement(By.id("rightClickBtn"));
        WebElement clickMe = webDriver.findElement(By.xpath("//button[text()= 'Click Me']"));

        new Actions(webDriver)
                .doubleClick(doubleClick)
                .contextClick(rightClick)
                .click(clickMe)
                .build()
                .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath("//p[text()= 'You have done a double click']"))
                .isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.xpath("//p[text()= 'You have done a right click']"))
                .isEmpty();
        boolean isHaveClickMeText = !webDriver.findElements(By.xpath("//p[text()= 'You have done a dynamic click']"))
                .isEmpty();
        webDriver.quit();

        if (isHaveClickMeText && isHaveDoubleClickText && isHaveRightClickText) {
            System.out.println("Тест пройден успешно");
        } else {
            System.out.println("Тест не пройден");
        }
    }
}

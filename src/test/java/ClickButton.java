import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ClickButton {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver_win32_103.05060.53\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        webDriver.get("https://demoqa.com/buttons");

        WebElement doubleClick = webDriver.findElement(By.xpath("//button[.='Double Click Me']"));
        WebElement rightClick = webDriver.findElement(By.xpath("//button[.='Right Click Me']"));
        WebElement click = webDriver.findElement(By.xpath("//button[.='Click Me']"));

        new Actions(webDriver)
                .doubleClick(doubleClick)
                .contextClick(rightClick)
                .click(click)
                .build()
                .perform();


        boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath("//p[.='You have done a double click']")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.xpath("//p[.='You have done a right click']")).isEmpty();
        boolean isHaveClickText = !webDriver.findElements(By.xpath("//p[.='You have done a dynamic click']")).isEmpty();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveClickText) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест провален");
        }

        webDriver.quit();
    }
}

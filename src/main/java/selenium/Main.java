package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Main {
        public static void main(String[] args) {
           System.setProperty("webdriver.chrome.driver", "src/main/java/selenium/chromedriver.exe");
            exerciseFirst();
            exerciseSecond();
            exerciseThird();
        }

        public static void exerciseFirst() {
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            webDriver.get("https://demoqa.com/buttons");

            WebElement doubleClick = webDriver.findElement(By.id("doubleClickBtn"));
            WebElement rightClick = webDriver.findElement(By.id("rightClickBtn"));
            WebElement click = webDriver.findElement(By.xpath("//button[text()='Click Me']"));

            new Actions(webDriver)
                    .doubleClick(doubleClick)
                    .contextClick(rightClick)
                    .click(click)
                    .build()
                    .perform();

            boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
            boolean isHaveRightClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
            boolean isHaveClickMeText = !webDriver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();
            webDriver.quit();
            if (isHaveDoubleClickText && isHaveRightClickText && isHaveClickMeText) {
                System.out.println("Тест 1 пройден");
            } else {
                System.out.println("Тест 1 не пройден");
            }

        }

        public static void exerciseSecond() {
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

            webDriver.get("https://demoqa.com/alerts");
            WebElement alertButton = webDriver.findElement(By.id("alertButton"));
            WebElement timerAlertButton = webDriver.findElement(By.id("timerAlertButton"));
            WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));

            alertButton.click();
            webDriver.switchTo().alert().accept();

            timerAlertButton.click();
            webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

            confirmButton.click();
            webDriver.switchTo().alert().dismiss();
            boolean isHaveCancelText = !webDriver.findElements(By.xpath("//span[contains(.,'Cancel')]")).isEmpty();
            webDriver.quit();
            if (isHaveCancelText) {
                System.out.println("Тест 2 пройден");
            } else {
                System.out.println("Тест 2 не пройден");
            }

        }
        public static void exerciseThird(){
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get("https://demoqa.com/browser-windows");
            WebElement tabButton = webDriver.findElement(By.id("tabButton"));
            String firstWindowDescriptor = webDriver.getWindowHandle();

            tabButton.click();

            Set<String> descriptors = webDriver.getWindowHandles();
            descriptors.remove(firstWindowDescriptor);

            Iterator<String> iterator = descriptors.iterator();
            String secondWindowDescriptor = iterator.next();

            webDriver.switchTo().window(secondWindowDescriptor);

            webDriver.get("https://google.com");

            webDriver.switchTo().window(firstWindowDescriptor);


        }
    }




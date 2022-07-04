import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Main {
    public static void main(String[] args) {
        exerciseFirst();
        exerciseSecond();
    }

    public static void exerciseFirst(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        chromeDriver.get("https://demoqa.com/buttons");
        WebElement doubleClick = chromeDriver.findElement(By.id("doubleClickBtn"));
        WebElement rightClick = chromeDriver.findElement(By.id("rightClickBtn"));
        WebElement click = chromeDriver.findElement(By.xpath("//button[text()='Click Me']"));

        new Actions(chromeDriver)
                .doubleClick(doubleClick)
                .contextClick(rightClick)
                .click(click)
                .build()
                .perform();

        boolean doneDoubleClick = !chromeDriver.findElements(By.xpath("//p[text()='You have done a double click']"))
                .isEmpty();
        boolean doneRightClick = !chromeDriver.findElements(By.xpath("//p[text()='You have done a right click']"))
                .isEmpty();
        boolean doneClickMe = !chromeDriver.findElements(By.xpath("//p[text()='You have done a dynamic click']"))
                .isEmpty();
        chromeDriver.quit();
        if (doneDoubleClick && doneRightClick && doneClickMe) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }

    public static void exerciseSecond() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        chromeDriver.get("https://demoqa.com/alerts");

        WebElement alertButton = chromeDriver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = chromeDriver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = chromeDriver.findElement(By.id("confirmButton"));

        alertButton.click();
        chromeDriver.switchTo()
                .alert()
                .accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent())
                .accept();

        confirmButton.click();
        chromeDriver.switchTo()
                .alert()
                .dismiss();

        boolean cancelSelected = !chromeDriver.findElements(By.xpath("//span[contains(., 'Cancel')]")).isEmpty();
        chromeDriver.quit();

        if (cancelSelected) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }
}

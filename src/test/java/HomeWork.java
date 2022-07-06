import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork {
    public static void main(String[] args) {
        exerciseSecond();
    }

    public static void exerciseFirst() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver= new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        WebElement doubleClick=webDriver.findElement(By.id("doubleClickBtn"));
        WebElement rightClick=webDriver.findElement(By.id("rightClickBtn"));
        WebElement click= webDriver.findElement(By.xpath("//button[text()= 'Click Me']"));

        new Actions(webDriver)
                .doubleClick(doubleClick)
                .contextClick(rightClick)
                .click(click)
                .build()
                .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath(
                "//p[text()='You have done a double click']")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.xpath(
                "//p[text()='You have done a right click']")).isEmpty();
        boolean isHaveClickMeText = !webDriver.findElements(By.xpath(
                "//p[text()='You have done a dynamic click']")).isEmpty();
        webDriver.quit();

        if (isHaveClickMeText&&isHaveDoubleClickText&&isHaveRightClickText){
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }

    public static void exerciseSecond(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eshnyagina\\IdeaProjects\\at-lectures-7\\src\\test\\chromedriver\\chromedriver.exe");
        WebDriver webDriver= new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait webDriverWait= new WebDriverWait(webDriver, Duration.ofSeconds(7));
        webDriver.get("https://demoqa.com/alerts");

        WebElement alertButton=webDriver.findElement(By.id("alertButton"));
        WebElement alertTimerButton = webDriver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));

        alertButton.click();
        webDriver.switchTo()
                .alert().accept();

        alertTimerButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent())
                .accept();


        confirmButton.click();
        webDriver.switchTo()
                .alert().dismiss();

        boolean isHaveText = !webDriver.findElements(By.xpath(
                "//span[contains(., 'Cancel')]")).isEmpty();
        webDriver.quit();

        if (isHaveText){
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }

    }
}


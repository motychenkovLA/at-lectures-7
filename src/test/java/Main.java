import Page.AlertClick;
import Page.ButtonClick;
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

        ButtonClick buttonClick = new ButtonClick(chromeDriver);
        buttonClick.clickOnButtons();
        if (buttonClick.doneClick()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
        chromeDriver.quit();
    }

    public static void exerciseSecond() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        chromeDriver.get("https://demoqa.com/alerts");

        AlertClick alertClick = new AlertClick(chromeDriver);
        alertClick.clickOnAlerts();
        if (alertClick.cancelIsSelected()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
        chromeDriver.quit();
    }
}

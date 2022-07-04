package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.page.AlertPage;
import selenium.page.ButtonPage;
import selenium.page.WindowPage;

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
        WebDriver driver = new ChromeDriver();
        ButtonPage page = new ButtonPage(driver);
        page.allBtnClick();
        boolean result = page.pageIsHaveText("You have done a double click")
                && page.pageIsHaveText("You have done a right click")
                && page.pageIsHaveText("You have done a dynamic click");
        driver.quit();
        if (result) {
            System.out.println("Тест 1 пройден");

        } else System.out.println("Тест 1 не пройден");
    }


    public static void exerciseSecond() {
        WebDriver driver = new ChromeDriver();
        AlertPage page = new AlertPage(driver);
        page.allBtnClick();
        if (page.pageIsHaveText("Cancel")) {
            System.out.println("Тест 2 пройден");

        } else System.out.println("Тест 2 не пройден");
        driver.quit();


    }

    public static void exerciseThird() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WindowPage page = new WindowPage(driver);
        String firstWindowDescriptor = driver.getWindowHandle();
        page.tabBtnClick();
        Set<String> descriptors = driver.getWindowHandles();
        descriptors.remove(firstWindowDescriptor);
        Iterator<String> iterator = descriptors.iterator();
        String secondWindowDescriptor = iterator.next();
        driver.switchTo().window(secondWindowDescriptor);
        driver.get("https://google.com");
        driver.switchTo().window(firstWindowDescriptor);
        driver.quit();

    }
}




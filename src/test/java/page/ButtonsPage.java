package page;

import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ButtonsPage {

    static WebDriver webDriver;
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By doubleClickButtonMessageText = By.id("doubleClickMessage");
    private final String url = "https://demoqa.com/buttons";

    public ButtonsPage() {}

    public ButtonsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Тогда("пользователь заходит на страницу с кнопками")
    public void openButtonsPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(url);
    }

    @Тогда("пользователь нажимает кнопку \"Double Click Me\"")
    public void DoubleClickButton() {
        WebElement button = webDriver.findElement(doubleClickButton);
        new Actions(webDriver)
                .doubleClick(button)
                .build()
                .perform();
    }

    @Тогда("на экране отобразилось текстовое сообщение")
    public boolean isDoubleClickMessageEmpty() {
        return !webDriver.findElements(doubleClickButtonMessageText).isEmpty();
    }

    @Тогда("пользователь закрывает страницу с кнопками")
    public void close() {
        webDriver.quit();
    }

}
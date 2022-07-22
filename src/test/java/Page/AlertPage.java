package Page;

import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertPage {
    ChromeDriver chromeDriver;
    private static final By alertBtn = By.id("alertButton");

    public AlertPage() {
    }

    public AlertPage(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    @Тогда("пользователь переходит на сайт {string}")
    public void enterSite(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        chromeDriver.get(url);
    }

    @Тогда("пользователь вызывает алерт")
    public void clickOnAlert() {
        WebElement alertButton = chromeDriver.findElement(alertBtn);
        alertButton.click();
        chromeDriver.switchTo()
                .alert()
                .accept();
    }

    @Тогда("окно браузера закрывается")
    public void closeSite() {
        chromeDriver.quit();
    }
}

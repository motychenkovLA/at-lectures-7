package Page;

import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ButtonPage {
    ChromeDriver chromeDriver;
    private static final By clickMe = By.xpath("//button[text()='Click Me']");
    private static final By clickMeText = By.xpath("//p[text()='You have done a dynamic click']");

    public ButtonPage() {
    }

    public ButtonPage(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    @Тогда("пользователь заходит на сайт {string}")
    public void enterSite(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        chromeDriver.get(url);
    }

    @Тогда("пользователь нажимает на кнопку")
    public void clickOnButton() {
        WebElement clickMeBtn = chromeDriver.findElement(clickMe);
        new Actions(chromeDriver)
                .click(clickMeBtn)
                .build()
                .perform();

        boolean actual = !chromeDriver.findElements(clickMeText).isEmpty();
        Assert.assertEquals("Тест не пройден", true, actual);
    }

    @Тогда("браузер закрывается")
    public void closeSite() {
        chromeDriver.quit();
    }
}

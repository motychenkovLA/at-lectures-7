package cucumber.pages;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClickButton {
    private WebDriver webDriver;
    private By shouldClick = By.xpath("//p[text()='You have done a dynamic click']");

    @Когда("пользователь входит на страницу {string}")
    public void openDemoqa(String url) {
        webDriver = new ChromeDriver();
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @И("пользователь кликает по {string}")
    public void clickMe(String button) {
        WebElement clickButton = webDriver.findElement(By.xpath(button));
        clickButton.click();
    }

    @Тогда("проверка появления текста")
    public void shouldBeText() {
        String text = webDriver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals("You have done a dynamic click", text);

        boolean shouldClickText = !webDriver.findElements(shouldClick).isEmpty();
        assert shouldClickText;
//        Assert.assertTrue(shouldClickText);
    }

    @Тогда("браузер закрывается")
    public void closeWindows() {
        webDriver.quit();
    }
}

package cucumber.pages;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClickAlertButton {
    private WebDriver webDriver;

    @Когда("пользователь переходит на страницу {string}")
    public void openAlertDemoqa(String url) {
        webDriver = new ChromeDriver();
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @И("пользователь нажимает по {string}")
    public void clickMe(String button) {
        WebElement alertButton = webDriver.findElement(By.id(button));
        alertButton.click();
    }

    @Тогда("пользователь подтверждает действие на странице")
    public void clickAlertAccept() {
        webDriver.switchTo().alert().accept();
    }

    @Тогда("пользователь закрывает браузер")
    public void closeWindows() {
        webDriver.quit();
    }

}

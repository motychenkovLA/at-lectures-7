package selenium.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WindowPage {
    private static final By tabBtn = By.id("tabButton");
    private static final String url = "https://demoqa.com/browser-windows";
    WebDriver webDriver;

    public WindowPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //webDriver.get(url);
        CommonSteps.pageOpen(webDriver,url);
    }



@Step("Нажать tabButton")
    public void tabBtnClick() {
        webDriver.findElement(tabBtn).click();

    }

    @Step("Проверить, что открыта нужная страница")
    public boolean pageIsHaveBtn() {
        return (!webDriver.findElements(tabBtn).isEmpty());

    }
}

package selenium.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ButtonPage {
    private static final By doubleClickBtn = By.id("doubleClickBtn");
    private static final By rightClickBtn = By.id("rightClickBtn");
    private static final By clickMeBtn = By.xpath("//button[text()='Click Me']");
    private static final String url = "https://demoqa.com/buttons";
    WebDriver webDriver;

    public ButtonPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //webDriver.get(url);
        CommonSteps.pageOpen(webDriver, url);
    }

    public WebElement webElement(By by) {

        return (webDriver.findElement(by));
    }

    @Step("Нажать подряд три кнопки")
    public void allBtnClick() {

        new Actions(webDriver)
                .doubleClick(webElement(doubleClickBtn))
                .contextClick(webElement(rightClickBtn))
                .click(webElement(clickMeBtn))
                .build()
                .perform();
    }

    @Step("Найти на странице текст {text}")
    public boolean pageIsHaveText(String text) {
        return (!webDriver.findElements(By.xpath("//p[text()='" + text + "']")).isEmpty());
    }

}


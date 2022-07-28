package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Click {
    private static final By doubleClick = By.id("doubleClickBtn");
    private static final By rightClick = By.id("rightClickBtn");
    private static final By clickMe = By.xpath("//button[text()= 'Click Me']");
    private static final String url = "https://demoqa.com/buttons";
    private final WebDriver webDriver;

    public Click (WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(url);
    }

    public WebElement webElement(By by){

        return (webDriver.findElement(by));
    }

    public void allBtnClick() {

        new Actions(webDriver)
                .doubleClick(webElement(doubleClick))
                .contextClick(webElement(rightClick))
                .click(webElement(clickMe))
                .build()
                .perform();
    }

    public boolean pageIsHaveText(String text) {
//        webDriver.findElements();
        return (!webDriver.findElements(By.xpath("//p[text()='" + text + "']")).isEmpty());
    }

}
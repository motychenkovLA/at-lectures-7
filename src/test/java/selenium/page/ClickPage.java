package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ClickPage {
    private static final By doubleClickTextXpath = By.id("doubleClickBtn");
    private static final By rightClickTextXpath = By.id("rightClickBtn");
    private static final By clickTextXpath = By.xpath("//button[text()= 'Click Me']");
    private static final String url = "https://demoqa.com/buttons";
    private final WebDriver webDriver;

    public ClickPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(url);
    }

    public void allBtnClick() {
        WebElement doubleClickReal = webDriver.findElement(doubleClickTextXpath);
        WebElement rightClickReal = webDriver.findElement(rightClickTextXpath);
        WebElement clickMeReal = webDriver.findElement(clickTextXpath);
        new Actions(webDriver)
                .doubleClick(doubleClickReal)
                .contextClick(rightClickReal)
                .click(clickMeReal)
                .build()
                .perform();
    }

    public boolean isHaveDoubleClickText() {
        return !webDriver.findElements(doubleClickTextXpath).isEmpty();
    }

    public boolean isHaveRightClickText() {
        return !webDriver.findElements(rightClickTextXpath).isEmpty();
    }

    public boolean isHaveClickText() {
        return !webDriver.findElements(clickTextXpath).isEmpty();
    }

}
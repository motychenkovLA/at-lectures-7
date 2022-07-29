package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickPage {

    private final WebDriver driver;

    private static final By doubleClick = By.id("doubleClickBtn");
    private static final By rightClick = By.id("rightClickBtn");
    private static final By clickMe = By.xpath("//button[text()= 'Click Me']");

    private static final By doubleClickTextXpath = By.xpath("//p[text()='You have done a double click']");
    private static final By rightClickTextXpath = By.xpath("//p[text()='You have done a right click']");
    private static final By clickTextXpath = By.xpath("//p[text()='You have done a dynamic click']");


    public ClickPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AllClicks() {
        WebElement doubleClickBtn = driver.findElement(doubleClick);
        WebElement rightClickBtn = driver.findElement(rightClick);
        WebElement clickMeBtn = driver.findElement(clickMe);
        new Actions(driver)
                .doubleClick(doubleClickBtn)
                .contextClick(rightClickBtn)
                .click(clickMeBtn)
                .build()
                .perform();
    }

    public boolean isHaveDoubleClickText() {
        return !driver.findElements(doubleClickTextXpath).isEmpty();
    }

    public boolean isHaveRightClickText() {
        return !driver.findElements(rightClickTextXpath).isEmpty();
    }

    public boolean isHaveClickText() {
        return !driver.findElements(clickTextXpath).isEmpty();
    }
}

//репозиторий - хранилище зависимостей
//плагины - делают этапы
//пом надстройка над реальным помом
/**
 * пишешь комменты к методам и прочему - это джава док, ее делает site команда мавена
 */
package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Click {

    private final WebDriver driver;

    private static final By doubleClick = By.id("doubleClickBtn");
    private static final By rightClick = By.id("rightClickBtn");
    private static final By clickMe = By.xpath("//button[text()= 'Click Me']");

    private static final By doubleClickTextXpath = By.xpath("//p[text()='You have done a double click']");
    private static final By rightClickTextXpath = By.xpath("//p[text()='You have done a right click']");
    private static final By clickTextXpath = By.xpath("//p[text()='You have done a dynamic click']");

    public Click(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDoubleButton() {
        WebElement doubleClickReal = driver.findElement(doubleClick);
        new Actions(driver)
                .doubleClick(doubleClickReal)
                .build()
                .perform();
    }

    public void clickRightButton() {
        WebElement rightClickReal = driver.findElement(rightClick);
        new Actions(driver)
                .contextClick(rightClickReal)
                .build()
                .perform();
    }

    public void clickMe() {
        WebElement clickMeReal = driver.findElement(clickMe);
        new Actions(driver)
                .click(clickMeReal)
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
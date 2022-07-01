package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickOnButtons {

    private final WebDriver driver;

    private static final By doubleClick = By.id("doubleClickBtn");
    private static final By rightClick = By.id("rightClickBtn");
    private static final By clickMe = By.xpath("//button[text()= 'Click Me']");

    private static final By doubleClickTextXpath = By.xpath("//p[text()='You have done a double click']");
    private static final By rightClickTextXpath = By.xpath("//p[text()='You have done a right click']");
    private static final By clickTextXpath = By.xpath("//p[text()='You have done a dynamic click']");


    public ClickOnButtons(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDoubleButton() {
        WebElement doubleClick1 = driver.findElement(doubleClick);
        new Actions(driver)
                .doubleClick(doubleClick1)
                .build()
                .perform();
    }

    public void clickRightButton() {
        WebElement rightClick1 = driver.findElement(rightClick);
        new Actions(driver)
                .contextClick(rightClick1)
                .build()
                .perform();
    }

    public void clickMe() {
        WebElement clickMe1 = driver.findElement(clickMe);
        new Actions(driver)
                .click(clickMe1)
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


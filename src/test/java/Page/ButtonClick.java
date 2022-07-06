package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonClick {
    ChromeDriver chromeDriver;
    private static final By doubleClick = By.id("doubleClickBtn");
    private static final By rightClick = By.id("rightClickBtn");
    private static final By click = By.xpath("//button[text()='Click Me']");
    private static final By doubleClickText = By.xpath("//p[text()='You have done a double click']");
    private static final By rightClickText = By.xpath("//p[text()='You have done a right click']");
    private static final By clickText = By.xpath("//p[text()='You have done a dynamic click']");

    public ButtonClick(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public void clickOnButtons() {
        WebElement doubleClickBtn = chromeDriver.findElement(doubleClick);
        WebElement rightClickBtn = chromeDriver.findElement(rightClick);
        WebElement clickMeBtn = chromeDriver.findElement(click);
        new Actions(chromeDriver)
                .doubleClick(doubleClickBtn)
                .contextClick(rightClickBtn)
                .click(clickMeBtn)
                .build()
                .perform();
    }

    public void doneClick() {
        boolean doneDoubleClick = !chromeDriver.findElements(doubleClickText).isEmpty();
        boolean doneRightClick = !chromeDriver.findElements(rightClickText).isEmpty();
        boolean doneClickMe = !chromeDriver.findElements(clickText).isEmpty();
        if (doneDoubleClick && doneRightClick && doneClickMe) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }



}

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
        boolean doneDoubleClick = !chromeDriver.findElements(By.xpath("//p[text()='You have done a double click']"))
                .isEmpty();
        boolean doneRightClick = !chromeDriver.findElements(By.xpath("//p[text()='You have done a right click']"))
                .isEmpty();
        boolean doneClickMe = !chromeDriver.findElements(By.xpath("//p[text()='You have done a dynamic click']"))
                .isEmpty();
        if (doneDoubleClick && doneRightClick && doneClickMe) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }



}

package Page;

import io.qameta.allure.Step;
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

    @Step("Нажать на кнопки")
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

    @Step("Проверка появления текста")
    public boolean doneClick() {
        boolean doneDoubleClick = !chromeDriver.findElements(doubleClickText).isEmpty();
        boolean doneRightClick = !chromeDriver.findElements(rightClickText).isEmpty();
        boolean doneClickMe = !chromeDriver.findElements(clickText).isEmpty();
        return doneDoubleClick && doneRightClick && doneClickMe;
    }
}

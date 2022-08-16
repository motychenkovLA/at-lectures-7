package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickButton {

    private static WebDriver webDriver;
    private By doubleClickText = By.xpath("//button[.='Double Click Me']");
    private By contextClickText = By.xpath("//button[.='Right Click Me']");
    private By clickText = By.xpath("//button[.='Click Me']");

    private By shouldDoubleClick = By.xpath("//p[text()='You have done a double click']");
    private By shouldRightClick = By.xpath("//p[text()='You have done a right click']");
    private By shouldClick = By.xpath("//p[text()='You have done a dynamic click']");

    public ClickButton(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие страницы")
    public void openDemoqa() {
        webDriver.get("https://demoqa.com/buttons");
    }

    @Step("Клик по кнопкам")
    public void clickAll() {
        WebElement doubleClick = webDriver.findElement(doubleClickText);
        WebElement contextClick = webDriver.findElement(contextClickText);
        WebElement click = webDriver.findElement(clickText);

        new Actions(webDriver)
//                .doubleClick(doubleClick)
//                .contextClick(contextClick)
                .click(click)
                .build()
                .perform();
    }

    @Step("Проверка")
    public boolean isText() {
        boolean shouldDoubleClickText = !webDriver.findElements(shouldDoubleClick).isEmpty();
        boolean shouldRightClickText = !webDriver.findElements(shouldRightClick).isEmpty();
        boolean shouldClickText = !webDriver.findElements(shouldClick).isEmpty();

        return shouldDoubleClickText && shouldRightClickText && shouldClickText;
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickButton {

    private static WebDriver webDriver;
    private By doubleClickText = By.xpath("//button[.='Double Click Me']");
    private By contextClickText = By.xpath("//button[.='Right Click Me']");
    private By clickText = By.xpath("//button[.='Click Me']");

    private By shouldDoubleClickText = By.xpath("//p[text()='You have done a double click']");
    private By shouldRightClickText = By.xpath("//p[text()='You have done a right click']");
    private By shouldClickText = By.xpath("//p[text()='You have done a dynamic click']");

    public ClickButton(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openDemoqa() {
        webDriver.get("https://demoqa.com/buttons");
    }

    public void clickAll() {
        WebElement doubleClick = webDriver.findElement(doubleClickText);
        WebElement contextClick = webDriver.findElement(contextClickText);
        WebElement click = webDriver.findElement(clickText);

        new Actions(webDriver)
                .doubleClick(doubleClick)
                .contextClick(contextClick)
                .click(click)
                .build()
                .perform();
    }

        public boolean isText() {
            boolean shouldDoubleClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
            boolean shouldRightClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
            boolean shouldClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();

            return shouldDoubleClickText && shouldRightClickText && shouldClickText;
        }
}

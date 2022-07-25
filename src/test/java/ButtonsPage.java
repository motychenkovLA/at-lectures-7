import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {

    private final WebDriver webDriver;
    private final By buttonClickMe = By.xpath("//button[text() = \"Click Me\"]");
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By rightMouseButtonClick = By.id("rightClickBtn");
    private final By doubleClickButtonMessageText = By.id("doubleClickMessage");
    private final By rightMouseClickMessageText = By.id("rightClickMessage");
    private final By leftMouseClickMessageText = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    public void open() {
//        String urlPageWithButtons = "https://demoqa.com/buttons";
//        webDriver.get(urlPageWithButtons);
//    }

    public void DoubleClickButton() {
        WebElement button = webDriver.findElement(doubleClickButton);
        new Actions(webDriver)
                .doubleClick(button)
                .build()
                .perform();
    }

    public void RightMouseButtonClick() {
        WebElement button = webDriver.findElement(rightMouseButtonClick);
        new Actions(webDriver)
                .contextClick(button)
                .build()
                .perform();
    }

    public void LeftMouseButtonClick() {
        WebElement button = webDriver.findElement(buttonClickMe);
        new Actions(webDriver)
                .click(button)
                .build()
                .perform();
    }


    public boolean isDoubleClickMessageEmpty() {
        return !webDriver.findElements(doubleClickButtonMessageText).isEmpty();
    }

    public boolean isRightMouseClickMessageEmpty() {
        return !webDriver.findElements(rightMouseClickMessageText).isEmpty();
    }

    public boolean isLeftMouseClickMessageEmpty() {
        return !webDriver.findElements(leftMouseClickMessageText).isEmpty();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class TransitionWindows {

    private WebDriver webDriver;

    private By tabButtonElement = By.id("tabButton");


    public TransitionWindows(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openDemoqaWindows() {
        webDriver.get("https://demoqa.com/browser-windows");
    }

    public void clickTabButton() {

        WebElement tabButton = webDriver.findElement(tabButtonElement);
        new Actions(webDriver)
                .click(tabButton)
                .build()
                .perform();
    }

    public void transitionWindows() throws InterruptedException {
        List<String> description = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(description.get(1));
        webDriver.get("https://google.com");

        Thread.sleep(2000);
        webDriver.switchTo().window(description.get(0));
    }
}

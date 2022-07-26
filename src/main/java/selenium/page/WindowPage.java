package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WindowPage {
    private static final By tabBtn = By.id("tabButton");
    private static final String url = "https://demoqa.com/browser-windows";
    WebDriver webDriver;

    public WindowPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(url);
    }

    public void tabBtnClick() {
        webDriver.findElement(tabBtn).click();

    }

    public boolean pageIsHaveBtn(){
        return (!webDriver.findElements(tabBtn).isEmpty());

    }
}

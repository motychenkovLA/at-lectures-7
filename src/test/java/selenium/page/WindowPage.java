package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WindowPage {
    private static final By tabBtn = By.id("tabButton");
    private static final String url = "https://demoqa.com/browser-windows";
    WebDriver driver;

    public WindowPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    public void tabBtnClick() {
        driver.findElement(tabBtn).click();

    }

    public boolean pageIsHaveBtn(){
        return (!driver.findElements(tabBtn).isEmpty());

    }
}
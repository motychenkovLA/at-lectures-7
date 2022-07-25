import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowsPage {
    private final WebDriver webDriver;
    private final By newTabButton = By.id("tabButton");

    public BrowserWindowsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    public void open(){
//        String urlPageWithWindows = "https://demoqa.com/browser-windows";
//        webDriver.get(urlPageWithWindows);
//    }

    public void openOtherPageInNewTab(String newPage) {

        WebElement button = webDriver.findElement(newTabButton);
        button.click();
        String demoWindowDescriptor = webDriver.getWindowHandle();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoWindowDescriptor);

        Iterator<String> iterator = handles.iterator();
        String newTab = iterator.next();

        webDriver.switchTo()
                .window(newTab);
        webDriver.get(newPage);

    }

    public boolean atPage(String titleOfPage) {
        return webDriver.getTitle().equals(titleOfPage);
    }

}

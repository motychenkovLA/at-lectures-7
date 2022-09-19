//import io.qameta.allure.Step;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.Iterator;
//import java.util.Set;
//
//public class BrowserWindowsPage {
//    private final WebDriver webDriver;
//    private final By newTabButton = By.id("tabButton");
//
//    public BrowserWindowsPage(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//    @Step("Переключение между страницами браузера")
//    public void openOtherPageInNewTab(String newPage) {
//
//        WebElement button = webDriver.findElement(newTabButton);
//        button.click();
//        String demoWindowDescriptor = webDriver.getWindowHandle();
//
//        Set<String> handles = webDriver.getWindowHandles();
//        handles.remove(demoWindowDescriptor);
//
//        Iterator<String> iterator = handles.iterator();
//        String newTab = iterator.next();
//
//        webDriver.switchTo()
//                .window(newTab);
//        webDriver.get(newPage);
//
//    }
//    @Step("Проверка url-адреса страницы")
//    public boolean atPage(String titleOfPage) {
//        return webDriver.getTitle().equals(titleOfPage);
//    }
//
//}

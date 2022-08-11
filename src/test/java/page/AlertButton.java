package page;

//import io.cucumber.java.ru.Тогда;
//import io.qameta.allure.Step;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class AlertButton {
//
//    static WebDriver webDriver;
//    private final By textCancel = By.xpath("//span[contains(., 'Cancel')]");
//    private final By alertButton = By.xpath("//button[@id = \"alertButton\"]");
//    private final By timerAlertButton = By.xpath("//button[@id = \"timerAlertButton\"]");
//    private final By confirmButton = By.xpath("//button[@id = \"confirmButton\"]");
//    private final String alertPageUrl = "https://demoqa.com/alerts";
//
//
//    public AlertButton() {}
//    public AlertButton(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//
//    @Тогда("пользователь заходит на страницу с алертами")
//    public void openAlertPage() {
//        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
//        webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        webDriver.get(alertPageUrl);
//    }
//
//
//    @Тогда("пользователь нажимает первую кнопку")
//    public void clickButtonAlert() {
//        WebElement button = webDriver.findElement(alertButton);
//        button.click();
//    }
//
//    @Тогда("пользователь принимает алерт")
//    public void acceptAlert() {
//        webDriver.switchTo().alert().accept();
//    }
//
//
//    @Тогда("пользователь нажимает третью кнопку")
//    public void ClickConfirmAlertAndAccept() {
//        WebElement button = webDriver.findElement(confirmButton);
//        button.click();
//    }
//
//    @Тогда("пользователь отклоняет алерт")
//    public void dismissAlert() {
//        webDriver.switchTo().alert().dismiss();
//    }
//
//    @Тогда("на экране отобразилось текстовое сообщение \"You selected Cancel\"")
//    public boolean isEmpty() {
//        return !webDriver.findElements(textCancel)
//                .isEmpty();
//    }
//
//    @Тогда("пользователь закрывает страницу с алертами")
//    public void close() {
//        webDriver.quit();
//    }
//
//}

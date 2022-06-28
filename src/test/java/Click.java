import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Click {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");
        webDriver.quit();
    }
}

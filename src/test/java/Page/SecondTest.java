package Page;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.Timeout;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SecondTest {

    ChromeDriver driver;

    @Rule
    public Timeout testTimeout = Timeout.seconds(180);

    @Step("Пользователь открывает браузер")
    @Before
    public void BeforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @Step("Пользователь закрывает браузер")
    @After
    public void afterMethod() {
        driver.quit();
    }

    @DisplayName("Тест №2")
    @Step("Происходит выполнение теста")
    @Category(TestLibrary.class)
    @Test
    public void secondTest() {
        driver.get("https://demoqa.com/alerts");

        AlertPage alertPage = new AlertPage(driver);
        alertPage.clickAlertButton();
        alertPage.clickTimerAlertButton();
        alertPage.clickConfirmButton();
        Assert.assertTrue("Тест провален!", alertPage.isEmpty());


    }


}

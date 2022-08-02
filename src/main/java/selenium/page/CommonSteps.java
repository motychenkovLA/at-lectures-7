package selenium.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    @Step("Открыть сайт {url}")
    public static void pageOpen(WebDriver driver, String url) {
        driver.get(url);
    }

    @Step("Переключиться на вкладку")
    public static void focusTo(WebDriver driver, String descriptor) {
        driver.switchTo().window(descriptor);

    }

}

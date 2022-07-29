package Page;
import Page.ClickPage;
import Page.AlertPage;
import com.google.common.annotations.VisibleForTesting;
import org.checkerframework.checker.fenum.qual.AwtAlphaCompositingRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@RunWith(Categories.class)
@Categories.IncludeCategory(TestLibrary.class)
@Suite.SuiteClasses({FirstTest.class, SecondTest.class})
public class Main {





}
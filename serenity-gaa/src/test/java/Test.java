import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/features/Pay.feature",
        glue = {"com.test.toolbox"})

public class Test {
    @Managed
    WebDriver driver;
}

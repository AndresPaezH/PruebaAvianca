package runners;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import cucumber.api.SnippetType;
import utils.BeforeSuite;
import utils.DataToFeature;
import cucumber.api.CucumberOptions;





@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
features = "src/test/resources/features/Vuelos.feature"
,glue = "definitions"
,tags = "@tag1"
,monochrome = true
,snippets = SnippetType.CAMELCASE
)
public class MainRunner {

	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}

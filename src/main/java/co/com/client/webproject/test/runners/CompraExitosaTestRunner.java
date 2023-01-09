package co.com.client.webproject.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// TODO: configuracion y renombramiento del TestRunner (glue, feature, plugins)

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = {"src/main/resources/features/compraExitosa.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.compraexitosa"},
        tags = {""}
)
public class CompraExitosaTestRunner {

}

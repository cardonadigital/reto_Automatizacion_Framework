package co.com.client.webproject.test.helpers;

import co.com.sofka.test.evidence.reports.Report;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import static co.com.client.webproject.test.helpers.Dictionary.CONFIGURATION_PROPERTIES_FILE;
import static co.com.client.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static co.com.client.webproject.test.helpers.Dictionary.SPACE_STRING;
import static co.com.client.webproject.test.helpers.Dictionary.STATE_BY_DEFAULT_FLORIDA;

public class Helper {

    private Helper() {
    }

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(CONFIGURATION_PROPERTIES_FILE)) {
            properties.load(fileReader);
        } catch (IOException e) {
            Report.reportFailure("Fallo al consultar una propiedad del archivo "
                    + CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }


}

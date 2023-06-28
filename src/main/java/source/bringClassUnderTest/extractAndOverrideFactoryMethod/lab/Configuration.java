package source.bringClassUnderTest.extractAndOverrideFactoryMethod.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public static String getConnectionString() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            return properties.getProperty("TransactionDatabase");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // or handle the case when configuration is not available
    }
}

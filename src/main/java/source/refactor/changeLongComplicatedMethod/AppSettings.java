package source.refactor.changeLongComplicatedMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppSettings {
    public static String getConnectionString() throws IOException {
    	
        Properties properties = new Properties();
        InputStream input = new FileInputStream("config.properties");
        properties.load(input);
        return properties.getProperty("Database");
    }
}

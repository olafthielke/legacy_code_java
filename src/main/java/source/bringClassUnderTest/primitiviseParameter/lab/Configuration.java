package source.bringClassUnderTest.primitiviseParameter.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public static String getNzPostApiKey() {
		Properties properties = new Properties();
	    try {
	        FileInputStream fileInputStream = new FileInputStream("config.properties");
	        properties.load(fileInputStream);
	        fileInputStream.close();
	    } catch (IOException e) {
	        return null;
	    }
	
	    return properties.getProperty("API_KEY");
	}
}

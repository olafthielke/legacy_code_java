package source.bringClassUnderTest.primitiviseParameter.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfigManager {

	public static String getConnString() {
		Properties properties = new Properties();
	    try {
	        FileInputStream fileInputStream = new FileInputStream("config.properties");
	        properties.load(fileInputStream);
	        fileInputStream.close();
	    } catch (IOException e) {
	        return null;
	    }
	
	    return properties.getProperty("ConnectionStrings");
	}
}

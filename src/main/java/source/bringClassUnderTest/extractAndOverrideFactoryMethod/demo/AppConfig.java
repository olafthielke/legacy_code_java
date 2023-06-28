package source.bringClassUnderTest.extractAndOverrideFactoryMethod.demo;

import java.math.BigDecimal;

public class AppConfig {
    public static BigDecimal getCorrelationSensitivity() {
        return new BigDecimal("1.33"); 	// dummy value
    }

    public static String getConnectionString() {
        return "connection string"; 	// dummy value
    }
}

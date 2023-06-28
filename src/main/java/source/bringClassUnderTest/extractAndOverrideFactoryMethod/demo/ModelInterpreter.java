package source.bringClassUnderTest.extractAndOverrideFactoryMethod.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.math.BigDecimal;

public class ModelInterpreter {
    private String readings;

    public ModelInterpreter(BigDecimal correlationSensitivity) throws IOException {
        int senValue = correlationSensitivity.multiply(BigDecimal.valueOf(1000)).intValue();
        String filePath = String.format("./models/cal_sen_%d.json", senValue);
        readings = Files.readString(Paths.get(filePath));
        
        // ...
    }
}

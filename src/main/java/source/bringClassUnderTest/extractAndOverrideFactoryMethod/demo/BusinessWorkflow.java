package source.bringClassUnderTest.extractAndOverrideFactoryMethod.demo;

import java.io.IOException;
import java.sql.SQLException;

public class BusinessWorkflow {
	
    private MainWorkflowOrchestrator orchestrator;

    public BusinessWorkflow() throws IOException, SQLException {
    	
        ModelInterpreter interpreter = new ModelInterpreter(AppConfig.getCorrelationSensitivity());

        SqlCustomerDatabase customerDatabase = new SqlCustomerDatabase(AppConfig.getConnectionString());

        MainWorkflowOrchestrator orchestrator = new MainWorkflowOrchestrator(interpreter, customerDatabase);
        
        orchestrator.init("STATUS_ACTIVE");

        // ...
    }
}

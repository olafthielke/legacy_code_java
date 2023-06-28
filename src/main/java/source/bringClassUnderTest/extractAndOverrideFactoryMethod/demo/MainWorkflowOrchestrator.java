package source.bringClassUnderTest.extractAndOverrideFactoryMethod.demo;

public class MainWorkflowOrchestrator {
	
    private ModelInterpreter interpreter;
    private SqlCustomerDatabase customerDb;

    public MainWorkflowOrchestrator(ModelInterpreter interpreter, SqlCustomerDatabase customerDb) {
        this.interpreter = interpreter;
        this.customerDb = customerDb;
    }

    public void init(String status) {
        // ...
    }
}
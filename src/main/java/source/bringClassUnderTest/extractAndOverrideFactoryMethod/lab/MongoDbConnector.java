package source.bringClassUnderTest.extractAndOverrideFactoryMethod.lab;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDbConnector {
    private MongoClient dbClient;

    public MongoDbConnector(String connString) {
    	
        MongoClientURI uri = new MongoClientURI(connString);
        dbClient = new MongoClient(uri);

        // ...
    }

    
	public int saveTx(MongoDbTransaction tx) {
    	
        // ...

        return SuccessCode.Success.ordinal();
    }
}

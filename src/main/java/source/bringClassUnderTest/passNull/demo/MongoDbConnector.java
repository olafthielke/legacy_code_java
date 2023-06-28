package source.bringClassUnderTest.passNull.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;

public class MongoDbConnector {
    public MongoDbConnector(String connString) {
        MongoClient dbClient = new MongoClient(connString);

        MongoCursor<String> dbList = dbClient.listDatabaseNames().iterator();

        // ...
        
        dbClient.close();
    }
}
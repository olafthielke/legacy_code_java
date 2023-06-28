package source.bringClassUnderTest.passNull.lab;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private MongoClient dbClient;

    public OrderService(int config) {
        if (config == 0) {
            dbClient = MongoClients.create("Production Connection String");
        } else if (config == 2) {
            dbClient = MongoClients.create("Staging Connection String");
        } else {
            dbClient = MongoClients.create("Development Connection String");
        }
    }

    public int initialise() {
        List<String> dbList = dbClient.listDatabaseNames().into(new ArrayList<String>());

        // ...

        return -1;
    }

    public void prepopulate() {
        // ...
    }
}

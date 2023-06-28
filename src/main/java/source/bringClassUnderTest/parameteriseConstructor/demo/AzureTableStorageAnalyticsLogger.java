package source.bringClassUnderTest.parameteriseConstructor.demo;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;

public class AzureTableStorageAnalyticsLogger implements AnalyticsLogger {
    private static String storageconn = "DefaultEndpointsProtocol=https;AccountName=blah;AccountKey=helloworld==;EndpointSuffix=core.windows.net";
    private static String table1 = "Customer";
    private static String partitionkey = "CustIdentifier";
    private static String rowKey = "guid";

    public AzureTableStorageAnalyticsLogger() throws StorageException, InvalidKeyException, URISyntaxException {
        // Logs to Azure Table Storage

        CloudStorageAccount storageAcc = CloudStorageAccount.parse(storageconn);
        CloudTableClient tblclient = storageAcc.createCloudTableClient();
        CloudTable table = tblclient.getTableReference(table1);
        table.createIfNotExists();
    }

    public boolean Log(String message, int severity) {
        // ...

        return true;
    }
}

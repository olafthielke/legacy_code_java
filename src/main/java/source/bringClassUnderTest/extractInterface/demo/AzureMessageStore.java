package source.bringClassUnderTest.extractInterface.demo;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;


public class AzureMessageStore {
	
    private static final String TblName = "notifications";

    public AzureMessageStore() {
    }

	public void init(String status, int bucketId) throws StorageException, InvalidKeyException, URISyntaxException {
        if (status.toUpperCase().equals("ACTIVE")) {
            String connString = String.format("DefaultEndpointsProtocol=https;AccountName=acc-%d;AccountKey=notifications==;EndpointSuffix=blah.windows.net", bucketId);
            CloudStorageAccount bucketAcc = CloudStorageAccount.parse(connString);
            CloudTableClient cli = bucketAcc.createCloudTableClient();
            CloudTable tbl = cli.getTableReference(TblName);
            tbl.createIfNotExists();
        }
    }
}

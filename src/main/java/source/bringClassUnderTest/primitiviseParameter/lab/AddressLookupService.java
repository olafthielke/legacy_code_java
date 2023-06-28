package source.bringClassUnderTest.primitiviseParameter.lab;

import java.util.concurrent.CompletableFuture;

public class AddressLookupService {
    private NzPostAddressLookupClient addressClient;
    
    public AddressLookupService() {
        String apiKey = Configuration.getNzPostApiKey();
        String[] apiKeys = apiKey.split(":");

        this.addressClient = new NzPostAddressLookupClient();
        
        this.addressClient.setApiClientId(apiKeys[0]);
        this.addressClient.setApiClientSecret(apiKeys[1]);

        // ...
    }

    // Want to make changes in this method!
    public CompletableFuture<String> lookupAddress(String addressFragment) {
        // ...

        // Makes a call to addressClient to look up addressFragment.
        CompletableFuture<String> addressFuture = addressClient.lookupAddress(addressFragment);

        // ...

        return addressFuture;
    }
}

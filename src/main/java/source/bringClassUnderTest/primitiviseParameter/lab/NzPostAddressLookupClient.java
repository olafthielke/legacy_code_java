package source.bringClassUnderTest.primitiviseParameter.lab;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.concurrent.CompletableFuture;

public class NzPostAddressLookupClient {
    private String apiClientId;
    private String apiClientSecret;
    private HttpClient client = HttpClient.newHttpClient();
    
    private static final String addressFinderUrl = "https://not-real-api.nzpost.co.nz/addressfinder/";

    public NzPostAddressLookupClient() {
        // This is made up. The point here is that this constructor 
        // makes a call to a remote service and therefore this class
        // should be side-stepped by our class instantiating it.
        // Will make any test SLOW, FRAGILE, and an INTEGRATION TEST. AVOID.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(addressFinderUrl))
                .build();

        CompletableFuture<String> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String response = responseFuture.join();

        // Say, we need to check the response for some OK type result.
    }

    
	public CompletableFuture<String> lookupAddress(String addressFragment) {
        // Call the NZ Post Address lookup service.
        
        return CompletableFuture.completedFuture(null);
    }

	public String getApiClientId() {
		return apiClientId;
	}

	public void setApiClientId(String apiClientId) {
		this.apiClientId = apiClientId;
	}

	public String getApiClientSecret() {
		return apiClientSecret;
	}

	public void setApiClientSecret(String apiClientSecret) {
		this.apiClientSecret = apiClientSecret;
	}
}

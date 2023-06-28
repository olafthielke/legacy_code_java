package source.bringClassUnderTest.extractInterface.lab;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Base64;

public class PaypalMoneyTransfer {
    private Currency currency;
    private Currency transactionCurrency;
    private int payWindow;

	public PaypalAccessToken configurePaypal(boolean isProd, int paymentWindow, String status) throws URISyntaxException, IOException {
        //_transactionCurrency = txCurrency;
        //_payWindow = paymentWindow;

        String sandbox = "https://api.sandbox.paypal.com";
        String production = "https://api.paypal.com";

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder;
        if (isProd) {
            uriBuilder = new URIBuilder(production + "/v1/oauth2/token");
            httpClient.getParams().setParameter(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("Kk97b1iibQ9iZuwYTbyK:19s6HCaQHjKfbkG90yit".getBytes()));
        } else {
            uriBuilder = new URIBuilder(sandbox + "/v1/oauth2/token");
            httpClient.getParams().setParameter(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("Kk97b1iibQ9iZuwYTbyK:19s6HCaQHjKfbkG90yit".getBytes()));
        }

        HttpPost request = new HttpPost(uriBuilder.build());
        request.setEntity(new StringEntity("grant_type=client_credentials"));
        request.setHeader(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded"));

        HttpResponse response = httpClient.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Failed to obtain PayPal access token");
        }

        String responseBody = EntityUtils.toString(response.getEntity());

        Gson gson = new Gson();
        PaypalAccessToken accessToken = gson.fromJson(responseBody, PaypalAccessToken.class);
        return accessToken;
    }
}


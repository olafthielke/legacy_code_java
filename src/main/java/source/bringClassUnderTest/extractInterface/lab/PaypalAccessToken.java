package source.bringClassUnderTest.extractInterface.lab;

import com.google.gson.annotations.SerializedName;

public class PaypalAccessToken {

    @SerializedName("scope")
    private String scope;

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("nonce")
    private String nonce;

    // Getters and setters
}
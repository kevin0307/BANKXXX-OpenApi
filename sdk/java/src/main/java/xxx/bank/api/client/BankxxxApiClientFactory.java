package xxx.bank.api.client;

import xxx.bank.api.client.constant.BankxxxConstants;
import xxx.bank.api.client.impl.BankxxxApiRestClientImpl;
import xxx.bank.api.client.impl.BankxxxApiWebSocketClientImpl;
import xxx.bank.api.client.impl.BankxxxOptionApiRestClientImpl;

import static xxx.bank.api.client.impl.BankxxxApiServiceGenerator.getSharedClient;

/**
 * A factory for creating BankxxxApi client objects.
 */
public final class BankxxxApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    private String baseUrl = BankxxxConstants.API_BASE_URL;

    /**
     * Instantiates a new Bankxxx api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BankxxxApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    private BankxxxApiClientFactory(String baseUrl, String apiKey, String secret) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the Bankxxx api client factory
     */
    public static BankxxxApiClientFactory newInstance(String apiKey, String secret) {
        return new BankxxxApiClientFactory(apiKey, secret);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param baseUrl
     * @param apiKey
     * @param secret
     * @return
     */
    public static BankxxxApiClientFactory newInstance(String baseUrl, String apiKey, String secret) {
        return new BankxxxApiClientFactory(baseUrl, apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @return the Bankxxx api client factory
     */
    public static BankxxxApiClientFactory newInstance() {
        return new BankxxxApiClientFactory(null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BankxxxApiRestClient newRestClient() {
        return new BankxxxApiRestClientImpl(baseUrl, apiKey, secret);
    }


    public BankxxxApiWebSocketClient newWebSocketClient() {
        return new BankxxxApiWebSocketClientImpl(getSharedClient(), BankxxxConstants.WS_API_BASE_URL, BankxxxConstants.WS_API_USER_URL);
    }

    /**
     * for bhop.cloud client and inner test only
     *
     * @param wsApiBaseUrl
     * @param wsApiUserUrl
     * @return
     */
    public BankxxxApiWebSocketClient newWebSocketClient(String wsApiBaseUrl, String wsApiUserUrl) {
        return new BankxxxApiWebSocketClientImpl(getSharedClient(), wsApiBaseUrl, wsApiUserUrl);
    }

    /**
     * Creates a new synchronous/blocking Option REST client.
     */
    public BankxxxOptionApiRestClient newOptionRestClient() {
        return new BankxxxOptionApiRestClientImpl(baseUrl, apiKey, secret);
    }

}

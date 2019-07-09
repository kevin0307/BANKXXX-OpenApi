package xxx.bank.api.test;

import xxx.bank.api.client.BankxxxApiClientFactory;
import xxx.bank.api.client.BankxxxApiRestClient;
import xxx.bank.api.client.BankxxxApiWebSocketClient;
import xxx.bank.api.client.constant.BankxxxConstants;
import xxx.bank.api.test.constant.Constants;

//@Slf4j
public class UserDataStreamTest {

    public static void main(String[] args) {
//
        BankxxxApiWebSocketClient client = BankxxxApiClientFactory.newInstance().newWebSocketClient();
        BankxxxApiRestClient restClient = BankxxxApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY).newRestClient();

        System.out.println("\n ------Get Listen Key -----");
        System.out.println();
        String listenKey = restClient.startUserDataStream(BankxxxConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println("listenKey:" + listenKey);
        // order
        client.onUserEvent(listenKey, response -> System.out.println(response), true);

    }
}

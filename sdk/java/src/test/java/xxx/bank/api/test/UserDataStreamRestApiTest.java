package xxx.bank.api.test;

import xxx.bank.api.client.BankxxxApiClientFactory;
import xxx.bank.api.client.BankxxxApiRestClient;
import xxx.bank.api.client.constant.BankxxxConstants;
import xxx.bank.api.test.constant.Constants;

public class UserDataStreamRestApiTest {

    public static void main(String[] args) {

        BankxxxApiClientFactory factory = BankxxxApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        BankxxxApiRestClient client = factory.newRestClient();

        System.out.println("\n ------start user data stream-----");
        String listenKey = client.startUserDataStream(BankxxxConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println(listenKey);

        System.out.println("\n ------keepAlive user data stream-----");
        client.keepAliveUserDataStream(listenKey, BankxxxConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

        System.out.println("\n ------close user data stream-----");
        client.closeUserDataStream(listenKey, BankxxxConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

    }

}

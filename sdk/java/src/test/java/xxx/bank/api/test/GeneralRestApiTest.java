package xxx.bank.api.test;

import xxx.bank.api.client.BankxxxApiClientFactory;
import xxx.bank.api.client.BankxxxApiRestClient;
import xxx.bank.api.client.domain.general.BrokerInfo;

public class GeneralRestApiTest {

    public static void main(String[] args) {

        BankxxxApiClientFactory factory = BankxxxApiClientFactory.newInstance();
        BankxxxApiRestClient client = factory.newRestClient();

        System.out.println("\n ------BrokerInfo-----");
        BrokerInfo brokerInfo = client.getBrokerInfo();
        System.out.println(brokerInfo);

    }


}

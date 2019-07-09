package xxx.bank.api.test;

import java.util.Date;
import java.util.List;

import xxx.bank.api.client.BankxxxApiClientFactory;
import xxx.bank.api.client.BankxxxOptionApiRestClient;
import xxx.bank.api.client.domain.account.OrderSide;
import xxx.bank.api.client.domain.account.OrderType;
import xxx.bank.api.client.domain.account.TimeInForce;
import xxx.bank.api.client.domain.option.OptionMatchResult;
import xxx.bank.api.client.domain.option.OptionOrderResult;
import xxx.bank.api.client.domain.option.PositionResult;
import xxx.bank.api.client.domain.option.SettlementResult;
import xxx.bank.api.client.domain.option.TokenOptionResult;
import xxx.bank.api.client.domain.option.request.OptionHistoryOrderRequest;
import xxx.bank.api.client.domain.option.request.OptionOpenOrderRequest;
import xxx.bank.api.client.domain.option.request.OptionOrderRequest;
import xxx.bank.api.client.domain.option.request.OptionPositionRequest;
import xxx.bank.api.client.domain.option.request.OptionSettlementRequest;
import xxx.bank.api.client.domain.option.request.OptionTradeRequest;
import xxx.bank.api.client.domain.option.request.OptionsRequest;
import xxx.bank.api.test.constant.Constants;

public class OptionRestApiTest {

    public static void main(String[] args) {
        BankxxxApiClientFactory factory = BankxxxApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        BankxxxOptionApiRestClient client = factory.newOptionRestClient();

        System.out.println("\n ------get options-----");

        List<TokenOptionResult> results
                = client.getOptions(OptionsRequest.builder().expired(Boolean.FALSE).build());

        System.out.println(results);

        System.out.println("\n ------new option order-----");
        OptionOrderResult optionOrderResult =
                client.newOptionOrder(OptionOrderRequest
                        .builder()
                        .symbol("BTC0226CS4000")
                        .price("10000")
                        .quantity("1")
                        .orderSide(OrderSide.BUY)
                        .orderType(OrderType.MARKET)
                        .clientOrderId(String.valueOf(new Date().getTime()))
                        .timeInForce(TimeInForce.GTC)
                        .timestamp(new Date().getTime())
                        .recvWindow(5_000L)
                        .build());
        System.out.println(optionOrderResult);
//
        System.out.println("\n ------new option order-----");
        List<PositionResult> positionResults
                = client.getOptionPositions(OptionPositionRequest
                .builder()
                .timestamp(new Date().getTime())
                .recvWindow(5_000L)
                .build());
        System.out.println(positionResults);

        System.out.println("\n ------new option settlement-----");
        List<SettlementResult> settlementResults
                = client.getOptionSettlements(OptionSettlementRequest.builder().timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(settlementResults);


        System.out.println("\n ------new option historyOrders-----");
        List<OptionOrderResult> optionOrderResults
                = client.getOptionHistoryOrders(OptionHistoryOrderRequest.builder().limit(10).timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(optionOrderResults);


        System.out.println("\n ------new option openOrders-----");
        List<OptionOrderResult> optionOpenOrders
                = client.getOptionOpenOrders(OptionOpenOrderRequest.builder().timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(optionOpenOrders);


        System.out.println("\n ------new option myTrades-----");
        List<OptionMatchResult> optionMatchResults
                = client.getOptionMyTrades(OptionTradeRequest.builder().symbol("BTC0226CS4000").timestamp(new Date().getTime()).recvWindow(5_000L).build());
        System.out.println(optionMatchResults);
    }
}

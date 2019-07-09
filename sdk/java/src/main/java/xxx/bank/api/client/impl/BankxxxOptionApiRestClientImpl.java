package xxx.bank.api.client.impl;

import java.util.List;

import xxx.bank.api.client.BankxxxOptionApiRestClient;
import xxx.bank.api.client.domain.account.request.CancelOrderRequest;
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
import xxx.bank.api.client.service.BankxxxOptionApiService;

import static xxx.bank.api.client.impl.BankxxxApiServiceGenerator.createService;

/**
 * Implementation of Bankxxx's Option REST API using Retrofit with synchronous/blocking method calls.
 */
public class BankxxxOptionApiRestClientImpl implements BankxxxOptionApiRestClient {

    private final BankxxxOptionApiService bankxxxOptionApiService;

    public BankxxxOptionApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        bankxxxOptionApiService = BankxxxApiServiceGenerator.createService(baseUrl, BankxxxOptionApiService.class, apiKey, secret);
    }

    @Override
    public List<TokenOptionResult> getOptions(OptionsRequest request) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.getOptions(request.getExpired()));
    }

    @Override
    public OptionOrderResult newOptionOrder(OptionOrderRequest request) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.newOptionOrder(
                request.getSymbol(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getOrderType() == null ? "" : request.getOrderType().name(),
                request.getTimeInForce().name(),
                request.getQuantity(),
                request.getPrice(),
                request.getClientOrderId(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public OptionOrderResult cancelOptionOrder(CancelOrderRequest cancelOrderRequest) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.cancelOptionOrder(
                cancelOrderRequest.getOrderId(),
                cancelOrderRequest.getClientOrderId(),
                cancelOrderRequest.getRecvWindow(),
                cancelOrderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionOpenOrders(OptionOpenOrderRequest orderRequest) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.getOptionOpenOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderId(),
                orderRequest.getLimit(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionOrderResult> getOptionHistoryOrders(OptionHistoryOrderRequest orderRequest) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.getOptionHistoryOrders(
                orderRequest.getSymbol(),
                orderRequest.getOrderSide() == null ? "" : orderRequest.getOrderSide().name(),
                orderRequest.getOrderType() == null ? "" : orderRequest.getOrderType().name(),
                orderRequest.getLimit(),
                orderRequest.getOrderStatus() == null ? "" : orderRequest.getOrderStatus().name(),
                orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()
        ));
    }

    @Override
    public List<OptionMatchResult> getOptionMyTrades(OptionTradeRequest request) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.getOptionMyTrades(
                request.getSymbol(),
                request.getFromId(),
                request.getToId(),
                request.getLimit(),
                request.getOrderSide() == null ? "" : request.getOrderSide().name(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<PositionResult> getOptionPositions(OptionPositionRequest request) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.getOptionPositions(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }

    @Override
    public List<SettlementResult> getOptionSettlements(OptionSettlementRequest request) {
        return BankxxxApiServiceGenerator.executeSync(bankxxxOptionApiService.getOptionSettlements(
                request.getSymbol(),
                request.getRecvWindow(),
                request.getTimestamp()
        ));
    }
}

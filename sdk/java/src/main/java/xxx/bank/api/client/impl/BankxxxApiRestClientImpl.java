package xxx.bank.api.client.impl;

import xxx.bank.api.client.BankxxxApiRestClient;
import xxx.bank.api.client.domain.account.*;
import xxx.bank.api.client.domain.general.BrokerInfo;
import xxx.bank.api.client.domain.market.*;
import xxx.bank.api.client.service.BankxxxApiService;
import xxx.bank.api.client.domain.account.request.*;

import java.util.List;

import static xxx.bank.api.client.impl.BankxxxApiServiceGenerator.createService;
import static xxx.bank.api.client.impl.BankxxxApiServiceGenerator.executeSync;

/**
 * Implementation of Bankxxx's REST API using Retrofit with synchronous/blocking method calls.
 */
public class BankxxxApiRestClientImpl implements BankxxxApiRestClient {

    private final BankxxxApiService bankxxxApiService;

    public BankxxxApiRestClientImpl(String baseUrl, String apiKey, String secret) {
        bankxxxApiService = createService(baseUrl, BankxxxApiService.class, apiKey, secret);
    }

    // General endpoints

    @Override
    public void ping() {
        executeSync(bankxxxApiService.ping());
    }

    @Override
    public Long getServerTime() {
        return executeSync(bankxxxApiService.getServerTime()).getServerTime();
    }

    @Override
    public BrokerInfo getBrokerInfo() {
        return executeSync(bankxxxApiService.getBrokerInfo());
    }

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return executeSync(bankxxxApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getTrades(String symbol, Integer limit) {
        return executeSync(bankxxxApiService.getTrades(symbol, limit));
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Long startTime, Long endTime, Integer limit) {
        return executeSync(bankxxxApiService.getCandlestickBars(symbol, interval.getIntervalId(), startTime, endTime, limit));
    }

    @Override
    public TickerStatistics get24HrPriceStatistics(String symbol) {
        return executeSync(bankxxxApiService.get24HrPriceStatistics(symbol));
    }

    @Override
    public TickerPrice getPrice(String symbol) {
        return executeSync(bankxxxApiService.getLatestPrice(symbol));
    }

    @Override
    public BookTicker getBookTicker(String symbol) {
        return executeSync(bankxxxApiService.getBookTicker(symbol));
    }

    @Override
    public Index getIndex(String symbol) {
        return executeSync(bankxxxApiService.getIndex(symbol));
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        return executeSync(bankxxxApiService.newOrder(order.getSymbol(), order.getSide(), order.getType(),
                order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
                order.getIcebergQty(), order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public Order getOrderStatus(OrderStatusRequest orderStatusRequest) {
        return executeSync(bankxxxApiService.getOrderStatus(orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(bankxxxApiService.cancelOrder(cancelOrderRequest.getOrderId(), cancelOrderRequest.getClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getOpenOrders(OpenOrderRequest orderRequest) {
        return executeSync(bankxxxApiService.getOpenOrders(orderRequest.getSymbol(), orderRequest.getLimit(),
                orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getHistoryOrders(HistoryOrderRequest orderRequest) {
        return executeSync(bankxxxApiService.getHistroyOrders(orderRequest.getOrderId(), orderRequest.getStartTime(), orderRequest.getEndTime(),
                orderRequest.getLimit(), orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public Account getAccount(Long recvWindow, Long timestamp) {
        return executeSync(bankxxxApiService.getAccount(recvWindow, timestamp));
    }

    @Override
    public List<Trade> getMyTrades(MyTradeRequest request) {
        return executeSync(bankxxxApiService.getMyTrades(request.getFromId(), request.getToId(), request.getStartTime(), request.getEndTime(),
                request.getLimit(), request.getRecvWindow(), request.getTimestamp()));
    }

    @Override
    public List<DepositOrder> getDepositOrders(DepositOrderRequest request) {
        return executeSync(bankxxxApiService.getDepositOrders(request.getToken(), request.getStartTime(), request.getEndTime(), request.getFromId(),
                request.getLimit(), request.getRecvWindow(), request.getTimestamp()));
    }

    @Override
    public String startUserDataStream(Long recvWindow, Long timestamp) {
        return executeSync(bankxxxApiService.startUserDataStream(recvWindow, timestamp)).toString();
    }

    @Override
    public void keepAliveUserDataStream(String listenKey, Long recvWindow, Long timestamp) {
        executeSync(bankxxxApiService.keepAliveUserDataStream(listenKey, recvWindow, timestamp));
    }

    @Override
    public void closeUserDataStream(String listenKey, Long recvWindow, Long timestamp) {
        executeSync(bankxxxApiService.closeAliveUserDataStream(listenKey, recvWindow, timestamp));
    }

}

package xxx.bank.api.client.service;

import xxx.bank.api.client.constant.BankxxxConstants;
import xxx.bank.api.client.domain.account.*;
import xxx.bank.api.client.domain.general.BrokerInfo;
import xxx.bank.api.client.domain.general.ServerTime;
import retrofit2.Call;
import retrofit2.http.*;
import xxx.bank.api.client.domain.market.*;

import java.util.List;

/**
 * Bankxxx's REST API URL mappings and endpoint security configuration.
 */
public interface BankxxxApiService {

    // General endpoints
    @GET("/openapi/quote/v1/ping")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<Void> ping();

    @GET("/openapi/quote/v1/time")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<ServerTime> getServerTime();

    @GET("/openapi/v1/brokerInfo")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<BrokerInfo> getBrokerInfo();

    // Market Data endpoints

    @GET("/openapi/quote/v1/depth")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @GET("/openapi/quote/v1/trades")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<List<TradeHistoryItem>> getTrades(@Query("symbol") String symbol, @Query("limit") Integer limit);


    @GET("/openapi/quote/v1/klines")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol,
                                               @Query("interval") String interval,
                                               @Query("startTime") Long startTime,
                                               @Query("endTime") Long endTime,
                                               @Query("limit") Integer limit);

    @GET("/openapi/quote/v1/ticker/24hr")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

    @GET("/openapi/quote/v1/ticker/price")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);

    @GET("/openapi/quote/v1/ticker/bookTicker")
    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    Call<BookTicker> getBookTicker(@Query("symbol") String symbol);

    @GET("/openapi/quote/v1/index")
    Call<Index> getIndex(@Query("symbol") String symbol);

    // Account endpoints

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/openapi/account/v1/order")
    Call<NewOrderResponse> newOrder(@Query("symbol") String symbol,
                                    @Query("side") OrderSide side,
                                    @Query("type") OrderType type,
                                    @Query("timeInForce") TimeInForce timeInForce,
                                    @Query("quantity") String quantity,
                                    @Query("price") String price,
                                    @Query("newClientOrderId") String newClientOrderId,
                                    @Query("stopPrice") String stopPrice,
                                    @Query("icebergQty") String icebergQty,
                                    @Query("recvWindow") Long recvWindow,
                                    @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/openapi/account/v1/order")
    Call<Order> getOrderStatus(@Query("orderId") Long orderId,
                               @Query("origClientOrderId") String origClientOrderId,
                               @Query("recvWindow") Long recvWindow,
                               @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/openapi/account/v1/order")
    Call<CancelOrderResponse> cancelOrder(@Query("orderId") Long orderId,
                                          @Query("clientOrderId") String clientOrderId,
                                          @Query("recvWindow") Long recvWindow,
                                          @Query("timestamp") Long timestamp);


    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/openapi/account/v1/openOrders")
    Call<List<Order>> getOpenOrders(@Query("symbol") String symbol,
                                    @Query("limit") Integer limit,
                                    @Query("recvWindow") Long recvWindow,
                                    @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/openapi/account/v1/historyOrders")
    Call<List<Order>> getHistroyOrders(@Query("orderId") Long orderId,
                                       @Query("startTime") Long startTime,
                                       @Query("endTime") Long endTime,
                                       @Query("limit") Integer limit,
                                       @Query("recvWindow") Long recvWindow,
                                       @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/openapi/account/v1/account")
    Call<Account> getAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/openapi/account/v1/myTrades")
    Call<List<Trade>> getMyTrades(@Query("fromId") Long fromId,
                                  @Query("toId") Long toId,
                                  @Query("startTime") Long startTime,
                                  @Query("endTime") Long endTime,
                                  @Query("limit") Integer limit,
                                  @Query("recvWindow") Long recvWindow,
                                  @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/openapi/account/v1/depositOrders")
    Call<List<DepositOrder>> getDepositOrders(@Query("token") String token,
                                              @Query("startTime") Long startTime,
                                              @Query("endTime") Long endTime,
                                              @Query("fromId") Long fromId,
                                              @Query("limit") Integer limit,
                                              @Query("recvWindow") Long recvWindow,
                                              @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/openapi/account/v1/userDataStream")
    Call<ListenKey> startUserDataStream(@Query("recvWindow") Long recvWindow,
                                        @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @PUT("/openapi/account/v1/userDataStream")
    Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey,
                                       @Query("recvWindow") Long recvWindow,
                                       @Query("timestamp") Long timestamp);

    @Headers(BankxxxConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/openapi/account/v1/userDataStream")
    Call<Void> closeAliveUserDataStream(@Query("listenKey") String listenKey,
                                        @Query("recvWindow") Long recvWindow,
                                        @Query("timestamp") Long timestamp);

}

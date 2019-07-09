package xxx.bank.api.client;


import xxx.bank.api.client.domain.account.SocketUserResponse;
import xxx.bank.api.client.domain.event.CandlestickEvent;
import xxx.bank.api.client.domain.event.DepthEvent;
import xxx.bank.api.client.domain.event.IndexEvent;
import xxx.bank.api.client.domain.event.TickerEvent;
import xxx.bank.api.client.domain.event.TradeEvent;
import xxx.bank.api.client.domain.market.CandlestickInterval;

import java.io.Closeable;

/**
 * Bankxxx API data streaming façade, supporting streaming of events through web sockets.
 */
public interface BankxxxApiWebSocketClient extends Closeable {

    /**
     * Open a new web socket to receive {@link DepthEvent depthEvents} on a callback.
     *
     * @param symbols   SYMBOL must be form with exchangeId.symbol like 'BTCUSDT'
     * @param callback  the callback to call on new events
     * @param autoRetry setting the choose to auto retry connect socket
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onDepthEvent(String symbols, BankxxxApiCallback<DepthEvent> callback, boolean autoRetry);

    Closeable onDepthEvent(String symbols, BankxxxApiCallback<DepthEvent> callback);

    /**
     * Open a new web socket to receive {@link CandlestickEvent candlestickEvents} on a callback.
     *
     * @param symbols   SYMBOL must be form with exchangeId.symbol like 'BTCUSDT'
     * @param interval  the interval of the candles tick events required
     * @param callback  the callback to call on new events
     * @param autoRetry setting the choose to auto retry connect socket
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */

    Closeable onCandlestickEvent(String symbols, CandlestickInterval interval, BankxxxApiCallback<CandlestickEvent> callback, boolean autoRetry);

    Closeable onCandlestickEvent(String symbols, CandlestickInterval interval, BankxxxApiCallback<CandlestickEvent> callback);


    /**
     * Open a new web socket to receive {@link TradeEvent} on a callback
     *
     * @param symbols   SYMBOL must be form with exchangeId.symbol like 'BTCUSDT'
     * @param callback  the callback to call on new events
     * @param autoRetry setting the choose to auto retry connect socket
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onTradeEvent(String symbols, BankxxxApiCallback<TradeEvent> callback, boolean autoRetry);

    Closeable onTradeEvent(String symbols, BankxxxApiCallback<TradeEvent> callback);

    /**
     * Open a new web socket to receive {@link TickerEvent} on a callback
     *
     * @param symbols   SYMBOL must be form with exchangeId.symbol like 'BTCUSDT'
     * @param callback  the callback to call on new events
     * @param autoRetry setting the choose to auto retry connect socket
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onTicker24HourEvent(String symbols, BankxxxApiCallback<TickerEvent> callback, boolean autoRetry);

    Closeable onTicker24HourEvent(String symbols, BankxxxApiCallback<TickerEvent> callback);

    /**
     * Open a new web socket to receive {@link IndexEvent} on a callback
     *
     * @param symbols   SYMBOL must be form with symbol like 'BTCUSDT'
     * @param callback  the callback to call on new events
     * @param autoRetry setting the choose to auto retry connect socket
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onIndexEvent(String symbols, BankxxxApiCallback<IndexEvent> callback, boolean autoRetry);

    Closeable onIndexEvent(String symbols, BankxxxApiCallback<IndexEvent> callback);

    /**
     * Open a new web socket for account infomations on a callback
     *
     * @param listenKey user stream start key
     * @param callback  the callback to call on new events
     * @param autoRetry setting the choose to auto retry connect socket
     * @return
     */
    Closeable onUserEvent(String listenKey, BankxxxApiCallback<SocketUserResponse> callback, boolean autoRetry);

    Closeable onUserEvent(String listenKey, BankxxxApiCallback<SocketUserResponse> callback);
}

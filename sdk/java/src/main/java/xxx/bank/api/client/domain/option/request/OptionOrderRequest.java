package xxx.bank.api.client.domain.option.request;

import xxx.bank.api.client.domain.account.OrderSide;
import xxx.bank.api.client.domain.account.OrderType;
import xxx.bank.api.client.domain.account.TimeInForce;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionOrderRequest {

    private String symbol;

    private OrderSide orderSide;

    private OrderType orderType;

    private TimeInForce timeInForce;

    private String quantity;

    private String price;

    private String clientOrderId;

    private Long recvWindow;

    private Long timestamp;
}

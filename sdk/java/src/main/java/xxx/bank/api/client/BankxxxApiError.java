package xxx.bank.api.client;

import xxx.bank.api.client.constant.BankxxxConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Bankxxx API error object.
 */
public class BankxxxApiError {

    /**
     * Error code.
     */
    private int code;

    /**
     * Error message.
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BankxxxConstants.TO_STRING_BUILDER_STYLE)
                .append("code", code)
                .append("msg", msg)
                .toString();
    }
}

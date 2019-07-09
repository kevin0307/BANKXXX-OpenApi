package xxx.bank.api.client.exception;

import xxx.bank.api.client.BankxxxApiError;

/**
 * An exception which can occur while invoking methods of the Bankxxx API.
 */
public class BankxxxApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by Bankxxx API.
     */
    private BankxxxApiError error;

    /**
     * Instantiates a new Bankxxx api exception.
     *
     * @param error an error response object
     */
    public BankxxxApiException(BankxxxApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new Bankxxx api exception.
     */
    public BankxxxApiException() {
        super();
    }

    /**
     * Instantiates a new Bankxxx api exception.
     *
     * @param message the message
     */
    public BankxxxApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Bankxxx api exception.
     *
     * @param cause the cause
     */
    public BankxxxApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Bankxxx api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BankxxxApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Bankxxx API, or null if no response object was returned (e.g. server returned 500).
     */
    public BankxxxApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}

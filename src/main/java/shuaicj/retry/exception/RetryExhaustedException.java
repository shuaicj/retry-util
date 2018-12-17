package shuaicj.retry.exception;

/**
 * The exception thrown when retry exhausted.
 */
@SuppressWarnings("serial")
public class RetryExhaustedException extends RetryException {

    private final Object result;

    public RetryExhaustedException() {
        super();
        this.result = null;
    }

    public RetryExhaustedException(String message) {
        super(message);
        this.result = null;
    }

    public RetryExhaustedException(Throwable cause) {
        super(cause);
        this.result = null;
    }

    public RetryExhaustedException(String message, Throwable cause) {
        super(message, cause);
        this.result = null;
    }

    public RetryExhaustedException(Object result) {
        super();
        this.result = result;
    }

    public RetryExhaustedException(Object result, String message) {
        super(message);
        this.result = result;
    }

    public RetryExhaustedException(Object result, Throwable cause) {
        super(cause);
        this.result = result;
    }

    public RetryExhaustedException(Object result, String message, Throwable cause) {
        super(message, cause);
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}

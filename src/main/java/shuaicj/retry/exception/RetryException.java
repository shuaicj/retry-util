package shuaicj.retry.exception;

/**
 * The base exception thrown when retry failed.
 */
@SuppressWarnings("serial")
public class RetryException extends RuntimeException {

    public RetryException() {
        super();
    }

    public RetryException(String message) {
        super(message);
    }

    public RetryException(Throwable cause) {
        super(cause);
    }

    public RetryException(String message, Throwable cause) {
        super(message, cause);
    }
}

package shuaicj.retry.exception;

/**
 * The base exception thrown when retry failed.
 */
@SuppressWarnings("serial")
public class RetryException extends RuntimeException {

    public RetryException(String message) {
        super(message);
    }

    public RetryException(String message, Throwable cause) {
        super(message, cause);
    }
}

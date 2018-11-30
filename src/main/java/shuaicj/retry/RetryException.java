package shuaicj.retry;

/**
 * The exception thrown when retry failed.
 */
@SuppressWarnings("serial")
public class RetryException extends RuntimeException {

    public RetryException(String message, Throwable cause) {
        super(message, cause);
    }
}

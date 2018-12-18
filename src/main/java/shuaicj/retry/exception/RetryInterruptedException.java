package shuaicj.retry.exception;

/**
 * The exception thrown when retry interrupted.
 */
@SuppressWarnings("serial")
public class RetryInterruptedException extends RetryException {

    public RetryInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }
}

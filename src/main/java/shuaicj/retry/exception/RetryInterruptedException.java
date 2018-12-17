package shuaicj.retry.exception;

/**
 * The exception thrown when retry interrupted.
 */
@SuppressWarnings("serial")
public class RetryInterruptedException extends RetryException {

    public RetryInterruptedException() {
        super();
    }

    public RetryInterruptedException(String message) {
        super(message);
    }

    public RetryInterruptedException(Throwable cause) {
        super(cause);
    }

    public RetryInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }
}

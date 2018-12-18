package shuaicj.retry.exception;

/**
 * The exception thrown when the {@link java.util.concurrent.Callable}
 * or {@link shuaicj.retry.RetryRunnable} throws exceptions in the final attempt.
 */
@SuppressWarnings("serial")
public class RetryExecutionException extends RetryException {

    public RetryExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}

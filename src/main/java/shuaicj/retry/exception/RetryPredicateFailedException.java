package shuaicj.retry.exception;

/**
 * The exception thrown when the predicate itself throws exceptions.
 */
@SuppressWarnings("serial")
public class RetryPredicateFailedException extends RetryExhaustedException {

    public RetryPredicateFailedException() {
        super();
    }

    public RetryPredicateFailedException(String message) {
        super(message);
    }

    public RetryPredicateFailedException(Throwable cause) {
        super(cause);
    }

    public RetryPredicateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetryPredicateFailedException(Object result) {
        super(result);
    }

    public RetryPredicateFailedException(Object result, String message) {
        super(result, message);
    }

    public RetryPredicateFailedException(Object result, Throwable cause) {
        super(result, cause);
    }

    public RetryPredicateFailedException(Object result, String message, Throwable cause) {
        super(result, message, cause);
    }
}

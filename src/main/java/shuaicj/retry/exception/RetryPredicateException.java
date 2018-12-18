package shuaicj.retry.exception;

/**
 * The exception thrown when the retry predicate goes wrong in the final attempt.
 */
@SuppressWarnings("serial")
public class RetryPredicateException extends RetryException {

    private final Object result;

    public RetryPredicateException(Object result, String message) {
        super(message);
        this.result = result;
    }

    public RetryPredicateException(Object result, String message, Throwable cause) {
        super(message, cause);
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}

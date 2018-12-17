package shuaicj.retry.exception;

/**
 * The exception thrown when the predicate returns false.
 */
@SuppressWarnings("serial")
public class RetryPredicateFalseException extends RetryExhaustedException {

    public RetryPredicateFalseException() {
        super();
    }

    public RetryPredicateFalseException(String message) {
        super(message);
    }

    public RetryPredicateFalseException(Throwable cause) {
        super(cause);
    }

    public RetryPredicateFalseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetryPredicateFalseException(Object result) {
        super(result);
    }

    public RetryPredicateFalseException(Object result, String message) {
        super(result, message);
    }

    public RetryPredicateFalseException(Object result, Throwable cause) {
        super(result, cause);
    }

    public RetryPredicateFalseException(Object result, String message, Throwable cause) {
        super(result, message, cause);
    }
}

package shuaicj.retry.exception;

/**
 * The exception thrown when the predicate itself throws exceptions in the final attempt.
 */
@SuppressWarnings("serial")
public class RetryPredicateFailedException extends RetryPredicateException {

    public RetryPredicateFailedException(Object result, String message, Throwable cause) {
        super(result, message, cause);
    }
}

package shuaicj.retry.exception;

/**
 * The exception thrown when the predicate returns false in the final attempt.
 */
@SuppressWarnings("serial")
public class RetryPredicateFalseException extends RetryPredicateException {

    public RetryPredicateFalseException(Object result, String message) {
        super(result, message);
    }
}

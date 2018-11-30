package shuaicj.retry;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The retry util.
 */
public class RetryUtil {

    private static final Logger logger = LoggerFactory.getLogger(RetryUtil.class);

    public static final long DEFAULT_RETRIES = 3L;
    public static final long DEFAULT_DELAY = 5000L; // the unit of delay is millisecond

    public static <T> T retryForever(String message, Callable<T> callable) throws RetryException {
        return retry(message, callable, t -> true, Long.MAX_VALUE, DEFAULT_DELAY);
    }

    public static <T> T retryForever(String message, Callable<T> callable, long delayMillis) throws RetryException {
        return retry(message, callable, t -> true, Long.MAX_VALUE, delayMillis);
    }

    public static void retryForever(String message, RetryRunnable runnable) throws RetryException {
        retry(message, runnable, () -> true, Long.MAX_VALUE, DEFAULT_DELAY);
    }

    public static void retryForever(String message, RetryRunnable runnable, long delayMillis) throws RetryException {
        retry(message, runnable, () -> true, Long.MAX_VALUE, delayMillis);
    }

    public static <T> T retryUntil(String message, Callable<T> callable, Predicate<T> until) throws RetryException {
        return retry(message, callable, until, Long.MAX_VALUE, DEFAULT_DELAY);
    }

    public static <T> T retryUntil(String message, Callable<T> callable, Predicate<T> until, long delayMillis)
            throws RetryException {
        return retry(message, callable, until, Long.MAX_VALUE, delayMillis);
    }

    public static void retryUntil(String message, RetryRunnable runnable, RetryPredicate until) throws RetryException {
        retry(message, runnable, until, Long.MAX_VALUE, DEFAULT_DELAY);
    }

    public static void retryUntil(String message, RetryRunnable runnable, RetryPredicate until, long delayMillis)
            throws RetryException {
        retry(message, runnable, until, Long.MAX_VALUE, delayMillis);
    }

    public static <T> T retry(String message, Callable<T> callable) throws RetryException {
        return retry(message, callable, t -> true, DEFAULT_RETRIES, DEFAULT_DELAY);
    }

    public static <T> T retry(String message, Callable<T> callable, long maxRetries) throws RetryException {
        return retry(message, callable, t -> true, maxRetries, DEFAULT_DELAY);
    }

    public static <T> T retry(String message, Callable<T> callable, long maxRetries, long delayMillis)
            throws RetryException {
        return retry(message, callable, t -> true, maxRetries, delayMillis);
    }

    public static void retry(String message, RetryRunnable runnable) throws RetryException {
        retry(message, runnable, () -> true, DEFAULT_RETRIES, DEFAULT_DELAY);
    }

    public static void retry(String message, RetryRunnable runnable, long maxRetries) throws RetryException {
        retry(message, runnable, () -> true, maxRetries, DEFAULT_DELAY);
    }

    public static void retry(String message, RetryRunnable runnable, long maxRetries, long delayMillis)
            throws RetryException {
        retry(message, runnable, () -> true, maxRetries, delayMillis);
    }

    /**
     * Retry if any exception is thrown in 'callable', or the retry test returns false in 'until'.
     * The result will be returned if success.
     *
     * @param message message to print in retry
     * @param callable the real operation
     * @param until the retry test, returns false if next retry is required
     * @param maxRetries max times of retry
     * @param delayMillis delay in milliseconds between retries
     * @param <T> the return type
     * @return the callable result
     * @throws RetryException if retry failed finally
     */
    public static <T> T retry(String message, Callable<T> callable, Predicate<T> until,
                              long maxRetries, long delayMillis) throws RetryException {
        for (long i = 0; i < maxRetries; i++) {
            try {
                T rt = callable.call();
                if (!until.test(rt)) {
                    throw new IllegalStateException("the retry test returns false");
                }
                return rt;
            } catch (Throwable e) {
                logger.error(message + " retry " + i + " failed, " + e.toString());
                if (i == maxRetries - 1) {
                    throw new RetryException(message + " retry " + i + " failed finally", e);
                }
                sleep(delayMillis, message + " retry " + i + " interrupted");
            }
        }
        // impossible to be here
        return null;
    }

    /**
     * Retry if any exception is thrown in 'runnable', or the retry test returns false in 'until'.
     *
     * @param message message to print in retry
     * @param runnable the real operation
     * @param until the retry test, returns false if next retry is required
     * @param maxRetries max times of retry
     * @param delayMillis delay in milliseconds between retries
     * @throws RetryException if retry failed finally
     */
    public static void retry(String message, RetryRunnable runnable, RetryPredicate until,
                             long maxRetries, long delayMillis) throws RetryException {
        for (long i = 0; i < maxRetries; i++) {
            try {
                runnable.run();
                if (!until.test()) {
                    throw new IllegalStateException("the retry test returns false");
                }
                return;
            } catch (Throwable e) {
                logger.error(message + " retry " + i + " failed, " + e.toString());
                if (i == maxRetries - 1) {
                    throw new RetryException(message + " retry " + i + " failed finally", e);
                }
                sleep(delayMillis, message + " retry " + i + " interrupted");
            }
        }
    }

    private static void sleep(long millis, String message) throws RetryException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RetryException(message, e);
        }
    }
}
